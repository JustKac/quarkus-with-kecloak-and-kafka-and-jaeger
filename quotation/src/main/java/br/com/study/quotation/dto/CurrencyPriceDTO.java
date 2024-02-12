package br.com.study.quotation.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyPriceDTO implements Serializable {

    @JsonProperty("USDBRL")
    private USDBRL usdbrl;

    public CurrencyPriceDTO() {
    }

    public USDBRL getUsdbrl() {
        return usdbrl;
    }

    public CurrencyPriceDTO setUsdbrl(USDBRL usdbrl) {
        this.usdbrl = usdbrl;
        return this;
    }
}
