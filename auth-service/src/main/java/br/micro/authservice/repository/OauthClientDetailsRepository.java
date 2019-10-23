package br.micro.authservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.micro.authservice.entity.OauthClientDetails;

@Repository
public interface OauthClientDetailsRepository extends CrudRepository<OauthClientDetails, String> {
	
	Optional<OauthClientDetails> findByClientId(String clientId);
}
