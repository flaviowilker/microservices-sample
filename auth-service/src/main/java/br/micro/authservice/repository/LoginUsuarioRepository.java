package br.micro.authservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.micro.authservice.entity.LoginUsuario;

@Repository
public interface LoginUsuarioRepository extends CrudRepository<LoginUsuario, Integer> {
	
	Optional<LoginUsuario> findByLogin(String login);
}
