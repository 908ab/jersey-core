package miyakawalab.tool.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ResponseUtil {
    private ResponseUtil() {}

    public static Response.ResponseBuilder created(Location... locations) {
        String location = Arrays.stream(locations)
            .map(Location::toString)
            .collect(Collectors.joining("/"));
        return Response.status(Response.Status.CREATED).header("Location", location);
    }


    @AllArgsConstructor
    @Data
    public static class Location {
        private String path;
        private Long id;

        @Override
        public String toString() {
            return this.path + "/" + this.id;
        }
    }
}
