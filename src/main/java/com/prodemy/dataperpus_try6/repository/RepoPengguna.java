package com.prodemy.dataperpus_try6.repository;

import com.prodemy.dataperpus_try6.entity.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.Optional;

@Repository
public interface RepoPengguna extends JpaRepository<Pengguna, Long> {
    @Query(value = "SELECT p FROM Pengguna p WHERE p.namaDepan = :nama_depan", nativeQuery = false)
    Optional<Pengguna> findPenggunaByNamaDepan(@PathParam("nama_depan") String nama_depan);
    @Query(value = "SELECT p FROM Pengguna p WHERE p.namaBelakang = :nama_belakang", nativeQuery = false)
    Optional<Pengguna> findPenggunaByNamaBelakang(@PathParam("nama_belakang") String nama_belakang);
    @Query(value = "SELECT p FROM Pengguna p WHERE CONCAT(p.namaDepan,p.namaBelakang) = :nama_lengkap", nativeQuery = false)
    Optional<Pengguna> findPenggunaByNamaLengkap(@PathParam("nama_lengkap") String nama_lengkap);
    @Query(value = "SELECT p FROM Pengguna p WHERE p.peranPengguna = :peran", nativeQuery = false)
    Optional<Pengguna> findByPeran(@PathParam("peran") String peran);
}
