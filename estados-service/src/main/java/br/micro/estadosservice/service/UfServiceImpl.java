package br.micro.estadosservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.micro.estadosservice.entity.Uf;
import br.micro.estadosservice.repository.UfRepository;

@Service
public class UfServiceImpl implements UfService {

	@Autowired
	private UfRepository ufRepository;

	@Override
	public List<Uf> buscarTodos() {
		return ufRepository.genericFindAll();
	}

	@Override
	public Uf buscarPorIsn(Integer isn) {
		return ufRepository.genericfindById(isn);
	}

	@Override
	@Transactional
	public Uf salvar(Uf entity) {
		return ufRepository.save(entity);
	}	
}