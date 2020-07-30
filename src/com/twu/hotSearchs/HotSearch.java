package com.twu.hotSearchs;

public class HotSearch implements Comparable<HotSearch> {
    private static long id;
    private String name;
    private String desc;
    private long heatNumber;
    private boolean superHotSearch;

    public HotSearch(String name, String desc){
        synchronized (HotSearch.class) {
            id++;
        }
        this.name = name;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getHeatNumber() {
        return heatNumber;
    }

    public void setHeatNumber(long heatNumber) {
        this.heatNumber = heatNumber;
    }

    public boolean isSuperHotSearch() {
        return superHotSearch;
    }

    public void setSuperHotSearch(boolean superHotSearch) {
        this.superHotSearch = superHotSearch;
    }

    @Override
    public int compareTo(HotSearch o) {
        if (o == null)
            throw new RuntimeException();

        if (this.heatNumber > o.heatNumber)
            return 1;
        else if (this.heatNumber == o.heatNumber){
            int res = this.getName().compareTo(o.getName());
            if (res < 0)
                return 1;
            else if (res > 0)
                return -1;
            else {
                int res2 = this.getDesc().compareTo(o.getDesc());
                if (res2 < 0)
                    return 1;
                else if (res2 > 0)
                    return -1;
                else
                    return 0;
            }
        }
        else
            return -1;
    }
}
