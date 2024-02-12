package br.com.study.opportunity.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.study.opportunity.dto.OpportunityDTO;
import br.com.study.opportunity.dto.ProposalDTO;
import br.com.study.opportunity.dto.QuotationDTO;
import br.com.study.opportunity.entity.Opportunity;
import br.com.study.opportunity.entity.Quotation;
import br.com.study.opportunity.repository.OpportunityRepository;
import br.com.study.opportunity.repository.QuotationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OpportunityServiceImpl implements OpportunityService {

    @Inject
    QuotationRepository quotationRepository;

    @Inject
    OpportunityRepository opportunityRepository;

    @Override
    public void buildOpportunity(ProposalDTO proposal) {

        List<Quotation> quotationEntities = quotationRepository.findAll().list();
        Collections.reverse(quotationEntities);

        Opportunity opportunity = new Opportunity()
                .setDate(LocalDateTime.now())
                .setProposalId(proposal.getProposalId())
                .setCustomer(proposal.getCustomer())
                .setPriceTonne(proposal.getPriceTonne())
                .setLastDollarQuotation(quotationEntities.get(0).getCurrencyPrice());

        opportunityRepository.persist(opportunity);

    }

    @Override
    @Transactional
    public void saveQuotation(QuotationDTO quotation) {

        Quotation createQuotation = new Quotation()
                .setDate(LocalDateTime.now())
                .setCurrencyPrice(quotation.getCurrencyPrice());

        quotationRepository.persist(createQuotation);

    }

    @Override
    public List<OpportunityDTO> generateOpportunityData() {

        List<OpportunityDTO> opportunities = new ArrayList<>();

        opportunityRepository
                .findAll()
                .stream()
                .forEach(item -> {
                    opportunities.add(new OpportunityDTO()
                            .setProposalId(item.getProposalId())
                            .setCustomer(item.getCustomer())
                            .setPriceTonne(item.getPriceTonne())
                            .setLastDollarQuotation(item.getLastDollarQuotation()));
                });

        return opportunities;

    }
}
