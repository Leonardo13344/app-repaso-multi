package com.distribuida.repo;

import com.distribuida.db.Album;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlbumRepository implements PanacheRepositoryBase<Album, Long> {
}
