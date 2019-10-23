package br.micro.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import br.micro.authservice.entity.OauthClientDetails;
import br.micro.authservice.repository.OauthClientDetailsRepository;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Autowired
	private OauthClientDetailsRepository oauthClientDetailsRepository;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		
		OauthClientDetails oauthClientDetails = oauthClientDetailsRepository.findByClientId(clientId).orElseThrow(() -> new RuntimeException("ClientDetails não encontrado: " + clientId));
		
		BaseClientDetails baseClientDetails = new BaseClientDetails(oauthClientDetails.getClientId(),
				oauthClientDetails.getResourceIds(), oauthClientDetails.getScope(),
				oauthClientDetails.getAuthorizedGrantTypes(), oauthClientDetails.getAuthorities(),
				oauthClientDetails.getWebServerRedirectUri());
		
		baseClientDetails.setClientSecret(oauthClientDetails.getClientSecret());
		baseClientDetails.setAccessTokenValiditySeconds(oauthClientDetails.getAccessTokenValidity());
		baseClientDetails.setRefreshTokenValiditySeconds(oauthClientDetails.getRefreshTokenValidity());
		
		return baseClientDetails;
	}

}
