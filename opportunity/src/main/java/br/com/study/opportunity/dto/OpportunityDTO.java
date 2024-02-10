package br.com.study.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class OpportunityDTO implements Serializable {

    private Long proposalId;

    private String customer;

    private BigDecimal priceTonne;

    private BigDecimal lastDollarQuotation;

    public Long getProposalId() {
        return proposalId;
    }

    public OpportunityDTO setProposalId(Long proposalId) {
        this.proposalId = proposalId;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public OpportunityDTO setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public BigDecimal getPriceTonne() {
        return priceTonne;
    }

    public OpportunityDTO setPriceTonne(BigDecimal priceTonne) {
        this.priceTonne = priceTonne;
        return this;
    }

    public BigDecimal getLastDollarQuotation() {
        return lastDollarQuotation;
    }

    public OpportunityDTO setLastDollarQuotation(BigDecimal lastDollarQuotation) {
        this.lastDollarQuotation = lastDollarQuotation;
        return this;
    }
}
