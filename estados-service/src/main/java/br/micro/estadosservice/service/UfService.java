package br.micro.estadosservice.service;

import java.util.List;

import br.micro.estadosservice.entity.Uf;

public interface UfService {
	
	public List<Uf> buscarTodos();
	
	public Uf buscarPorIsn(Integer isn);
	
	public Uf salvar(Uf entity);
}
