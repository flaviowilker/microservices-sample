package br.micro.documentationservice.config;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class QueryParamPreFilter extends ZuulFilter {
	
	@Autowired
	private OAuth2RestTemplate template;
	
	@Override
	public int filterOrder() {
		return PRE_DECORATION_FILTER_ORDER - 1;
	}

	@Override
	public String filterType() {
		return PRE_TYPE;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
		return !ctx.containsKey("Authorization");
	}
	
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
    	ctx.addZuulRequestHeader("Authorization", template.getAccessToken().getTokenType() + " " + template.getAccessToken().getValue());
        return null;
    }
    
    @Bean
    public OAuth2RestTemplate oauth2RestTemplate() {
		
		var clientDetails = new ClientCredentialsResourceDetails();
		clientDetails.setClientId("clientService");
		clientDetails.setClientSecret("secret");
		clientDetails.setAccessTokenUri("https://localhost:8086/oauth/token");
		
	    return new OAuth2RestTemplate(clientDetails);
	}
}
