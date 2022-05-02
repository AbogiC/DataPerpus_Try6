package com.prodemy.dataperpus_try6.repository;

import com.prodemy.dataperpus_try6.entity.Transbuku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoTransbuku extends JpaRepository<Transbuku, String> {
}
