package br.micro.authservice.props;

public class PathRequest {
	
	public static final String ROOT_PATTERN = "/**";
	public static final String ACTUATOR = "/actuator/**";
	public static final String ACTUATOR_INFO = "/actuator/info";
	public static final String ACTUATOR_HEALTH = "/actuator/health";
	public static final String[] SWAGGER = {
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };
}
