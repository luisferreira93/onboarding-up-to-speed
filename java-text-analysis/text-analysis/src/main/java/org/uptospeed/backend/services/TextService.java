package org.uptospeed.backend.services;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.uptospeed.backend.data.RequestData;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/")
@RegisterRestClient
public interface TextService
{
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    String analyze(final RequestData text) throws IOException;
}