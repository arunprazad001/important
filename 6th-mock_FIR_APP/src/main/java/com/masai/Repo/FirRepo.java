package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Fir;

@Repository
public interface FirRepo extends JpaRepository<Fir, Integer>{

}
