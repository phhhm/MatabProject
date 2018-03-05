package controller;

import biz.FileBiz;
import biz.ValidationException;
import biz.dto.FileDto;
import biz.dto.PatientDto;
import biz.dto.TransactionDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by parham on 10/28/2017.
 */
@Path("/file")
public class FileController {

    @Inject
    private FileBiz fileBiz;

    @GET
    @Produces("application/json")
    public Response getAll(){
        try {
            List<FileDto> fileDtoList = fileBiz.getAll();
            return Response.status(Response.Status.OK).entity(fileDtoList).build();

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
            FileDto fileDto = fileBiz.getById(id);
            return Response.status(Response.Status.OK).entity(fileDto).build();

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
    public Response doAdd(FileDto fileDto){
        try {
            fileBiz.add(fileDto);
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
    public Response doEdit(FileDto fileDto){
        try {
            fileBiz.edit(fileDto);
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
            fileBiz.removeAll();
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
            fileBiz.remove(id);
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
    public Response getTransactionWithNoDuplicate(){
        try {
            List<TransactionDto> transactionDtoList = fileBiz.getTransactionWithNoDuplicate();
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

    @GET
    @Path("/get_patient")
    @Produces("application/json")
    public Response getPatientWithNoDuplicate(){
        try {
            List<PatientDto> patientDtoList = fileBiz.getPatientWithNoDuplicate();
            return Response.status(Response.Status.OK).entity(patientDtoList).build();
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
