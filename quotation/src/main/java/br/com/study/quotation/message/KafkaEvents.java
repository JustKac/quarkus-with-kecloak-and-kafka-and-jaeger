package br.com.study.quarkusmineradora.message;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.study.quarkusmineradora.dto.QuotationDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaEvents {

    private final Logger LOG = LoggerFactory.getLogger(KafkaEvents.class);

    @Channel("quotation-channel")
    Emitter<QuotationDTO> quotationDTORequestEmitter;

    public void sendNewKafkaEvent(QuotationDTO quotation) {

        LOG.info(" - - - Enviando Cotação para o Tópico Kafka");
        quotationDTORequestEmitter.send(quotation).toCompletableFuture().join();
    }
}
