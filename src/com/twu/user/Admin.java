package com.twu.user;

import com.twu.hotSearchs.HotSearch;
import com.twu.hotSearchs.HotSearchPool;

public class Admin extends User {
    public Admin(HotSearchPool hotSearches, String name) {
        super(hotSearches, name, true);
    }

    public void addSuperHotSearch(String desc) {
        HotSearch hotSearch = new HotSearch(desc);
        hotSearch.setSuperHotSearch(true);
        hotSearches.addSearch(hotSearch);
    }
}
