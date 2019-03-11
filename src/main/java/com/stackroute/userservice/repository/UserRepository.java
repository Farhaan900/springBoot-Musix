package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer> {



}
