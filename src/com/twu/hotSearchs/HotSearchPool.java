package com.twu.hotSearchs;

import java.util.*;
import java.util.stream.Collectors;

public class HotSearchPool {
    private Set<HotSearch> hotSearches = new TreeSet<>();

    static HotSearchPool hotSearchPool;

    private HotSearchPool() {
    }

    public static synchronized HotSearchPool createHotSearchPool() {
        if (hotSearchPool == null) {
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

    private HotSearch findHotSearch(String hsName) {
        try {
            List<HotSearch> collect = hotSearches.stream().filter(hs -> {
                return hs.getDesc().equals(hsName);
            }).collect(Collectors.toList());
            return collect.get(0);
        } catch (Exception e) {
            return null;
        }
    }

    private void sortHotSearch() {
        List<HotSearch> list = new ArrayList<>(hotSearches);

        hotSearches = new TreeSet<>();
        hotSearches.addAll(list);
        System.out.println(hotSearches);
    }

    public void voteHotSearch(String hsName, int voteNumber) throws IllegalArgumentException {
        HotSearch hotSearch = findHotSearch(hsName);
        if (hotSearch == null)
            throw new IllegalArgumentException("error argument");
        hotSearch.addHeatNumber(voteNumber);
        sortHotSearch();
    }

    public void buyHotSearch(String hsName, int money) throws IllegalArgumentException {
        HotSearch hotSearch = findHotSearch(hsName);
        if (hotSearch == null)
            throw new IllegalArgumentException("error argument");
        hotSearch.addMoney(money);
        sortHotSearch();
    }
}
