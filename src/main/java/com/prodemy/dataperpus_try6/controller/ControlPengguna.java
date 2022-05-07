package com.prodemy.dataperpus_try6.controller;

import com.prodemy.dataperpus_try6.dto.DefaultResponse;
import com.prodemy.dataperpus_try6.dto.DtoAkses;
import com.prodemy.dataperpus_try6.dto.DtoPengguna;
import com.prodemy.dataperpus_try6.entity.Akses;
import com.prodemy.dataperpus_try6.entity.Ebook;
import com.prodemy.dataperpus_try6.entity.Pengguna;
import com.prodemy.dataperpus_try6.repository.RepoAkses;
import com.prodemy.dataperpus_try6.repository.RepoEbook;
import com.prodemy.dataperpus_try6.repository.RepoPengguna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pengguna")
public class ControlPengguna {
//    private final RepoPengguna repoPengguna;
//
//    public ControlPengguna(RepoPengguna repoPengguna) {
//        this.repoPengguna = repoPengguna;
//    }
    @Autowired
    RepoEbook repoEbook;
    @Autowired
    RepoPengguna repoPengguna;
    @Autowired
    RepoAkses repoAkses;
    @GetMapping
    public List<DtoPengguna> getPengguna(){
        List<Pengguna> listPengguna = repoPengguna.findAll();
        return listPengguna.stream().map(this::convertToDto1).collect(Collectors.toList());
    }
    @GetMapping("/aksesnama/{namaLengkap}")
    public DefaultResponse<DtoPengguna> getByfullName(@PathVariable String namaLengkap){
        DefaultResponse<DtoPengguna> respon = new DefaultResponse<>();
        Optional<Pengguna> nama_lengkap = repoPengguna.findPenggunaByNamaLengkap(namaLengkap);
        if(nama_lengkap.isPresent()){
            respon.setMessage("Nama Ditemukan");
            respon.setData(convertToDto1(nama_lengkap.get()));
        } else{
            respon.setMessage("Nama Tidak Ditemukan");
        }
        return respon;
    }
    @GetMapping("/dataperan/{peranPengguna}")
    public List<DtoPengguna> getByPeran(@PathVariable String peranPengguna){
        List<Pengguna> listPengguna = repoPengguna.findAllByPeranPengguna(peranPengguna);
        return listPengguna.stream().map(this::convertToDto1).collect(Collectors.toList());
    }
    @PostMapping("/daftar")
    public DefaultResponse<DtoPengguna> insert(@RequestBody DtoPengguna dto){
        Pengguna entity = convertToEntity1(dto);
        DefaultResponse<DtoPengguna> masukan = new DefaultResponse<>();

        Optional<Pengguna> namaDepan = repoPengguna.findPenggunaByNamaDepan(dto.getFirstName());
        Optional<Pengguna> namaBelakang = repoPengguna.findPenggunaByNamaBelakang(dto.getLastName());
        if(namaDepan.isPresent() && namaBelakang.isPresent()){
            masukan.setMessage("Nama sudah tersedia");
        } else{
            repoPengguna.save(entity);
            masukan.setMessage("Berhasil menyimpan");
            masukan.setData(dto);
        }
        return masukan;
    }
    @PostMapping("/edit/{namaLengkap}")
    public DefaultResponse<DtoPengguna> edit(@RequestBody DtoPengguna dto, @PathVariable String namaLengkap){
        Pengguna entity = convertToEntity1(dto);
        DefaultResponse<DtoPengguna> masukan = new DefaultResponse<>();

        Optional<Pengguna> nama_lengkap = repoPengguna.findPenggunaByNamaLengkap(namaLengkap);
        if(nama_lengkap.isPresent()){
//            repoPengguna.deleteById(dto.getId());
            repoPengguna.save(entity);
            masukan.setMessage("Data diri berhasil diperbaharui");
            masukan.setData(dto);
        } else{
            masukan.setMessage("Nama tidak ditemukan");
        }
        return masukan;
    }
    @PostMapping("/akses_ebook")
    public DefaultResponse<DtoAkses> edit(@RequestBody DtoAkses dto){
        Akses akses = convertToEntity2(dto);
        DefaultResponse<DtoAkses> masukan = new DefaultResponse<>();
        repoAkses.save(akses);
        masukan.setMessage("Tanggal akses telah masuk");
        masukan.setData(dto);
        return masukan;
    }
    @GetMapping("/dataakses")
    List<Akses> getDataAkses(){ return repoAkses.findAll(); }
    @PutMapping("/{id}/kodepengguna/{kodePengguna}/ebook/{idEbook}")
    Akses dataAksesPenggunaEbook(
            @PathVariable Long id,
            @PathVariable String idEbook,
            @PathVariable String kodePengguna
    ){
        Akses akses = repoAkses.findById(id).get();
        Pengguna pengguna = repoPengguna.findPenggunaByKode(kodePengguna).get();
        Ebook ebook = repoEbook.findEbookById(idEbook).get();
        akses.setIdEbook(ebook);
        akses.setKodePengguna(pengguna);
        return repoAkses.save(akses);
    }

    private DtoPengguna convertToDto1(Pengguna entity){
        DtoPengguna dto = new DtoPengguna();
        dto.setKode(entity.getKodePengguna());
        dto.setFirstName(entity.getNamaDepan());
        dto.setLastName(entity.getNamaBelakang());
        dto.setPeran(entity.getPeranPengguna());
        dto.setJenisKelamin(entity.getJenisKelamin());
        dto.setAlamat(entity.getAlamat());
        dto.setKontak(entity.getKontak());
        dto.setTanggalDaftar(entity.getTanggalDaftar());
        return dto;
    }
    private Pengguna convertToEntity1(DtoPengguna dto){
        Pengguna entity = new Pengguna();
        entity.setKodePengguna(dto.getKode());
        entity.setNamaDepan(dto.getFirstName());
        entity.setNamaBelakang(dto.getLastName());
        entity.setPeranPengguna(dto.getPeran());
        entity.setJenisKelamin(dto.getJenisKelamin());
        entity.setAlamat(dto.getAlamat());
        entity.setKontak(dto.getKontak());
        entity.setTanggalDaftar(dto.getTanggalDaftar());
        return entity;
    }
    private Akses convertToEntity2(DtoAkses dto){
        Akses entity = new Akses();
        entity.setIdAkses(dto.getId());
        entity.setTanggalAkses(dto.getTanggalAkses());
        return entity;
    }
}
