package br.com.exemplo.crud.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.exemplo.crud.rest.api.model.PessoaModel;
@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Integer>{
}
