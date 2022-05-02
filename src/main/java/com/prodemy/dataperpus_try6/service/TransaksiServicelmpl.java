package com.prodemy.dataperpus_try6.service;

import com.prodemy.dataperpus_try6.entity.Transaksi;
import com.prodemy.dataperpus_try6.repository.RepoDenda;
import com.prodemy.dataperpus_try6.repository.RepoTransaksi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransaksiServicelmpl implements TransaksiService{
    @Autowired
    private RepoTransaksi repoTransaksi;
    private RepoDenda repoDenda;
    @Override
    public Transaksi insertDataTransaksi(Transaksi transaksi) {return null;}
}
