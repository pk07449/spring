package basic.database.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

/**
 * Created by pankaj on 10/29/2017.
 */
public class CustomeAutenticationCheck extends DaoAuthenticationProvider{
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if("epassword".equals(authentication.getCredentials())){
            ((MyUserPrincipal) userDetails).setEnabled(true);
        }
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                authentication.getPrincipal(), authentication.getCredentials(),
                new ArrayList<>());
        result.setDetails(authentication.getDetails());
//        authentication.setAuthenticated(true);
        return result;
    }
}
