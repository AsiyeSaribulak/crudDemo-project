package com.etiya.proje3.controller;

import com.etiya.proje3.dto.UserDto;

import com.etiya.proje3.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userController")

public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        return  ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("/listele")
    public ResponseEntity<List<UserDto>> tumunuListele(){

        return ResponseEntity.ok(userService.getall());
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<UserDto> getById(@NotNull @PathVariable("id") Long id){
        try {
            UserDto userDto = userService.getById(id);
            return ResponseEntity.ok(userDto);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> delete(@PathVariable("id") Long id ){
    try {
            Map sil = userService.delete(id);
            return ResponseEntity.ok(sil);
        }catch (RuntimeException e){
         return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);}
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> update(@PathVariable("id") Long userId, @RequestBody UserDto userdto){
        try {
           final UserDto guncelle=userService.update(userId,userdto);
            return ResponseEntity.ok(guncelle);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }



}
