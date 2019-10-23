package br.micro.funcionariosservice.service;

import java.util.List;

import br.micro.funcionariosservice.entity.Funcionario;

public interface FuncionarioService {
	
	public List<Funcionario> buscarTodos();
	
	public Funcionario buscarPorIsn(Integer isn);
	
	public Funcionario salvar(Funcionario entity);
}
