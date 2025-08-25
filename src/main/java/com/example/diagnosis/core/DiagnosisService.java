package com.example.diagnosis.core;


import jakarta.enterprise.context.ApplicationScoped;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ApplicationScoped
public class DiagnosisService {


/**
* Returns the units as a single displayable string, per business rules.
* If no pathology is detected, returns "RAS" (rien à signaler).
*/
public String diagnoseAsString(int healthIndex) {
List<Pathology> pathologies = diagnose(healthIndex);
if (pathologies.isEmpty()) {
return "RAS"; // Unspecified in story; common hospital shorthand
}
return toDisplayString(pathologies);
}


/**
* Core rule engine: multiples of 3 => Cardiologie; multiples of 5 => Traumatologie.
* If both, both are returned; order is stable and business-driven.
*/
public List<Pathology> diagnose(int healthIndex) {
if (healthIndex == 0) {
// Define behavior for 0 explicitly: 0 is divisible by any number; here we choose both.
return List.of(Pathology.CARDIOLOGIE, Pathology.TRAUMATOLOGIE);
}
List<Pathology> result = new ArrayList<>(2);
if (healthIndex % 3 == 0) {
result.add(Pathology.CARDIOLOGIE);
}
if (healthIndex % 5 == 0) {
result.add(Pathology.TRAUMATOLOGIE);
}
return Collections.unmodifiableList(result);
}


private String toDisplayString(List<Pathology> pathologies) {
// Display order: Cardiologie, Traumatologie (stable)
StringBuilder sb = new StringBuilder();
for (int i = 0; i < pathologies.size(); i++) {
if (i > 0) sb.append(", ");
sb.append(pathologies.get(i).label());
}
return sb.toString();
}
}