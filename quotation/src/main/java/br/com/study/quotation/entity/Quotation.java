package br.com.study.quotation.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_quotation")
public class Quotation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "currency_price")
    private BigDecimal currencyPrice;

    @Column(name = "pct_change")
    private String pctChange;

    @Column(name = "pair")
    private String pair;

    public Quotation() {
    }

    public Long getId() {
        return id;
    }

    public Quotation setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Quotation setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public BigDecimal getCurrencyPrice() {
        return currencyPrice;
    }

    public Quotation setCurrencyPrice(BigDecimal currencyPrice) {
        this.currencyPrice = currencyPrice;
        return this;
    }

    public String getPctChange() {
        return pctChange;
    }

    public Quotation setPctChange(String pctChange) {
        this.pctChange = pctChange;
        return this;
    }

    public String getPair() {
        return pair;
    }

    public Quotation setPair(String pair) {
        this.pair = pair;
        return this;
    }
}
