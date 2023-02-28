package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Email;

public interface EmailRepo extends JpaRepository<Email,Integer> {

}
