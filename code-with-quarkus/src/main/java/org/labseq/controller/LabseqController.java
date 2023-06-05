package org.labseq.controller;

import org.labseq.service.LabseqService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/labseq/{n}")
public class LabseqController {

    private LabseqService LabseqService = new LabseqService();

    @GET
    public Long getValue(@PathParam("n") String n) {
        return LabseqService.getValue(n);
    }
}
