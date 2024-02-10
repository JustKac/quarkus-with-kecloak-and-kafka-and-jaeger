package br.com.study.entity;

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
}
