package br.micro.funcionariosservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.micro.funcionariosservice.entity.Funcionario;
import br.micro.funcionariosservice.repository.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> buscarTodos() {
		return funcionarioRepository.genericFindAll();
	}

	@Override
	public Funcionario buscarPorIsn(Integer isn) {
		return funcionarioRepository.genericfindById(isn);
	}

	@Override
	@Transactional
	public Funcionario salvar(Funcionario entity) {
		return funcionarioRepository.save(entity);
	}	
}