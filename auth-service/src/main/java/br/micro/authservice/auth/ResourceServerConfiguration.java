package br.micro.authservice.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import br.micro.authservice.props.PathRequest;
import br.micro.authservice.props.Privileges;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private final TokenStore tokenStore;

    public ResourceServerConfiguration(final TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public void configure(final ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(tokenStore);
    }
    
    @Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(PathRequest.ACTUATOR_INFO, PathRequest.ACTUATOR_HEALTH).permitAll()
				.antMatchers(PathRequest.ACTUATOR).hasAuthority(Privileges.AUTHORITY_ACTUATOR)
				.antMatchers(PathRequest.SWAGGER).hasAuthority(Privileges.AUTHORITY_SWAGGER)
				.anyRequest().authenticated();
    }
    
}
