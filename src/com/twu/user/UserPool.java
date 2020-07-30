package com.twu.user;

import com.twu.hotSearchs.HotSearchPool;

import java.util.HashMap;
import java.util.Map;

public class UserPool {
    private Map<String, User> users = new HashMap();
    private HotSearchPool hotSearches;

    public UserPool(HotSearchPool hotSearchPool) {
        this.hotSearches = hotSearchPool;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public void addUser(String name, boolean isAdmin) {
        User user = new User(hotSearches, name, isAdmin);
        this.users.put(user.getName(), user);
    }

    public boolean isAdmin(String userName) {
        User user = users.get(userName);
        return user.isAdmin;
    }

    public User findUser(String userName){
        return users.get(userName);
    }
}
