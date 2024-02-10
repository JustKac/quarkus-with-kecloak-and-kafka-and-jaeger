package br.com.study.service;

import java.util.List;

import br.com.study.dto.OpportunityDTO;
import br.com.study.dto.ProposalDTO;
import br.com.study.dto.QuotationDTO;

public interface OpportunityService {

    void buildOpportunity(ProposalDTO proposal);

    void saveQuotation(QuotationDTO quotation);

    List<OpportunityDTO> generateOpportunityData();

}
