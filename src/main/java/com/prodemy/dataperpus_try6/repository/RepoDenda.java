package com.prodemy.dataperpus_try6.repository;

import com.prodemy.dataperpus_try6.entity.Denda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoDenda extends JpaRepository<Denda, String> {
}
