package com.distribuida.repo;

import com.distribuida.db.Instrument;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InstrumentRepository implements PanacheRepositoryBase<Instrument, Long> {
}
