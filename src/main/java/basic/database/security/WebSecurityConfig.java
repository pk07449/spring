package basic.database.security;

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
        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
//        CustomeAutenticationCheck customeAutenticationCheck = new CustomeAutenticationCheck();
//        customeAutenticationCheck.setUserDetailsService(userDetailsService);
//        return customeAutenticationCheck;
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(encoder());
        return  daoAuthenticationProvider;

    }

//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder(11);
//    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
        auth.userDetailsService(userDetailsService);

    }

    // create two users, admin and user

}