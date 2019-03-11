package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.Musix;
import com.stackroute.userservice.service.MusixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MusixController {

    private MusixService musixService;


    @Autowired
    public MusixController(MusixService musixService) {
        this.musixService = musixService;
    }

    @PostMapping("/musix")

    public ResponseEntity<Musix> saveMusix(@RequestBody Musix musix){

        Musix savedMusix = musixService.saveMusix(musix);
        return new ResponseEntity<Musix>(savedMusix, HttpStatus.OK);
    }

    @GetMapping("/musixs")

    public ResponseEntity<List<Musix>> getMusixs(){

        List<Musix> musixes = musixService.getMusix();
        return new ResponseEntity<List<Musix>>(musixes, HttpStatus.OK);


    }

    @GetMapping("/musix/{id}")

    public ResponseEntity<Musix> getById(@PathVariable int id){
        Musix musix = musixService.getById(id);
        return new ResponseEntity<Musix>(musix,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMusix(@PathVariable int id) {
        musixService.deleteById(id);
        return "Data deleted";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateMusix(@RequestBody Musix musix, @PathVariable int id) {

        if (musixService.updateById(musix,id)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
