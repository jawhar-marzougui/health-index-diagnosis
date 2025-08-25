package com.example.diagnosis.api;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;


@ApplicationPath("/api")
public class ApplicationConfig extends Application {
// Empty on purpose. The annotation activates JAX-RS under /api.
}