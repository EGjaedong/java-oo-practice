package com.twu.hotSearchs;

import java.util.*;

public class HotSearchPool {
    private Set<HotSearch> hotSearches = new TreeSet<>();

    static HotSearchPool hotSearchPool;

    private HotSearchPool(){}

    public static synchronized HotSearchPool createHotSearchPool() {
        if (hotSearchPool == null){
            hotSearchPool = new HotSearchPool();
        }

        return hotSearchPool;
    }

    public Set<HotSearch> getHotSearches() {
        return hotSearches;
    }

    public void setHotSearches(Set<HotSearch> hotSearches) {
        this.hotSearches = hotSearches;
    }

    public void addSearch(HotSearch search) {
        synchronized (this) {
            hotSearches.add(search);
        }
    }
}
