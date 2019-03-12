package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.Player;
import com.stackroute.userservice.exceptions.PlayerAlreadyExistsException;
import com.stackroute.userservice.exceptions.PlayerNotFoundException;
import com.stackroute.userservice.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class playerController {

    private PlayerService playerService;


    @Autowired
    public playerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/player")

    public ResponseEntity<?> saveMusix(@RequestBody Player player){

        Player savedPlayer =null;
        try {
            savedPlayer = playerService.saveMusix(player);
        }
        catch (PlayerAlreadyExistsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.ALREADY_REPORTED);
        }
        return new ResponseEntity<>(savedPlayer, HttpStatus.OK);
    }

    @GetMapping("/players")

    public ResponseEntity<List<Player>> getMusixs(){

        List<Player> players = playerService.getMusix();
        return new ResponseEntity<List<Player>>(players, HttpStatus.OK);


    }

    @GetMapping("/player/{id}")

    public ResponseEntity<?> getById(@PathVariable int id){

        Player player =null;
        try {
            player = playerService.getById(id);
        }
        catch(PlayerNotFoundException t){
            return new ResponseEntity<>(t.getMessage(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Player>(player,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMusix(@PathVariable int id) {
        playerService.deleteById(id);
        return "Data deleted";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Player> updateMusix(@RequestBody Player player, @PathVariable int id) {

        if (playerService.updateById(player,id)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/names/{name}")
    public ResponseEntity<List<Player>> getByname(@PathVariable String name){
        List<Player> players = playerService.getBYName(name);
        return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
    }
}
