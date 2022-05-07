package com.prodemy.dataperpus_try6.dto;

import com.prodemy.dataperpus_try6.entity.Ebook;
import com.prodemy.dataperpus_try6.entity.Pengguna;

import java.util.Date;

public class DtoAkses {
    private Long id;
    private Date tanggalAkses;
    private String kodePengguna;
    private String idEbook;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTanggalAkses() {
        return tanggalAkses;
    }

    public void setTanggalAkses(Date tanggalAkses) {
        this.tanggalAkses = tanggalAkses;
    }

    public String getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(String kodePengguna) {
        this.kodePengguna = kodePengguna;
    }

    public String getIdEbook() {
        return idEbook;
    }

    public void setIdEbook(String idEbook) {
        this.idEbook = idEbook;
    }
}
