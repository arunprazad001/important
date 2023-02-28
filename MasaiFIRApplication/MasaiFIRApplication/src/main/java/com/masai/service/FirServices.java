package com.masai.service;

import com.masai.entity.Fir;
import com.masai.exception.FirException;

public interface FirServices {

	public Fir createFir(Fir fir) throws FirException;
	
}
