package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Musix;
import com.stackroute.userservice.repository.MusixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusixServiceImpl implements MusixService {


    private MusixRepository userRepository;

    @Autowired
    public MusixRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(MusixRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MusixServiceImpl(MusixRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Musix saveMusix(Musix musix){

        Musix savedMusix = userRepository.save(musix);

        return savedMusix;
    }

    public List<Musix> getMusix(){

        return (List<Musix>)userRepository.findAll();

    }

    public Musix getById(int id) {

        Optional<Musix> user_id = userRepository.findById(id);

        if (!user_id.isPresent())
            return null;

        return user_id.get();


    }


    public void deleteById(int id) {
        userRepository.deleteById(id);

        }


    public boolean updateById(Musix musix, int id) {
        Optional<Musix> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            return false;
//            return ResponseEntity.notFound().build();

        musix.setId(id);

        userRepository.save(musix);
        return true;
    }
}
