package com.prodemy.dataperpus_try6.controller;

import com.prodemy.dataperpus_try6.dto.DtoEbook;
import com.prodemy.dataperpus_try6.entity.Ebook;
import com.prodemy.dataperpus_try6.helpers.DefaultResponse;
import com.prodemy.dataperpus_try6.repository.RepoEbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ebook")
public class ControlEbook {
    private final RepoEbook ebookRepository;

    @Autowired
    public ControlEbook(RepoEbook ebookRepository){
        this.ebookRepository = ebookRepository;
    }

    //melihat list seluruh ebook
    @GetMapping("/listebook")
    public List<DtoEbook> getListEbook(){
        List<DtoEbook> list = new ArrayList<>();
        for(Ebook e : ebookRepository.findAll()){
            list.add(convertEntitytoDto(e));
        }
        return list;
    }

    //menambahkan ebook
    @PostMapping("/inputebook")
    public DefaultResponse<DtoEbook> saveebook(@RequestBody DtoEbook ebookDto){
        Ebook ebook = convertDtotoEntity(ebookDto);
        DefaultResponse<DtoEbook> response = new DefaultResponse<>();

        //cek data
        Optional<Ebook> optional = ebookRepository.findEbookByName(ebookDto.getJudulEbook());
        if(optional.isPresent()){
            response.setMessage("Ebook sudah tersedia");
        } else {
            ebookRepository.save(ebook);
            response.setMessage("Berhasil menyimpan");
            response.setData(ebookDto);
        }
        return response;
    }

    //mengambil data ebook berdasarkan nama
    @GetMapping("/getbyname/{name}")
    public DefaultResponse<DtoEbook> getByName(@PathVariable String name) {
        DefaultResponse<DtoEbook> response = new DefaultResponse<>();
        Optional<Ebook> optional = ebookRepository.findEbookByName(name);
        if(optional.isPresent()){
            response.setMessage("Ebook Ditemukan");
            response.setData(convertEntitytoDto(optional.get()));
        } else {
            response.setMessage("Ebook Tidak Ditemukan");
        }
        return response;
    }

    //convert Dto ke entity
    public Ebook convertDtotoEntity(DtoEbook dto) {
        Ebook ebook = new Ebook();
        ebook.setIdEbook(dto.getIdEbook());
        ebook.setJudulEbook(dto.getJudulEbook());
        ebook.setPenulisEbook(dto.getPenulisEbook());
        ebook.setPenerbitEbook(dto.getPenerbitEbook());
        ebook.setTahunTerbit(dto.getTahunTerbit());
        ebook.setEdisi(dto.getEdisi());
        ebook.setNoISBN(dto.getNoISBN());
        ebook.setJumlahHalaman(dto.getJumlahHalaman());

        return ebook;
    }

    //convert Entity to Dto
    public DtoEbook convertEntitytoDto(Ebook entity) {
        DtoEbook dto = new DtoEbook();
        dto.setIdEbook(entity.getIdEbook());
        dto.setJudulEbook(entity.getJudulEbook());
        dto.setPenulisEbook(entity.getPenulisEbook());
        dto.setPenerbitEbook(entity.getPenerbitEbook());
        dto.setTahunTerbit(entity.getTahunTerbit());
        dto.setEdisi(entity.getEdisi());
        dto.setNoISBN(entity.getNoISBN());
        dto.setJumlahHalaman(entity.getJumlahHalaman());

        return dto;
    }
}
