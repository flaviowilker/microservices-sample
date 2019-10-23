package br.micro.funcionariosservice.auth;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import br.micro.funcionariosservice.props.PathRequest;
import br.micro.funcionariosservice.props.Privileges;
import br.micro.funcionariosservice.props.Properties;

@Configuration
@EnableResourceServer
@EnableConfigurationProperties(Properties.class)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
    private final Properties properties;

    private TokenStore tokenStore;

    public ResourceServerConfiguration(final Properties properties) {
        this.properties = properties;
    }

    @Override
    public void configure(final ResourceServerSecurityConfigurer resources) {
        resources.tokenStore(tokenStore());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        		.antMatchers(PathRequest.ACTUATOR_INFO, PathRequest.ACTUATOR_HEALTH).permitAll()
        		.antMatchers(PathRequest.ACTUATOR).hasAuthority(Privileges.AUTHORITY_ACTUATOR)
        		.antMatchers(PathRequest.SWAGGER).hasAuthority(Privileges.AUTHORITY_SWAGGER)
                .antMatchers(HttpMethod.GET, PathRequest.ROOT_PATTERN).access(Privileges.ACCESS_OAUTH_READ)
                .antMatchers(HttpMethod.POST, PathRequest.ROOT_PATTERN).access(Privileges.ACCESS_OAUTH_WRITE)
                .antMatchers(HttpMethod.PATCH, PathRequest.ROOT_PATTERN).access(Privileges.ACCESS_OAUTH_WRITE)
                .antMatchers(HttpMethod.PUT, PathRequest.ROOT_PATTERN).access(Privileges.ACCESS_OAUTH_WRITE)
                .antMatchers(HttpMethod.DELETE, PathRequest.ROOT_PATTERN).access(Privileges.ACCESS_OAUTH_WRITE);
    }

    @Bean
    public DefaultTokenServices tokenServices(final TokenStore tokenStore) {
        var tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        return tokenServices;
    }

    @Bean
    public TokenStore tokenStore() {
        if (tokenStore == null) {
            tokenStore = new JwtTokenStore(jwtAccessTokenConverter());
        }
        return tokenStore;
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        var converter = new JwtAccessTokenConverter();
        converter.setVerifierKey(getPublicKeyAsString());
        return converter;
    }

    private String getPublicKeyAsString() {
        try {
        	var publicKeyFile = properties.getJwt().getPublicKey().getFile();
        	var publicKeyString = new String(Files.readAllBytes(publicKeyFile.toPath()), StandardCharsets.UTF_8);
        	
            return publicKeyString;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
