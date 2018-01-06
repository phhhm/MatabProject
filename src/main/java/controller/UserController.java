package controller;

import biz.UserBiz;
import biz.dto.UserDto;
import com.sun.org.apache.regexp.internal.RE;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserController {

    @Inject
    private UserBiz userBiz;

    @POST
    @Path("/login")
    @Consumes("application/json")
    public Response login(UserDto userDto){
        Long id = userBiz.login(userDto);
        if (id == null)
            return Response.status(Response.Status.UNAUTHORIZED).build();
        else
            return Response.status(Response.Status.OK).entity("{\"id\":"+id+"}").build();
    }
}
