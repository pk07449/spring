package basic.database.validateUserFromDbAndPasswordFromThirdPartyService.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by pankaj on 10/29/2017.
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("WebSecurityConfig.configure");
        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic();
    }

    @Bean
    @Autowired
    public DaoAuthenticationProvider authenticationProvider() {
        CustomDaoPasswordAuthentication customDaoPasswordAuthentication = new CustomDaoPasswordAuthentication();
        customDaoPasswordAuthentication.setUserDetailsService(userDetailsService);
        return customDaoPasswordAuthentication;
    }

    @Autowired
    public void configureGlobal(DaoAuthenticationProvider daoAuthenticationProvider,
                                AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider);
    }
}