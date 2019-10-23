package br.micro.funcionariosservice.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

import lombok.Data;
import lombok.NoArgsConstructor;

@ConfigurationProperties("props")
public class Properties {

    private JwtProperties jwt;

    public JwtProperties getJwt() {
        return jwt;
    }

    public void setJwt(JwtProperties jwt) {
        this.jwt = jwt;
    }

    @Data
    @NoArgsConstructor
    public static class JwtProperties {

    	private Resource publicKey;
    }
}
