package com.distribuida.db;

import jakarta.persistence.*;

@Entity
@Table(name = "singers_instruments")
public class SingerInstrument {

    @EmbeddedId
    private SingerInstrumentsId id;

    public SingerInstrumentsId getId() {
        return id;
    }

    public void setId(SingerInstrumentsId id) {
        this.id = id;
    }
}
