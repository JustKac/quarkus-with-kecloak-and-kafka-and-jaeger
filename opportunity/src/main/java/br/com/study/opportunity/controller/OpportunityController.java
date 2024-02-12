package br.com.study.opportunity.controller;

import java.util.List;

import br.com.study.opportunity.dto.OpportunityDTO;
import br.com.study.opportunity.service.OpportunityService;
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