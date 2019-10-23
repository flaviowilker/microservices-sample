package br.micro.authservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "t_oauth_client_details", schema = "seguranca")
public class OauthClientDetails {
	
	@Id
	@Column(name="cod_oauth_client_details")
	private Integer codOauthClientDetails;
	
	@Column(name="client_id", length = 256, unique = true)
	private String clientId;
	
	@Column(name="resource_ids", length = 256)
	private String resourceIds;
	
	@Column(name="client_secret", length = 256)
	private String clientSecret;
	
	@Column(name="scope", length = 256)
	private String scope;
	
	@Column(name="authorized_grant_types", length = 256)
	private String authorizedGrantTypes;
	
	@Column(name="web_server_redirect_uri", length = 256)
	private String webServerRedirectUri;
	
	@Column(name="authorities", length = 256)
	private String authorities;
	
	@Column(name="access_token_validity")
	private Integer accessTokenValidity;
	
	@Column(name="refresh_token_validity")
	private Integer refreshTokenValidity;
	
	@Column(name="additional_information", length=4000)
	private String additionalInformation;
	
	@Column(name="autoapprove", length = 256)
	private String autoapprove;
	
}
