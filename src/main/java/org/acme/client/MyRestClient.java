package org.acme.client;

import org.acme.MyEnum;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestQuery;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("")
@RegisterRestClient(configKey = "test")
public interface MyRestClient {

    @GET @Path("get")
    GetResponse get(@RestQuery MyEnum myEnum);

    @POST @Path("post")
    PostResponse post(@RestForm MyEnum myEnum);
}
