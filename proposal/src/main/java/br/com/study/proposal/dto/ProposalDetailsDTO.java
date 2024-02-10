package br.com.study.quarkusproposal.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProposalDetailsDTO implements Serializable {

    private Long proposalId;
    private String customer;
    private BigDecimal priceTonne;
    private Integer tonnes;
    private String country;
    private Integer proposalValidityDays;

    public ProposalDetailsDTO() {
    }

    public Long getProposalId() {
        return proposalId;
    }

    public ProposalDetailsDTO setProposalId(Long proposalId) {
        this.proposalId = proposalId;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public ProposalDetailsDTO setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public BigDecimal getPriceTonne() {
        return priceTonne;
    }

    public ProposalDetailsDTO setPriceTonne(BigDecimal priceTonne) {
        this.priceTonne = priceTonne;
        return this;
    }

    public Integer getTonnes() {
        return tonnes;
    }

    public ProposalDetailsDTO setTonnes(Integer tonnes) {
        this.tonnes = tonnes;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public ProposalDetailsDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public Integer getProposalValidityDays() {
        return proposalValidityDays;
    }

    public ProposalDetailsDTO setProposalValidityDays(Integer proposalValidityDays) {
        this.proposalValidityDays = proposalValidityDays;
        return this;
    }
}
