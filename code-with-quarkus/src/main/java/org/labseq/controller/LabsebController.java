package org.labseq.controller;

import org.labseq.service.LabseqService;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/labseb/{n}")
public class LabsebController {

    private LabseqService labsebService;

    @GET
    public Integer getValue(@PathParam("n") String n) {
        return labsebService.getValue(n);
    }
}
