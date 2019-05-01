package security.basic.database.validateUserNameFromDBAWithPredifinePassUsingUserDetailsService.security;

import security.basic.database.validateUserNameFromDBAWithPredifinePassUsingUserDetailsService.entity.User;
import security.basic.database.validateUserNameFromDBAWithPredifinePassUsingUserDetailsService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        System.out.println("MyUserDetailsService.loadUserByUsername");
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(username,"passwords", Arrays.asList((GrantedAuthority) () -> "Admin"));
    }
}