package br.com.study.opportunity.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class QuotationDTO implements Serializable {

    private LocalDateTime date;

    private BigDecimal currencyPrice;

    public LocalDateTime getDate() {
        return date;
    }

    public QuotationDTO setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public BigDecimal getCurrencyPrice() {
        return currencyPrice;
    }

    public QuotationDTO setCurrencyPrice(BigDecimal currencyPrice) {
        this.currencyPrice = currencyPrice;
        return this;
    }
}
