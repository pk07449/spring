package basic.database.validateUserNameFromDBAWithPredifinePassUsingUserDetailsService.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class MyUserPrincipal extends User {
    private boolean isEnabled;

    public MyUserPrincipal(String username, String password, Collection<GrantedAuthority> authorities) {
        super(username, password, authorities);
        System.out.println("MyUserPrincipal.MyUserPrincipal");
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        System.out.println("MyUserPrincipal.getAuthorities");
        return super.getAuthorities();
    }


    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
        System.out.println("MyUserPrincipal.setEnabled");
//        super.set(enabled);
    }
}