package br.com.study.proposal.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_proposal")
public class Proposal {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer")
    private String customer;

    @Column(name = "price_tonne")
    private BigDecimal priceTonne;

    @Column(name = "tonnes")
    private Integer tonnes;

    @Column(name = "country")
    private String country;

    @Column(name = "proposal_validityDays")
    private Integer proposalValidityDays;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Proposal() {
    }

    public Long getId() {
        return id;
    }

    public Proposal setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public Proposal setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public BigDecimal getPriceTonne() {
        return priceTonne;
    }

    public Proposal setPriceTonne(BigDecimal priceTonne) {
        this.priceTonne = priceTonne;
        return this;
    }

    public Integer getTonnes() {
        return tonnes;
    }

    public Proposal setTonnes(Integer tonnes) {
        this.tonnes = tonnes;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Proposal setCountry(String country) {
        this.country = country;
        return this;
    }

    public Integer getProposalValidityDays() {
        return proposalValidityDays;
    }

    public Proposal setProposalValidityDays(Integer proposalValidityDays) {
        this.proposalValidityDays = proposalValidityDays;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Proposal setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
