package com.masai.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.beans.Mail;

@Repository
public interface MailRepo extends JpaRepository<Mail,Integer> {
	
	

}
