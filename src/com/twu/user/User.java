package com.twu.user;

import com.twu.hotSearchs.HotSearch;
import com.twu.hotSearchs.HotSearchPool;

import java.util.Set;

public class User {
    protected static long sid = 0;
    protected long id;
    protected String name;
    protected HotSearchPool hotSearches;
    protected boolean isAdmin = false;

    public User(HotSearchPool hotSearches, String name, boolean isAdmin) {
        this.hotSearches = hotSearches;
        this.name = name;
        synchronized (User.class){
            sid++;
        }
        this.id = sid;
        this.isAdmin = isAdmin;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HotSearchPool getHotSearches() {
        return hotSearches;
    }

    public Set<HotSearch> viewHotSearchRank() {
        return hotSearches.getHotSearches();
    }

    public void addHotSearch(String name, String desc) {
        HotSearch hotSearch = new HotSearch(desc);
    }
}
