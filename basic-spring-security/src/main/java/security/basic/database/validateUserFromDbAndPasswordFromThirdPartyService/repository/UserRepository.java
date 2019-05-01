package security.basic.database.validateUserFromDbAndPasswordFromThirdPartyService.repository;

import security.basic.database.validateUserFromDbAndPasswordFromThirdPartyService.entity.User;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public User findByUsername(String username) {
        if ("pankaj".equals(username)) {
            return new User();
        } else {
            throw new AccessDeniedException(
                    "Can't change password as no Authentication object found in context "
                            + "for current user.");

        }

    }
}