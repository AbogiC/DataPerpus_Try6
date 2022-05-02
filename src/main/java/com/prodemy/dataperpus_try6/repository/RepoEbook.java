package com.prodemy.dataperpus_try6.repository;

import com.prodemy.dataperpus_try6.entity.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface RepoEbook extends JpaRepository<Ebook, String> {
    @Query(value = "SELECT e FROM Ebook e WHERE e.judulEbook = :ebook", nativeQuery = false)
    Optional<Ebook> findEbookByName(@PathParam("ebook") String ebook);
}
