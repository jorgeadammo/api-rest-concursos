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

import com.jorgeadammo.sistemas.entity.Banca;
import com.jorgeadammo.sistemas.model.BancaDto;
import com.jorgeadammo.sistemas.response.Response;
import com.jorgeadammo.sistemas.service.BancaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api-cnc")
@CrossOrigin(origins = {"${origem-permitida}"})
@Api(value="Banca resource REST Endpoint", description="REST Endpoint Banca")
public class BancaRestController {
	@Autowired
	private BancaService bancaService;

	@ApiOperation(value="Salva o registro de uma banca")
	@ApiResponses(
			value= {
					@ApiResponse(code = 201, message = "Success banca created")
			}
	)
	@PostMapping(path = "/banca")
	public ResponseEntity<Response<Banca>> save(@Valid @RequestBody BancaDto bancaDto, BindingResult result) {
		Response<Banca> response = new Response<Banca>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Banca bancaSalva = this.bancaService.save(bancaDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bancaDto.getId())
				.toUri();
		response.setData(bancaSalva);
		return ResponseEntity.created(location).body(response);
	}

	@ApiOperation(value="Retorna todas as bancas")
	@GetMapping(path = "/banca")
	public ResponseEntity<List<Banca>> findAll() {
		List<Banca> bancas = bancaService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(bancas);
	}

	/*
	@GetMapping(path = "/banca/{id}")
	public ResponseEntity<Response<Banca>> buscar(@PathVariable("id") Long id) {
  
		Banca banca = bancaService.findOne(id);
		Response<Banca> response = new Response<Banca>();
		response.setData(banca);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	*/
	
	@ApiOperation(value="Retorna o registro de uma banca")
	@GetMapping(path = "/banca/{id}")
	public ResponseEntity<Banca> buscar(@PathVariable("id") Long id) {
  
		Banca banca = bancaService.findOne(id);
		return ResponseEntity.status(HttpStatus.OK).body(banca);
	}
	
	@ApiOperation(value="Deleta o registro de uma banca")
	@DeleteMapping(path = "/banca/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long id){
		bancaService.delete(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	/*
	@PutMapping(path = "/banca/{id}")
    public ResponseEntity<Banca> update(@PathVariable(value = "id") Long id,
         @Valid @RequestBody BancaDto bancaDto) {
		Banca banca = bancaService.findOne(id);
	
		banca.setLocalDeDestino(bancaDto.getLocalDeDestino());
		banca.setDataPartida(bancaDto.getDataPartida());
		banca.setDataRetorno(bancaDto.getDataRetorno());
		banca.setAcompanhante(bancaDto.getAcompanhante());
		
        final Banca bancaAlterada = bancaService.update(banca);
        return ResponseEntity.ok(bancaAlterada);
    }
    */
	
	@ApiOperation(value="Altera o registro de uma banca")	
	@PutMapping(path = "/banca/{id}")
    public ResponseEntity<Banca> update(@PathVariable(value = "id") Long id,
         @Valid @RequestBody BancaDto bancaDto) {
		
        final Banca bancaAlterada = bancaService.update(bancaDto, id);
        return ResponseEntity.ok(bancaAlterada);
    }
}