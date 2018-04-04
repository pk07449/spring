package basic.database.validateUserFromDbAndPasswordFromThirdPartyService.security;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

/**
 * Created by pankaj on 10/29/2017.
 */
public class CustomeAutenticationCheck extends DaoAuthenticationProvider{
 /*   @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        System.out.println("CustomeAutenticationCheck.additionalAuthenticationChecks");
        if("password".equals(authentication.getCredentials())){
            ((MyUserPrincipal) userDetails).setEnabled(true);
        }
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(
                authentication.getPrincipal(), authentication.getCredentials(),
                new ArrayList<>());
        result.setDetails(authentication.getDetails());
        System.out.println("CustomeAutenticationCheck.authenticate");
//        authentication.setAuthenticated(true);
        return result;
    }*/
}
