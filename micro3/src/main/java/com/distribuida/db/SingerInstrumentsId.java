package com.distribuida.db;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class SingerInstrumentsId implements Serializable {

    @Column(name = "singer_id")
    private Integer singerId;

    @Column(name = "instrument_id")
    private Integer instrumentId;

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singedId) {
        this.singerId = singedId;
    }

    public Integer getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Integer instrumentId) {
        this.instrumentId = instrumentId;
    }
}
