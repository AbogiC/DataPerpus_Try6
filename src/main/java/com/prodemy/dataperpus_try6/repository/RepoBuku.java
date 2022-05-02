package com.prodemy.dataperpus_try6.repository;

import com.prodemy.dataperpus_try6.entity.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface RepoBuku extends JpaRepository<Buku, String> {
    @Query(value = "SELECT b FROM Buku b WHERE b.judulBuku = :buku", nativeQuery = false)
    Optional<Buku> findBukuByName(@PathParam("buku") String buku);
}
