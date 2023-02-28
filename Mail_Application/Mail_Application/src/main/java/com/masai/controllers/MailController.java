package com.masai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.MailService;
import com.masai.Service.UserService;
import com.masai.beans.Mail;

@RestController
@RequestMapping
public class MailController {
	
	@Autowired
	private MailService ms;

	
	@PostMapping("/mail/{key}")
	public ResponseEntity<String> sendMail(@PathVariable String key,  @Valid @RequestBody List<Mail> mails){
		
		String str = ms.toSendMail(mails,key);
		
		return new ResponseEntity<>(str,HttpStatus.OK);
		
	}
	
	@PutMapping("/mail/{id}")
	public ResponseEntity<Mail> starredMessage(@PathVariable ("id") Integer id,@RequestParam String keyid ){
		
		
		Mail mailfound = ms.toStarredMail(keyid, id);		
		
		return new ResponseEntity<>(mailfound,HttpStatus.OK);		
	}
	
	
	@DeleteMapping("/mail/{id}")
	public ResponseEntity<String> deleteMail(@PathVariable ("id") Integer id, @RequestParam String mailid ){
		
		String mailfound = ms.toDeleteMail(mailid, id);		
		
		return new ResponseEntity<>(mailfound,HttpStatus.OK);
	}
	
		
}
