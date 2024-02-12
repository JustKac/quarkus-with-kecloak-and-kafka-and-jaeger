package br.com.study.opportunity.service;

import java.util.List;

import br.com.study.opportunity.dto.OpportunityDTO;
import br.com.study.opportunity.dto.ProposalDTO;
import br.com.study.opportunity.dto.QuotationDTO;

public interface OpportunityService {

    void buildOpportunity(ProposalDTO proposal);

    void saveQuotation(QuotationDTO quotation);

    List<OpportunityDTO> generateOpportunityData();

}
