package controller;

import biz.DrugDeliveryBiz;
import biz.ValidationException;
import biz.dto.DrugDeliveryDto;
import biz.dto.TransactionDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/drugDelivery")
public class DrugDeliveryController {

    @Inject
    private DrugDeliveryBiz drugDeliveryBiz;

    @GET
    @Produces("application/json")
    public Response getAll(){
        try {
            List<DrugDeliveryDto> drugDeliveryDtoList = drugDeliveryBiz.getAll();
            return Response.status(Response.Status.OK).entity(drugDeliveryDtoList).build();

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
            DrugDeliveryDto drugDeliveryDto = drugDeliveryBiz.getById(id);
            return Response.status(Response.Status.OK).entity(drugDeliveryDto).build();

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
    public Response doAdd(DrugDeliveryDto drugDeliveryDto){
        try {
            drugDeliveryBiz.add(drugDeliveryDto);
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
    public Response doEdit(DrugDeliveryDto drugDeliveryDto){
        try {
            drugDeliveryBiz.edit(drugDeliveryDto);
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
            drugDeliveryBiz.removeAll();
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
            drugDeliveryBiz.remove(id);
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
    @Path("/get_transaction")
    @Produces("application/json")
    public Response getWithNoDuplicate(){
        try {
            List<TransactionDto> transactionDtoList = drugDeliveryBiz.getTransactionWithNoDuplicate();
            return Response.status(Response.Status.OK).entity(transactionDtoList).build();
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
