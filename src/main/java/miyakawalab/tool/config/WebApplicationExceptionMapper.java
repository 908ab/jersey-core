package miyakawalab.tool.config;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException e) {
        return Response.status(e.getResponse().getStatus())
            .entity(new ExceptionInformation(e.getResponse().getStatus(), e.getMessage()))
            .type(MediaType.APPLICATION_JSON)
            .build();
    }
}
