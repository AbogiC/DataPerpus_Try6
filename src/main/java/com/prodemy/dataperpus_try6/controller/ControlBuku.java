package com.prodemy.dataperpus_try6.controller;

import com.prodemy.dataperpus_try6.dto.DtoBuku;
import com.prodemy.dataperpus_try6.entity.Buku;
import com.prodemy.dataperpus_try6.entity.Rak;
import com.prodemy.dataperpus_try6.helpers.DefaultResponse;
import com.prodemy.dataperpus_try6.repository.RepoBuku;
import com.prodemy.dataperpus_try6.repository.RepoRak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buku")
public class ControlBuku {
    private final RepoBuku bukuRepository;
    private final RepoRak rakRepository;

    @Autowired
    public ControlBuku(RepoBuku bukuRepository, RepoRak rakRepository){
        this.bukuRepository = bukuRepository;
        this.rakRepository = rakRepository;
    }

    //melihat list seluruh buku
    @GetMapping("/listbuku")
    public List<DtoBuku> getListBuku(){
        List<DtoBuku> list = new ArrayList<>();
        for(Buku b : bukuRepository.findAll()){
            list.add(convertEntitytoDto(b));
        }
        return list;
    }

    //menambahkan buku
    @PostMapping("/inputbuku")
    public DefaultResponse<DtoBuku> savebuku(@RequestBody DtoBuku bukuDto){
        Buku buku = convertDtotoEntity(bukuDto);
        DefaultResponse<DtoBuku> response = new DefaultResponse<>();

        //cek data
        Optional<Buku> optional = bukuRepository.findById(bukuDto.getJudulBuku());
        if(optional.isPresent()){
            response.setMessage("Buku sudah tersedia");
        } else {
            bukuRepository.save(buku);
            response.setMessage("Berhasil menyimpan");
            response.setData(bukuDto);
        }
        return response;
    }

    //mengambil data buku berdasarkan nama
    @GetMapping("/getbyname/{name}")
    public DefaultResponse<DtoBuku> getByName(@PathVariable String name) {
        DefaultResponse<DtoBuku> response = new DefaultResponse<>();
        Optional<Buku> optional = bukuRepository.findBukuByName(name);
        if(optional.isPresent()){
            response.setMessage("Buku Ditemukan");
            response.setData(convertEntitytoDto(optional.get()));
        } else {
            response.setMessage("Buku Tidak Ditemukan");
        }
        return response;
    }

    //convert Dto ke entity
    public Buku convertDtotoEntity(DtoBuku dto) {
        Buku buku = new Buku();
        buku.setIdBuku(dto.getIdBuku());
        buku.setJudulBuku(dto.getJudulBuku());
        buku.setPenulisBuku(dto.getPenulisBuku());
        buku.setPenerbitBuku(dto.getPenerbitBuku());
        buku.setTahunTerbit(dto.getTahunTerbit());
        buku.setNamaKategori(dto.getNamaKategori());
        buku.setJumlahBuku(dto.getJumlahBuku());
        buku.setStokBuku(dto.getStokBuku());

        if(rakRepository.findById(dto.getIdRak()).isPresent()){
            Rak rak = rakRepository.findById(dto.getIdRak()).get();
            buku.setRak(rak);
        }
        return buku;
    }

    //convert Entity to Dto
    public DtoBuku convertEntitytoDto(Buku entity) {
        DtoBuku dto = new DtoBuku();
        dto.setIdBuku(entity.getIdBuku());
        dto.setJudulBuku(entity.getJudulBuku());
        dto.setPenulisBuku(entity.getPenulisBuku());
        dto.setPenerbitBuku(entity.getPenerbitBuku());
        dto.setTahunTerbit(entity.getTahunTerbit());
        dto.setNamaKategori(entity.getNamaKategori());
        dto.setJumlahBuku(entity.getJumlahBuku());
        dto.setStokBuku(entity.getStokBuku());
        dto.setIdRak(entity.getRak().getIdRak());
        return dto;
    }
}
