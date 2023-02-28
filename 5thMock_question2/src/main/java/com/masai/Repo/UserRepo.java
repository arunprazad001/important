package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

}
