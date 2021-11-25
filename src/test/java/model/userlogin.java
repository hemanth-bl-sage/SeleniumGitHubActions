package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userlogin {
    public String companyId;
    public String userId;
    public String password;

    public static userlogin userLogin(Map<String, String> entry){
        userlogin login = new userlogin();
        login.setCompanyId(entry.get("companyId"));
        login.setUserId(entry.get("userId"));
        login.setPassword(entry.get("password"));
        return login;
    }
}
