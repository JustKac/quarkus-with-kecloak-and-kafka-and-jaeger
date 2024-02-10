package br.com.study.quarkusmineradora.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.study.quarkusmineradora.client.CurrencyPriceClient;
import br.com.study.quarkusmineradora.dto.CurrencyPriceDTO;
import br.com.study.quarkusmineradora.dto.QuotationDTO;
import br.com.study.quarkusmineradora.entity.Quotation;
import br.com.study.quarkusmineradora.message.KafkaEvents;
import br.com.study.quarkusmineradora.repository.QuotationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class QuotationService {

    @Inject
    QuotationRepository quotationRepository;

    @Inject
    @RestClient
    CurrencyPriceClient currencyPriceClient;

    @Inject
    KafkaEvents kafkaEvents;

    public void getCurrencyPrice() {

        CurrencyPriceDTO currencyPriceInfo = currencyPriceClient.getPriceByPair("USD-BRL");

        if (updateCurrentInfoPrice(currencyPriceInfo)) {
            kafkaEvents.sendNewKafkaEvent(
                    new QuotationDTO()
                            .setCurrencyPrice(new BigDecimal(currencyPriceInfo.getUsdbrl().getBid()))
                            .setDate(LocalDateTime.now()));
        }
    }

    private boolean updateCurrentInfoPrice(CurrencyPriceDTO currencyPriceInfo) {

        BigDecimal currencyPrice = new BigDecimal(currencyPriceInfo.getUsdbrl().getBid());
        AtomicBoolean updatePrice = new AtomicBoolean(false);

        List<Quotation> quotationList = quotationRepository.findAll().list();

        if (quotationList.isEmpty()) {
            saveQuotation(currencyPriceInfo);
            updatePrice.set(true);
        } else {
            Quotation lastDollarPrice = quotationList.get(quotationList.size() - 1);
            if (currencyPrice.floatValue() > lastDollarPrice.getCurrencyPrice().floatValue()) {
                saveQuotation(currencyPriceInfo);
                updatePrice.set(true);
                ;
            }
        }
        return updatePrice.get();
    }

    private void saveQuotation(CurrencyPriceDTO currencyPriceInfo) {
        quotationRepository.persist(
                new Quotation()
                        .setCurrencyPrice(new BigDecimal(currencyPriceInfo.getUsdbrl().getBid()))
                        .setDate(LocalDateTime.now())
                        .setPair("USD-BRL")
                        .setPctChange(currencyPriceInfo.getUsdbrl().getPctChange()));
    }

}
