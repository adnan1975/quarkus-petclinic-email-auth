package org.quarkus.samples.petclinic.system;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/login.html")
public class LoginResource {
    
    @Inject
    TemplatesLocale templates;

    @GET
    @Produces(MediaType.TEXT_HTML)
    
    public TemplateInstance get(@QueryParam("error") String error) {
        return templates.login( error); // Render the template with an empty error message;
    }

}
