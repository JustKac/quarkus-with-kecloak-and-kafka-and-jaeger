package br.com.study.proposal.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProposalDTO implements Serializable {

    private Long proposalId;
    private String customer;
    private BigDecimal priceTonne;

    public ProposalDTO() {
    }

    public Long getProposalId() {
        return proposalId;
    }

    public ProposalDTO setProposalId(Long proposalId) {
        this.proposalId = proposalId;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public ProposalDTO setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public BigDecimal getPriceTonne() {
        return priceTonne;
    }

    public ProposalDTO setPriceTonne(BigDecimal priceTonne) {
        this.priceTonne = priceTonne;
        return this;
    }
}
