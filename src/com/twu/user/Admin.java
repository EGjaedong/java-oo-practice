package com.twu.user;

import com.twu.hotSearchs.HotSearch;
import com.twu.hotSearchs.HotSearchPool;

import java.util.Set;

public class Admin {
    private long id;
    private String name;
    private HotSearchPool hotSearches;

    public Admin(HotSearchPool hotSearches) {
        this.hotSearches = hotSearches;
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

    public void addSuperHotSearch(String name, String desc){
        HotSearch hotSearch = new HotSearch(name, desc);
        hotSearch.setSuperHotSearch(true);
    }
}
