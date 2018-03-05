package controller;

import biz.GiftBiz;
import biz.ValidationException;
import biz.dto.GiftDto;
import biz.dto.PaymentDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by parham on 27/10/2017.
 */
@Path("/gift")
public class GiftController {

    @Inject
    private GiftBiz giftBiz;

    @GET
    @Produces("application/json")
    public Response getAll(){
        try {
            List<GiftDto> giftDtoList = giftBiz.getAll();
            return Response.status(Response.Status.OK).entity(giftDtoList).build();

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
            GiftDto giftDto = giftBiz.getById(id);
            return Response.status(Response.Status.OK).entity(giftDto).build();

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
    public Response doAdd(GiftDto giftDto){
        try {
            giftBiz.add(giftDto);
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
    public Response doEdit(GiftDto giftDto){
        try {
            giftBiz.edit(giftDto);
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
            giftBiz.removeAll();
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
            giftBiz.remove(id);
            return Response.status(Response.Status.OK).build();

        } catch (ValidationException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/get_payment")
    @Produces("application/json")
    public Response getPaymentWithNoDuplicate(){
        try {
            List<PaymentDto> paymentDtoList = giftBiz.getPaymentWithNoDuplicate();
            return Response.status(Response.Status.OK).entity(paymentDtoList).build();
        }
        catch (ValidationException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
