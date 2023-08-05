package com.jorgeadammo.sistemas.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jorgeadammo.sistemas.entity.Concurso;
import com.jorgeadammo.sistemas.model.ConcursoDto;
import com.jorgeadammo.sistemas.response.Response;
import com.jorgeadammo.sistemas.service.ConcursoService;

@RestController
@RequestMapping("/api-cnc")
@CrossOrigin(origins = {"${origem-permitida}"})
public class ConcursoRestController {
	@Autowired
	private ConcursoService concursoService;

	@PostMapping(path = "/concurso")
	public ResponseEntity<Response<Concurso>> save(@Valid @RequestBody ConcursoDto concursoDto, BindingResult result) {
		Response<Concurso> response = new Response<Concurso>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Concurso concursoSalvo = this.concursoService.save(concursoDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(concursoDto.getId())
				.toUri();
		response.setData(concursoSalvo);
		return ResponseEntity.created(location).body(response);
	}

	@GetMapping(path = "/concurso")
	public ResponseEntity<List<Concurso>> findAll() {
		List<Concurso> concursos = concursoService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(concursos);
	}
	
	@GetMapping(path = "/concurso/{id}")
	public ResponseEntity<Concurso> buscar(@PathVariable("id") Long id) {
  
		Concurso concurso = concursoService.findOne(id);
		return ResponseEntity.status(HttpStatus.OK).body(concurso);
	}
	
	@DeleteMapping(path = "/concurso/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id){
		concursoService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	@PutMapping(path = "/concurso/{id}")
    public ResponseEntity<Concurso> update(@PathVariable(value = "id") Long id,
         @Valid @RequestBody ConcursoDto concursoDto) {
		
        final Concurso concursoAlterada = concursoService.update(concursoDto, id);
        return ResponseEntity.ok(concursoAlterada);
    }
}
