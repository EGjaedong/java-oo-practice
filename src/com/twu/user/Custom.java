package com.twu.user;

import com.twu.hotSearchs.HotSearch;
import com.twu.hotSearchs.HotSearchPool;

import java.util.Set;

public class Custom {
    private static long sid = 0;
    private long id;
    private String name;
    private HotSearchPool hotSearches;

    public Custom(HotSearchPool hotSearches, String name) {
        this.hotSearches = hotSearches;
        this.name = name;
        synchronized (Custom.class){
            id++;
        }
        this.id = sid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<HotSearch> viewHotSearchRank() {
        return hotSearches.getHotSearches();
    }

    public void addHotSearch(String name, String desc) {
        HotSearch hotSearch = new HotSearch(name, desc);
    }
}
