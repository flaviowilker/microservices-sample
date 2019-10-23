package br.micro.monitorservice.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import com.netflix.discovery.EurekaClient;

import br.micro.monitorservice.client.BearerAuthHeaderProvider;
import br.micro.monitorservice.props.Properties;
import de.codecentric.boot.admin.server.config.AdminServerAutoConfiguration;
import de.codecentric.boot.admin.server.config.AdminServerProperties;

@Configuration
@EnableConfigurationProperties(Properties.class)
public class AdminServerConfiguration extends AdminServerAutoConfiguration {

	private final Properties properties;
	private final EurekaClient discoveryClient;

	public AdminServerConfiguration(AdminServerProperties adminServerProperties, Properties properties,
			EurekaClient discoveryClient) {
		super(adminServerProperties);
		this.properties = properties;
		this.discoveryClient = discoveryClient;
	}

	@Bean
	@Order(0)
	@ConditionalOnMissingBean
	public BearerAuthHeaderProvider bearerAuthHeaderProvider() {
		var authServiceUrl = discoveryClient.getNextServerFromEureka(properties.getClient().getAccessTokenService(), true).getHomePageUrl();
		var accessTokenUrl = authServiceUrl.concat(properties.getClient().getAccessTokenPath());

		var details = new ClientCredentialsResourceDetails();
		details.setClientId(properties.getClient().getClientId());
		details.setClientSecret(properties.getClient().getSecret());
		details.setAccessTokenUri(accessTokenUrl);

		return new BearerAuthHeaderProvider(new OAuth2RestTemplate(details));
	}
}
