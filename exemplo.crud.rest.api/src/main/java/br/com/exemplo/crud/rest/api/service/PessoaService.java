package br.com.exemplo.crud.rest.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.exemplo.crud.rest.api.model.PessoaModel;
import br.com.exemplo.crud.rest.api.repository.PessoaRepository;
@Service
public class PessoaService {
	
	PessoaRepository pessoaRepository;
	PessoaService(PessoaRepository pessoaRepository){
		this.pessoaRepository = pessoaRepository;
	}
	//FindAll
	public List<PessoaModel>BuscarTodos(){
		return pessoaRepository.findAll(); 
	}
	
	//Create
	public PessoaModel Salvar(PessoaModel pessoa){	
		return pessoaRepository.save(pessoa);
	}
	//Read
	public Optional<PessoaModel> Ler(int id){
		return pessoaRepository.findById(id);
	}
	//Update
	public PessoaModel update(PessoaModel pessoa){
		return pessoaRepository.save(pessoa);
	}
	
	//Delete
	public void delete(int id){
		pessoaRepository.deleteById(id);
	}
}
