package com.prodemy.dataperpus_try6.repository;

import com.prodemy.dataperpus_try6.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoTransaksi extends JpaRepository<Transaksi, String> {
//    List<Transaksi> findAllByPenggunaKodePengguna(String kode);
}
