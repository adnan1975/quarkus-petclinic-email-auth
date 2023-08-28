package org.quarkus.samples.petclinic.system;

import io.quarkus.qute.TemplateInstance;
import io.vertx.core.http.HttpServerResponse;
import org.jboss.resteasy.reactive.RestResponse;

import javax.inject.Inject;
import javax.resource.spi.ConfigProperty;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import io.quarkus.logging.Log;

@Path("/logout")
public class LogoutResource {

    String cookieName = "quarkus-credential";

    @Inject
    UriInfo uriInfo;

    @POST
    public RestResponse<Object> logout(HttpServerResponse response) {
        URI loginUri = uriInfo.getRequestUriBuilder().replacePath("/login").build();
        Log.info(loginUri.toString());
        Log.info("tesing");
        // Note that we set invalidate=true to expire the cookie
        //response.removeCookie(cookieName, true);
        return RestResponse.seeOther(loginUri);
    }
}
