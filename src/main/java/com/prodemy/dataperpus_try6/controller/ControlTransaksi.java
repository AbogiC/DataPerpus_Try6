package com.prodemy.dataperpus_try6.controller;

import com.prodemy.dataperpus_try6.dto.DtoTransaksi;
import com.prodemy.dataperpus_try6.entity.Transaksi;
import com.prodemy.dataperpus_try6.entity.Transbuku;
import com.prodemy.dataperpus_try6.repository.RepoPengguna;
import com.prodemy.dataperpus_try6.repository.RepoTransaksi;
import com.prodemy.dataperpus_try6.repository.RepoTransbuku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Transaksi")
public class ControlTransaksi {
    private final RepoTransbuku transbukuRepository;
    private final RepoPengguna penggunaRepository;
    private final RepoTransaksi transaksiRepository;
    @Autowired
    public ControlTransaksi(RepoTransbuku transbukuRepository, RepoPengguna penggunaRepository, RepoTransaksi transaksiRepository) {
        this.transbukuRepository = transbukuRepository;
        this.penggunaRepository = penggunaRepository;
        this.transaksiRepository = transaksiRepository;
    }


    // convert dto to entity
    public Transaksi convertDtoToEntity (DtoTransaksi transaksiDto){
        Transaksi transaksi = new Transaksi();
        transaksi.setKodeTransaksi(transaksiDto.getKode());
        transaksi.setHariPinjam(transaksiDto.getHariPinjam());
        transaksi.setBulanPinjam(transaksiDto.getBulanPinjam());
        transaksi.setTahunPinjam(transaksiDto.getTahunPinjam());
        transaksi.setHarikembali(transaksiDto.getHariKembali());
        transaksi.setBulanKembali(transaksiDto.getBulanKembali());
        transaksi.setTahunKembali(transaksiDto.getTahunKembali());
        if(transbukuRepository.findById(transaksiDto.getKodeTransbuku()).isPresent()){
            Transbuku transbuku = transbukuRepository.findById(transaksiDto.getKodeTransbuku()).get();
            transaksi.setTransbuku(transbuku);
        }
        return transaksi;
    }

    // convert to dto
    private DtoTransaksi convertEntityToDto(Transaksi transaksi){
        DtoTransaksi dto = new DtoTransaksi();
        dto.setKode(transaksi.getKodeTransaksi());
        dto.setHariKembali(transaksi.getHarikembali());
        dto.setBulanKembali(transaksi.getBulanKembali());
        dto.setTahunKembali(transaksi.getTahunKembali());
        dto.setHariPinjam(transaksi.getHariPinjam());
        dto.setBulanKembali(transaksi.getBulanKembali());
        dto.setTahunPinjam(transaksi.getTahunPinjam());
        dto.setKodePengguna(transaksi.getKodePengguna().getKodePengguna());
        dto.setKodeTransbuku(transaksi.getTransbuku().getKodeTransbuku());
        dto.setKodeDenda(transaksi.getKodeDenda().getKodeDenda());
        return dto;
    }

    //lihat data by code transaksi
    @GetMapping("/{code}")
    public DtoTransaksi get(@PathVariable String code){
        if(transaksiRepository.findById(code).isPresent()){
            DtoTransaksi transaksiDto = convertEntityToDto(transaksiRepository.findById(code).get());
            return transaksiDto;
        }
        return null;
    }

//    @GetMapping("/pengguna/{codePengguna}")
//    public List<TransaksiDto> getByPengguna(@PathVariable String codePengguna){
//        List<Transaksi> transaksiList = transaksiRepository.findAllByPenggunaKodePengguna(codePengguna);
//        List<TransaksiDto> transaksiDtoList = transaksiList.stream().map(this::convertEntityToDto)
//                .collect(Collectors.toList());
//        return transaksiDtoList;
//    }

    @PostMapping
    public DtoTransaksi insert(@RequestBody DtoTransaksi dto){
        Transaksi transaksi = convertDtoToEntity(dto);
        transaksiRepository.save(transaksi);
        return convertEntityToDto(transaksi);
    }
}
