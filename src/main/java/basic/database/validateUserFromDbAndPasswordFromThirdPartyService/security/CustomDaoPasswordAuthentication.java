package basic.database.validateUserFromDbAndPasswordFromThirdPartyService.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

/**
 * Created by pankaj on 10/29/2017.
 */
public class CustomDaoPasswordAuthentication extends DaoAuthenticationProvider {
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        System.out.println("CustomDaoPasswordAuthentication.additionalAuthenticationChecks");
        System.out.println(authentication.getCredentials());
        if ("password".equals(authentication.getCredentials())) {
            ((MyUserPrincipal) userDetails).setEnabled(true);
        } else {
            throw new BadCredentialsException("External system authentication failed");
        }
    }
}
