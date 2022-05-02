package com.prodemy.dataperpus_try6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_rak")
public class Rak {
    @Id
    @Column(name = "id_rak", length = 25)
    private String idRak;
    @Column(name = "nama_rak")
    private String namaRak;
    @Column(name = "lokasi_rak")
    private String lokasiRak;

    public String getIdRak() {
        return idRak;
    }

    public void setIdRak(String idRak) {
        this.idRak = idRak;
    }

    public String getNamaRak() {
        return namaRak;
    }

    public void setNamaRak(String namaRak) {
        this.namaRak = namaRak;
    }

    public String getLokasiRak() {
        return lokasiRak;
    }

    public void setLokasiRak(String lokasiRak) {
        this.lokasiRak = lokasiRak;
    }
}
