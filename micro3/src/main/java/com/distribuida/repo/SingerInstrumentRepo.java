package com.distribuida.repo;

import com.distribuida.db.SingerInstrument;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class SingerInstrumentRepo implements PanacheRepositoryBase<SingerInstrument, Long> {


}
