package com.prodemy.dataperpus_try6.controller;

import com.prodemy.dataperpus_try6.dto.DtoRak;
import com.prodemy.dataperpus_try6.entity.Rak;
import com.prodemy.dataperpus_try6.helpers.DefaultResponse;
import com.prodemy.dataperpus_try6.repository.RepoRak;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rak")
public class ControlRak {
    private final RepoRak rakRepository;

    public ControlRak(RepoRak rakRepository){
        this.rakRepository = rakRepository;
    }

    //melihat list seluruh rak
    @GetMapping("/listrak")
    public List<DtoRak> getListRak(){
        List<DtoRak> list = new ArrayList<>();
        for(Rak r : rakRepository.findAll()){
            list.add(convertEntitytoDto(r));
        }
        return list;
    }

    //menambahkan rak
    @PostMapping("/inputrak")
    public DefaultResponse<DtoRak> saverak(@RequestBody DtoRak rakDto){
        Rak rak = convertDtotoEntity(rakDto);
        DefaultResponse<DtoRak> response = new DefaultResponse<>();

        //cek data
        Optional<Rak> optional = rakRepository.findRakByNama(rakDto.getNamaRak());
        if(optional.isPresent()){
            response.setMessage("Rak sudah tersedia");
        } else {
            rakRepository.save(rak);
            response.setMessage("Berhasil menyimpan");
            response.setData(rakDto);
        }
        return response;
    }

    //mengambil data rak berdasarkan nama
    @GetMapping("/getbyname/{name}")
    public DefaultResponse<DtoRak> getByName(@PathVariable String name) {
        DefaultResponse<DtoRak> response = new DefaultResponse<>();
        Optional<Rak> optional = rakRepository.findRakByNama(name);
        if(optional.isPresent()){
            response.setMessage("Rak Ditemukan");
            response.setData(convertEntitytoDto(optional.get()));
        } else {
            response.setMessage("Rak Tidak Ditemukan");
        }
        return response;
    }

    //convert Dto ke entity
    public Rak convertDtotoEntity(DtoRak dto) {
        Rak rak = new Rak();
        rak.setIdRak(dto.getIdRak());
        rak.setNamaRak(dto.getNamaRak());
        rak.setLokasiRak(dto.getLokasiRak());
        return rak;
    }

    //convert Entity to Dto
    public DtoRak convertEntitytoDto(Rak entity) {
        DtoRak dto = new DtoRak();
        dto.setIdRak(entity.getIdRak());
        dto.setNamaRak(entity.getNamaRak());
        dto.setLokasiRak(entity.getLokasiRak());
        return dto;
    }
}
