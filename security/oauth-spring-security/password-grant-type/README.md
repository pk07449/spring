# Running : 

each module(authorization-server and resource-server) needs to run in a different terminal window: `mvn clean spring-boot:run`
or the main class can be run from any IDE.

Password grant:
The password grant is similar to client credentials in term of the flow for obtaining the token except that it uses actual user credentials. It also implies that a user needs to be configured for the application. The web security config is as follows:

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("gwidgets").password("gwidgets").authorities("CLIENT");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/test.html").and().csrf().disable();
	}
}


And then we can use the user credentials to obtain a token, as below:

curl -X POST --user my-trusted-client:mysecret localhost:8081/oauth/token -d 'grant_type=password&username=gwidgets&password=gwidgets' -H "Accept: application/json"
Response:
{
  "access_token": "3670fea1-eab3-4981-b80a-e5c57203b20e",
  "token_type": "bearer",
  "expires_in": 51,
  "scope": "read write trust"
}
Note : The password grant does not support a refresh token.