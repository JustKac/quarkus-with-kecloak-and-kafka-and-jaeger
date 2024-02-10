package br.com.study.controller;

import java.util.List;

import br.com.study.dto.OpportunityDTO;
import br.com.study.service.OpportunityService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api/opportunity")
public class OpportunityController {

    @Inject
    OpportunityService opportunityService;

    @GET
    @Path("/data")
    public List<OpportunityDTO> generateReport() {
        return opportunityService.generateOpportunityData();
    }

}