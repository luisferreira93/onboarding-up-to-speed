package org.uptospeed.backend.webservices;

import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(info = @Info(
        title = "Web Service",
        description = "The goal of the following service is to analyze a provided text.",
        version = "1.0.0"))
public class AnalysisResourceApplication extends Application
{
}