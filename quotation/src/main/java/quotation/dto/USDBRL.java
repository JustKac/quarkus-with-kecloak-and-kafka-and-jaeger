package br.com.study.quarkusmineradora.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class USDBRL implements Serializable {

    private String code;
    private String codein;
    private String name;
    private String high;
    private String low;
    private String varBid;
    private String pctChange;
    private String bid;
    private String ask;
    private String timestamp;

    @JsonProperty("create_date")
    private String createDate;

    public USDBRL() {
    }

    public String getCode() {
        return code;
    }

    public USDBRL setCode(String code) {
        this.code = code;
        return this;
    }

    public String getCodein() {
        return codein;
    }

    public USDBRL setCodein(String codein) {
        this.codein = codein;
        return this;
    }

    public String getName() {
        return name;
    }

    public USDBRL setName(String name) {
        this.name = name;
        return this;
    }

    public String getHigh() {
        return high;
    }

    public USDBRL setHigh(String high) {
        this.high = high;
        return this;
    }

    public String getLow() {
        return low;
    }

    public USDBRL setLow(String low) {
        this.low = low;
        return this;
    }

    public String getVarBid() {
        return varBid;
    }

    public USDBRL setVarBid(String varBid) {
        this.varBid = varBid;
        return this;
    }

    public String getPctChange() {
        return pctChange;
    }

    public USDBRL setPctChange(String pctChange) {
        this.pctChange = pctChange;
        return this;
    }

    public String getBid() {
        return bid;
    }

    public USDBRL setBid(String bid) {
        this.bid = bid;
        return this;
    }

    public String getAsk() {
        return ask;
    }

    public USDBRL setAsk(String ask) {
        this.ask = ask;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public USDBRL setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getCreateDate() {
        return createDate;
    }

    public USDBRL setCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }
}
