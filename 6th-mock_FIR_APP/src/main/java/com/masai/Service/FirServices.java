package com.masai.Service;

import com.masai.entity.Fir;
import com.masai.Exception.FirException;

public interface FirServices {

	public Fir createFir(Fir fir) throws FirException;
	
}
