package com.jorgeadammo.sistemas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgeadammo.sistemas.entity.Banca;
import com.jorgeadammo.sistemas.exception.ResourceNotFoundException;
import com.jorgeadammo.sistemas.model.BancaDto;
import com.jorgeadammo.sistemas.repository.BancaRepository;

@Service
public class BancaService {
	@Autowired
	private BancaRepository bancaRepository;

	public List<Banca> findAll() {
		return bancaRepository.findAll();
	}

	public Banca save(BancaDto bancaDto) {

		Banca banca = new Banca();

		banca.setNome(bancaDto.getNome());
		banca.setApelido(bancaDto.getApelido());
		banca.setTelefoneFixo(bancaDto.getTelefoneFixo());
		banca.setEndereco(bancaDto.getEndereco());
		banca.setAtivo(bancaDto.isAtivo());
		banca.setData(bancaDto.getData());
		return bancaRepository.save(banca);
	}

	public Banca findOne(Long id) {
		Banca banca = bancaRepository.findOne(id);

		if (banca == null) {
			try {
				throw new ResourceNotFoundException("Não existe esta banca cadastrada p/ o id :: " + id);
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return banca;
	}
	
	public void delete(Long id) {
		Banca banca = bancaRepository.findOne(id);
		
		if (banca == null) {
			try {
				throw new ResourceNotFoundException("Não existe esta banca cadastrada p/ o id :: " + id);
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bancaRepository.delete(id);
	}
	
	/*
	public Banca update(Banca bancaAlterada) {
		return bancaRepository.saveAndFlush(bancaAlterada);
	}
	*/
	
	public Banca update(BancaDto bancaDtoAlterada, Long id) {
		Banca bancaAlterada = bancaRepository.findOne(id);
		
		bancaAlterada.setNome(bancaDtoAlterada.getNome());
		bancaAlterada.setApelido(bancaDtoAlterada.getApelido());
		bancaAlterada.setTelefoneFixo(bancaDtoAlterada.getTelefoneFixo());
		bancaAlterada.setEndereco(bancaDtoAlterada.getEndereco());
		bancaAlterada.setAtivo(bancaDtoAlterada.isAtivo());
		bancaAlterada.setData(bancaDtoAlterada.getData());
		
		return bancaRepository.saveAndFlush(bancaAlterada);
	}
}
