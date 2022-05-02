package com.prodemy.dataperpus_try6.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_pengguna")
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "kode_pengguna", length = 25)
    private String kodePengguna;
    @Column(name = "nama_depan")
    private String namaDepan;
    @Column(name = "nama_belakang")
    private String namaBelakang;
    @Column(name = "peran_pengguna")
    private String peranPengguna;
    @Column(name = "alamat")
    private String alamat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKodePengguna() {
        return kodePengguna;
    }

    public void setKodePengguna(String kodePengguna) {
        this.kodePengguna = kodePengguna;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getPeranPengguna() {
        return peranPengguna;
    }

    public void setPeranPengguna(String peranPengguna) {
        this.peranPengguna = peranPengguna;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
