package manager;

import model.*;
import java.util.*;

public class UserManager {
    private Map<String, User> userMap = new HashMap<>();

    public void registerUser(String userId, String name){
        if(!userMap.containsKey(userId)){
            User user = new User(userId, name);
            this.userMap.put(userId, user);
        }
    }

    public User getUser(String userId){
        return this.userMap.get(userId);
    }
}
