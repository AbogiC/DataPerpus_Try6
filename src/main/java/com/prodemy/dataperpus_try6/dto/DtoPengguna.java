package com.prodemy.dataperpus_try6.dto;

import java.util.Date;

public class DtoPengguna {
    private Long id;
    private String kode;
    private String firstName;
    private String lastName;
    private String peran;
    private String jenisKelamin;
    private String alamat;
    private String kontak;
    private Date tanggalDaftar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPeran() {
        return peran;
    }

    public void setPeran(String peran) {
        this.peran = peran;
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
