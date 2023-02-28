package com.masai.controller;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Fir;
import com.masai.exception.FirException;
import com.masai.service.FirServices;

@RestController
public class FirController {

	private FirServices fservice;
	
	//### Add New User ###
		@PostMapping("/user/fir")
		public ResponseEntity<Fir> createFirHandler(@Valid @RequestBody Fir fir)
				throws FirException {

			Fir createFIR = fservice.createFir(fir);

			return new ResponseEntity<Fir>(createFIR, HttpStatus.CREATED);
		}
}
