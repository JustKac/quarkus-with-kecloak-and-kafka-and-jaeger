package br.com.study.opportunity.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_opportunity")
public class Opportunity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "proposal_id")
    private Long proposalId;

    @Column(name = "customer")
    private String customer;

    @Column(name = "price_tonne")
    private BigDecimal priceTonne;

    @Column(name = "last_currency_quotation")
    private BigDecimal lastDollarQuotation;

    public Long getId() {
        return id;
    }

    public Opportunity setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Opportunity setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public Opportunity setProposalId(Long proposalId) {
        this.proposalId = proposalId;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public Opportunity setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public BigDecimal getPriceTonne() {
        return priceTonne;
    }

    public Opportunity setPriceTonne(BigDecimal priceTonne) {
        this.priceTonne = priceTonne;
        return this;
    }

    public BigDecimal getLastDollarQuotation() {
        return lastDollarQuotation;
    }

    public Opportunity setLastDollarQuotation(BigDecimal lastDollarQuotation) {
        this.lastDollarQuotation = lastDollarQuotation;
        return this;
    }

}
