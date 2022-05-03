package com.prodemy.dataperpus_try6.controller;

import com.prodemy.dataperpus_try6.dto.DefaultResponse;
import com.prodemy.dataperpus_try6.dto.DtoLogin;
import com.prodemy.dataperpus_try6.dto.DtoRole;
import com.prodemy.dataperpus_try6.dto.DtoUser;
import com.prodemy.dataperpus_try6.entity.User;
import com.prodemy.dataperpus_try6.helpers.LoginResponse;
import com.prodemy.dataperpus_try6.repository.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class ControlAuth {
    public User convertDtoToEntity(DtoUser userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }
    public User convertDtoLoginToEntity(DtoLogin loginDto){
        User user = new User();
        user.setId(loginDto.getId());
        user.setEmail(loginDto.getEmaillogin());
        return user;
    }
    public DtoUser convertEntityToDto(User userEntity){
        DtoUser userdto = new DtoUser();
        userdto.setId(userEntity.getId());
        userdto.setEmail(userEntity.getEmail());
        userdto.setFirstName(userEntity.getFirstName());
        userdto.setLastName(userEntity.getLastName());
        return userdto;
    }

    @Autowired
    public RepoUser userRepository;
    @PostMapping("/register")
    public DefaultResponse<DtoUser> read(@RequestBody DtoUser userDto){
        User user = convertDtoToEntity(userDto);
        DefaultResponse<DtoUser> response = new DefaultResponse<>();
        Optional<User> optional = Optional.ofNullable(userRepository.findByEmail((userDto.getEmail())));
        if(optional.isPresent()){
            response.setMessage("Error, email sudah ada");
        } else{
            userRepository.save((user));
            response.setMessage("Berhasil Daftar");
            response.setData(userDto);
        }
        return response;
    }
    @PostMapping("/login")
    public LoginResponse<DtoLogin> masuk(@RequestBody DtoLogin loginDto){
        User user = convertDtoLoginToEntity(loginDto);
        LoginResponse<DtoLogin> resp = new LoginResponse<>();
        Optional<User> optional = Optional.ofNullable(userRepository.findByEmail(loginDto.getEmaillogin()));
        if(optional.isPresent()){
            resp.setPesan("Error, email tidak terdaftar");
        } else{
            resp.setPesan("Welcome " + user.getFirstName());
        }
        return resp;
    }
    @GetMapping("/list-role")
    public List<DtoRole> listRole(){
        List<DtoRole> listR = new ArrayList<>();
        DtoRole r1 = new DtoRole();
        r1.setPeran("Pengunjung");
        listR.add(r1);

        DtoRole r2 = new DtoRole();
        r2.setPeran("Member");
        listR.add(r2);

        DtoRole r3 = new DtoRole();
        r3.setPeran("Pengunjung");
        listR.add(r3);

        return listR;
    }
}
