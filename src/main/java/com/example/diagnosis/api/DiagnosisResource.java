package com.example.diagnosis.api;


import com.example.diagnosis.core.DiagnosisService;
import com.example.diagnosis.core.Pathology;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Path("/diagnosis")
public class DiagnosisResource {


@Inject
DiagnosisService service;


/**
* Text endpoint (exactly as the screen expects):
* Example: GET /api/diagnosis/15 -> "Cardiologie, Traumatologie"
*/
@GET
@Path("/{index}")
@Produces(MediaType.TEXT_PLAIN)
public Response diagnosePlain(@PathParam("index") int index) {
String body = service.diagnoseAsString(index);
return Response.ok(body).build();
}


/**
* Optional JSON endpoint (useful for future front-ends / integrations).
* Example: GET /api/diagnosis/33 -> {"index":33,"units":["Cardiologie"]}
*/
@GET
@Path("/{index}/json")
@Produces(MediaType.APPLICATION_JSON)
public Response diagnoseJson(@PathParam("index") int index) {
List<Pathology> pathologies = service.diagnose(index);
Map<String, Object> payload = new HashMap<>();
payload.put("index", index);
payload.put("units", pathologies.stream().map(Pathology::label).toArray());
payload.put("display", service.diagnoseAsString(index));
return Response.ok(payload).build();
}
}