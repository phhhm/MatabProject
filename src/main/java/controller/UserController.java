package controller;

import biz.UserBiz;
import biz.ValidationException;
import biz.dto.UserDto;
import com.sun.org.apache.regexp.internal.RE;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

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

    @GET
    @Produces("application/json")
    public Response getAll(){
        try {
            List<UserDto> userDtoList = userBiz.getAll();
            return Response.status(Response.Status.OK).entity(userDtoList).build();

        } catch (ValidationException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getById(@PathParam("id") Long id){
        try {
            UserDto userDto = userBiz.getById(id);
            return Response.status(Response.Status.OK).entity(userDto).build();

        } catch (ValidationException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @Consumes("application/json")
    public Response doAdd(UserDto userDto){
        try {
            userBiz.add(userDto);
            return Response.status(Response.Status.OK).build();

        } catch (ValidationException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Consumes("application/json")
    public Response doEdit(UserDto userDto){
        try {
            userBiz.edit(userDto);
            return Response.status(Response.Status.OK).build();

        } catch (ValidationException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    public Response doDelete(){
        try {
            userBiz.removeAll();
            return Response.status(Response.Status.OK).build();

        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response doDeleteById(@PathParam("id") Long id){
        try {
            userBiz.remove(id);
            return Response.status(Response.Status.OK).build();

        } catch (ValidationException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
