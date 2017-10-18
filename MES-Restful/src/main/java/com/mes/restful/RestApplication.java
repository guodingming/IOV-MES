package com.mes.restful;

import io.swagger.annotations.*;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@Api(value = "/rest/*", description = "All the apis")
@ApplicationPath("/rest/*")
public class RestApplication extends ResourceConfig {
    public RestApplication() {
//        register(ProductResource.class);
//        register(RequestContextFilter.class);
//        register(CORSResponseFilter.class);
//        register(JacksonFeature.class);

        register(RestConstraint.class);
        register(MultiPartFeature.class);
        register(RestJsonMapperProvider.class);
        register(JacksonFeature.class);
        register(UserOpLogRequestFilter.class);
//
//        register(io.swagger.jaxrs.listing.ApiListingResource.class);
//        register(io.swagger.jaxrs.listing.AcceptHeaderApiListingResource.class);
//        register(io.swagger.jaxrs.listing.SwaggerSerializers.class);

    }
}
