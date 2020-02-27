package org.uptospeed.backend.webservices;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.uptospeed.backend.data.RequestData;
import org.uptospeed.backend.exceptions.CommonException;
import org.uptospeed.backend.services.DataService;
import org.uptospeed.backend.services.TextService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("analyze")
@Consumes(MediaType.APPLICATION_JSON)
public class AnalysisResources
{
    private Logger LOG = LoggerFactory.getLogger(AnalysisResources.class);

    @Inject
    @RestClient
    TextService service;

    @Inject
    DataService dataService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertText(final RequestData text) throws IOException {
        LOG.info("Text received and being analyzed. text={}", text);
        try {
            this.dataService.createText(text);
            System.out.println(text.toString());
            return Response.ok()
                    .entity(this.service.analyze(text))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        } catch (CommonException exception) {
            return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
        }
    }



}