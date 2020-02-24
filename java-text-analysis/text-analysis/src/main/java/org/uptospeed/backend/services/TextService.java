package org.uptospeed.backend.services;

import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import java.io.IOException;
import javax.ws.rs.PathParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface TextService
{
    @POST
    @Path("{text}")
    @Produces({ "application/json" })
    String analyze(@PathParam("text") final String text) throws IOException;
}