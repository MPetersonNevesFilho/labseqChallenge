package org.labseq.controller;

import org.labseq.service.LabseqService;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/labseq")
public class LabseqController {

    private LabseqService LabseqService = new LabseqService();

    @GET
    @Path("/{n}")
    public String getValue(@PathParam("n") String n) {
        //System.err.println("n: " + n);
        return String.valueOf(LabseqService.getValue(n));
    }

    @DELETE
    @Path("/{n}")
    public String deleteValue(@PathParam("n") String n) {
        LabseqService.deleteValue(n);
        return "Value deleted";
    }

    @DELETE
    @Path("/restart")
    public String restartMemory() {
        LabseqService.restartMemory();
        return "Memory restarted";
    }
}