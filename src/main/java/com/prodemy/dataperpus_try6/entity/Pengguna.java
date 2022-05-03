package com.prodemy.dataperpus_try6.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_pengguna")
public class Pengguna {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "kode_pengguna", length = 25, unique = true)
    private String kodePengguna;
    @Column(name = "nama_depan")
    private String namaDepan;
    @Column(name = "nama_belakang")
    private String namaBelakang;
    @Column(name = "peran_pengguna")
    private String peranPengguna;
    @Column(name = "jenis_kelamin")
    private String jenisKelamin;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "kontak", length = 14)
    private String kontak;
    @Column(name = "tanggal_daftar")
    private Date tanggalDaftar;

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

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public Date getTanggalDaftar() {
        return tanggalDaftar;
    }

    public void setTanggalDaftar(Date tanggalDaftar) {
        this.tanggalDaftar = tanggalDaftar;
    }
}
