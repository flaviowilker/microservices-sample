package br.micro.funcionariosservice.repository;

import org.springframework.stereotype.Repository;

import br.micro.funcionariosservice.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends GenericRepository<Funcionario, Integer> {
}