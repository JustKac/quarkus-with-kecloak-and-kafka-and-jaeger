package br.com.study.quarkusproposal.message;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.study.quarkusproposal.dto.ProposalDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaEvent {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

    @Channel("proposal-channel")
    Emitter<ProposalDTO> proposalDTORequestEmitter;

    public void sendNewKafkaEvent(ProposalDTO proposalDTO) {
        LOG.info("- - - - - Enviando nova Proposta para tópico Kafka - - - - -");
        proposalDTORequestEmitter.send(proposalDTO).toCompletableFuture().join();
    }
}
