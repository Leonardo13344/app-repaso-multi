package com.distribuida.repo;

import com.distribuida.db.Singer;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SingerRepository implements PanacheRepositoryBase<Singer, Long> {
}
