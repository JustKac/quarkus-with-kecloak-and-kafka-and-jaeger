package br.com.study.message;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.study.dto.ProposalDTO;
import br.com.study.dto.QuotationDTO;
import br.com.study.service.OpportunityService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

public class KafkaEvent {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

    @Inject
    OpportunityService opportunityService;

    @Incoming("proposal")
    @Transactional
    public void receiveProposal(ProposalDTO proposal) {
        LOG.info("-- Recebendo Nova Proposta do Tópico Kafka --");
        opportunityService.buildOpportunity(proposal);
    }

    @Incoming("quotation")
    @Blocking
    public void receiveQuotation(QuotationDTO quotation) {
        LOG.info("-- Recebendo Nova Cotação de Moeda do Tópico Kafka --");
        opportunityService.saveQuotation(quotation);
    }

}
