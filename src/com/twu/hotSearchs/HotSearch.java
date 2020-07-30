package com.twu.hotSearchs;

import java.util.Objects;

public class HotSearch implements Comparable<HotSearch> {
    private static long id;
    private String desc;
    private long heatNumber = 0;
    private boolean superHotSearch;

    public HotSearch(String desc){
        synchronized (HotSearch.class) {
            id++;
        }
        this.desc = desc;
    }

    public long getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isSuperHotSearch() {
        return superHotSearch;
    }

    public void setSuperHotSearch(boolean superHotSearch) {
        this.superHotSearch = superHotSearch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotSearch hotSearch = (HotSearch) o;
        return Objects.equals(desc, hotSearch.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(desc);
    }

    @Override
    public int compareTo(HotSearch o) {
        if (o == null)
            throw new RuntimeException();

        if (this.heatNumber > o.heatNumber)
            return 1;
        else if (this.heatNumber == o.heatNumber) {
            int res = this.getDesc().compareTo(o.getDesc());
            if (res > 0)
                return 1;
            else if (res < 0)
                return -1;
            else
                return 0;
        }else {
            return -1;
        }
    }
}
