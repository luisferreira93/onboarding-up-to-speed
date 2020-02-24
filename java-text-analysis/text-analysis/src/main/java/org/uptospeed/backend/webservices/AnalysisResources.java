package org.uptospeed.backend.webservices;

import org.slf4j.LoggerFactory;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import java.io.IOException;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import org.uptospeed.backend.services.DataService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.inject.Inject;
import org.uptospeed.backend.services.TextService;
import org.slf4j.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;

@Path("analyze")
@Consumes({ "application/json" })
public class AnalysisResources
{
    private Logger LOG = LoggerFactory.getLogger(AnalysisResources.class);

    @Inject
    @RestClient
    TextService service;

    @Inject
    DataService dataService;

    @GET
    @Path("{text}")
    @Produces({ "application/json" })
    public Response insertText(@PathParam("text") final String text) throws IOException {
        LOG.info("Text received and being analyzed. text={}", text);
        this.dataService.createText(text);
        return Response.ok().header("content-type", "application/json").entity(this.service.analyze(text)).type("application/json").build();
    }



}