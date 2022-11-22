package br.com.exemplo.crud.rest.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.crud.rest.api.model.PessoaModel;
import br.com.exemplo.crud.rest.api.service.PessoaService;

@RestController
@RequestMapping(value="/v1/pessoa")
public class PessoaController {
	
	final PessoaService pessoaService;
	public PessoaController(PessoaService pessoaService){
		this.pessoaService = pessoaService;
	}
	
	//FindAll
	@GetMapping(value="/listar")
	public ResponseEntity<Object>findAll(){
	return ResponseEntity.status(HttpStatus.OK).body(pessoaService.BuscarTodos());	
	}
		
	//create
	@RequestMapping(value = "/adicionar")
	@PostMapping
	public ResponseEntity<PessoaModel>adicionar(@RequestBody PessoaModel pessoa){
	return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.Salvar(pessoa));
	}
	
	//read
	@GetMapping(value="/findById/{id}")
	public ResponseEntity<Object>ler(@PathVariable(value="id") int id){
	return ResponseEntity.status(HttpStatus.OK).body(pessoaService.Ler(id));		
	}
	
	//update
	@RequestMapping(value = "/update")
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody PessoaModel pessoa){
	return ResponseEntity.status(HttpStatus.OK).body(pessoaService.update(pessoa));	
	}
	
	//delete
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void>excluir(@PathVariable int id){
		pessoaService.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna um conteudo vazio 204
	}
}
