package basic.database.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

public class MyUserPrincipal extends User {
    private basic.database.entity.User user;
    private boolean isEnabled;

    public MyUserPrincipal(String username, String password, Collection<GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return  user.getAuthorities().stream().map(auth -> (GrantedAuthority) () -> auth).collect(Collectors.toList());
    }


    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}