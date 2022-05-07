package com.prodemy.dataperpus_try6.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_akses")
public class Akses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAkses;
    @Column(name = "t_tanggal_akses")
    private Date tanggalAkses;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kode_ebook", referencedColumnName = "id_ebook")
    private Ebook idEbook;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kode_pengguna", referencedColumnName = "kode_pengguna")
    private Pengguna kodePengguna;

    public void setEbook(Ebook idEbook) {
        this.idEbook = idEbook;
    }

    public Ebook getIdEbook() {
        return idEbook;
    }

    public Pengguna getKodePengguna() {
        return kodePengguna;
    }

    public Long getIdAkses() {
        return idAkses;
    }

    public void setIdAkses(Long idAkses) {
        this.idAkses = idAkses;
    }

    public Date getTanggalAkses() {
        return tanggalAkses;
    }

    public void setTanggalAkses(Date tanggalAkses) {
        this.tanggalAkses = tanggalAkses;
    }

    public void setKodePengguna(Pengguna kodePengguna) {
        this.kodePengguna = kodePengguna;
    }

    public void setIdEbook(Ebook idEbook) {
        this.idEbook = idEbook;
    }
}
