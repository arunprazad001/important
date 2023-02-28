package com.masai.Controller;


import javax.validation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Fir;
import com.masai.Exception.FirException;
import com.masai.Service.FirServices;

@RestController
public class FirController {

	private FirServices fservice;
	
	
		@PostMapping("/user/fir")
		public ResponseEntity<Fir> createFirHandler(@Valid @RequestBody Fir fir)
				throws FirException {

			Fir createFIR = fservice.createFir(fir);

			return new ResponseEntity<Fir>(createFIR, HttpStatus.CREATED);
		}
}
