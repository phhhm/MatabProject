package controller;

import biz.PrescriptionDrugBiz;
import biz.ValidationException;
import biz.dto.PrescriptionDrugDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/prescriptionDrug")
public class PrescriptionDrugController {

    @Inject
    private PrescriptionDrugBiz prescriptionDrugBiz;

    @GET
    @Produces("application/json")
    public Response getAll(){
        try {
            List<PrescriptionDrugDto> prescriptionDrugDtoList = prescriptionDrugBiz.getAll();
            return Response.status(Response.Status.OK).entity(prescriptionDrugDtoList).build();

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
            PrescriptionDrugDto prescriptionDrugDto = prescriptionDrugBiz.getById(id);
            return Response.status(Response.Status.OK).entity(prescriptionDrugDto).build();

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
    public Response doAdd(PrescriptionDrugDto prescriptionDrugDto){
        try {
            prescriptionDrugBiz.add(prescriptionDrugDto);
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
    public Response doEdit(PrescriptionDrugDto prescriptionDrugDto){
        try {
            prescriptionDrugBiz.edit(prescriptionDrugDto);
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
            prescriptionDrugBiz.removeAll();
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
            prescriptionDrugBiz.remove(id);
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
