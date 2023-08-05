package com.jorgeadammo.sistemas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgeadammo.sistemas.entity.Concurso;
import com.jorgeadammo.sistemas.exception.ResourceNotFoundException;
import com.jorgeadammo.sistemas.model.ConcursoDto;
import com.jorgeadammo.sistemas.repository.ConcursoRepository;

@Service
public class ConcursoService {
	@Autowired
	private ConcursoRepository concursoRepository;

	public List<Concurso> findAll() {
		return concursoRepository.findAll();
	}

	public Concurso save(ConcursoDto concursoDto) {

		Concurso concurso = new Concurso();

		concurso.setTitulo(concursoDto.getTitulo());
		concurso.setAno(concursoDto.getAno());
		concurso.setEnte(concursoDto.getEnte());
		concurso.setDescricao(concursoDto.getDescricao());
		concurso.setTipoEsfera(concursoDto.getTipoEsfera());
		concurso.setUf(concursoDto.getUf());
		concurso.setAdmin(concursoDto.getAdmin());
		concurso.setDt_insc_ini(concursoDto.getDt_insc_ini());
		concurso.setDt_insc_fim(concursoDto.getDt_insc_fim());
		concurso.setDt_pg_bloq(concursoDto.getDt_pg_bloq());
		concurso.setFormato(concursoDto.getFormato());
		concurso.setRegime(concursoDto.getRegime());
		concurso.setAtivo(concursoDto.isAtivo());
		concurso.setLink(concursoDto.getLink());
		concurso.setEdital(concursoDto.getEdital());
		concurso.setDt_edital(concursoDto.getDt_edital());
		
		concurso.setBanca(concursoDto.getBanca());
		concurso.setStatus(concursoDto.getStatus());
		
		concurso.setInclusion(concursoDto.getInclusion());
		concurso.setLastEdition(concursoDto.getLastEdition());
		concurso.setIncludedBy(concursoDto.getIncludedBy());
		concurso.setEditedBy(concursoDto.getEditedBy());
		
		return concursoRepository.save(concurso);
	}

	public Concurso findOne(Long id) {
		Concurso concurso = concursoRepository.findOne(id);

		if (concurso == null) {
			try {
				throw new ResourceNotFoundException("Não existe esta concurso cadastrado p/ o id :: " + id);
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return concurso;
	}
	
	public void delete(Long id) {
		Concurso concurso = concursoRepository.findOne(id);
		
		if (concurso == null) {
			try {
				throw new ResourceNotFoundException("Não existe esta concurso cadastrado p/ o id :: " + id);
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		concursoRepository.delete(id);
	}
	
	public Concurso update(ConcursoDto concursoDtoAlterado, Long id) {
		Concurso concursoAlterado = concursoRepository.findOne(id);
		
		concursoAlterado.setTitulo(concursoDtoAlterado.getTitulo());
		concursoAlterado.setAno(concursoDtoAlterado.getAno());
		concursoAlterado.setEnte(concursoDtoAlterado.getEnte());
		concursoAlterado.setDescricao(concursoDtoAlterado.getDescricao());
		concursoAlterado.setTipoEsfera(concursoDtoAlterado.getTipoEsfera());
		concursoAlterado.setUf(concursoDtoAlterado.getUf());
		concursoAlterado.setAdmin(concursoDtoAlterado.getAdmin());
		concursoAlterado.setDt_insc_ini(concursoDtoAlterado.getDt_insc_ini());
		concursoAlterado.setDt_insc_fim(concursoDtoAlterado.getDt_insc_fim());
		concursoAlterado.setDt_pg_bloq(concursoDtoAlterado.getDt_pg_bloq());
		concursoAlterado.setFormato(concursoDtoAlterado.getFormato());
		concursoAlterado.setRegime(concursoDtoAlterado.getRegime());
		concursoAlterado.setAtivo(concursoDtoAlterado.isAtivo());
		concursoAlterado.setLink(concursoDtoAlterado.getLink());
		concursoAlterado.setEdital(concursoDtoAlterado.getEdital());
		concursoAlterado.setDt_edital(concursoDtoAlterado.getDt_edital());
		
		concursoAlterado.setBanca(concursoDtoAlterado.getBanca());
		concursoAlterado.setStatus(concursoDtoAlterado.getStatus());
		
		concursoAlterado.setInclusion(concursoDtoAlterado.getInclusion());
		concursoAlterado.setLastEdition(concursoDtoAlterado.getLastEdition());
		concursoAlterado.setIncludedBy(concursoDtoAlterado.getIncludedBy());
		concursoAlterado.setEditedBy(concursoDtoAlterado.getEditedBy());
		
		return concursoRepository.saveAndFlush(concursoAlterado);
	}
}
