package com.prodemy.dataperpus_try6.repository;

import com.prodemy.dataperpus_try6.entity.Rak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.Optional;

public interface RepoRak extends JpaRepository<Rak, String> {
    @Query(value = "SELECT r FROM Rak r WHERE r.namaRak = :rak", nativeQuery = false)
    Optional<Rak> findRakByNama(@PathParam("rak") String rak);
}
