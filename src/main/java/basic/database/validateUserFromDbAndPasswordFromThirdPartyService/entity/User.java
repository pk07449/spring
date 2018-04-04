package basic.database.validateUserFromDbAndPasswordFromThirdPartyService.entity;

import java.util.List;


public class User {
 
    private Long id;
 
    private String username;
 
    private List<String> authorities;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public  List<String> getAuthorities() {
        return  this.authorities;
    }

    //standard getters and setters
}