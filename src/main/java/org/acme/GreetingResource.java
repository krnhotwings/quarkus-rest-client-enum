package org.acme;

import org.acme.client.GetResponse;
import org.acme.client.MyRestClient;
import org.acme.client.PostResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestQuery;

import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("")
public class GreetingResource {

    @RestClient MyRestClient api;

    @GET @Path("resteasy")
    @Produces(MediaType.TEXT_PLAIN)
    public MyEnum restQueryEnum(@RestQuery MyEnum myEnum) {
        return myEnum;
    }

    @POST @Path("resteasy")
    @Produces(MediaType.TEXT_PLAIN)
    public MyEnum restBeanEnum(@RestForm MyEnum myEnum) {
        return myEnum;
    }

    @GET @Path("restclient")
    public GetResponse clientQueryEnum(@RestQuery MyEnum myEnum) {
        return api.get(myEnum);
    }

    @POST @Path("restclient")
    public PostResponse clientBeanEnum(@RestForm MyEnum myEnum) {
        return api.post(myEnum);
    }
}
