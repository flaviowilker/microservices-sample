package br.micro.monitorservice.props;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties("props")
@Data
@NoArgsConstructor
public class Properties {

    private ClientDetail client;
    
    @Data
    @NoArgsConstructor
    public static class ClientDetail {

    	private String clientId;
        private String secret;
        private String accessTokenService;
        private String accessTokenPath;
    }
}
