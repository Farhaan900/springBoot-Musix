package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Musix;

import java.util.List;

public interface MusixService {
    public Musix saveMusix(Musix musix);
    public List<Musix> getMusix();
    public Musix getById(int id);
    public void deleteById(int id);
    public boolean updateById(Musix musix, int id);
}
