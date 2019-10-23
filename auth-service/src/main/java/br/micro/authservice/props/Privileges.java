package br.micro.authservice.props;

public class Privileges {
	
	public static final String AUTHORITY_ACTUATOR = "ACTUATOR";
	public static final String AUTHORITY_SWAGGER = "SWAGGER";
	
	public static final String ACCESS_OAUTH_READ = "#oauth2.hasScope('read')";
	public static final String ACCESS_OAUTH_WRITE = "#oauth2.hasScope('write')";
}
