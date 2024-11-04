package com.example.LibrarayManagement.repository;

import com.example.LibrarayManagement.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    User findByUsername(String name);

}
