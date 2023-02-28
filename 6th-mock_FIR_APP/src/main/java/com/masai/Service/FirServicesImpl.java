package com.masai.Service;

import org.springframework.stereotype.Service;

import com.masai.entity.Fir;
import com.masai.Exception.FirException;
import com.masai.Repo.FirRepo;

@Service
public class FirServicesImpl implements FirServices{

	private FirRepo frepo;
	@Override
	public Fir createFir(Fir fir) throws FirException {
		Fir createFIR=frepo.save(fir);
		if(createFIR != null) {
			return createFIR;
		}
		else 
			throw new FirException("Fir is not exist");
	}

}
