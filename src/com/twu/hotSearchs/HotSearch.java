package com.twu.hotSearchs;

import java.util.Objects;

public class HotSearch implements Comparable<HotSearch> {
    private static long id;
    private String desc;
    private int money = 0;

    private long heatNumber = 0;
    private boolean superHotSearch;

    public HotSearch(String desc){
        synchronized (HotSearch.class) {
            id++;
        }
        this.desc = desc;
    }

    public void setHeatNumber(long heatNumber) {
        this.heatNumber = heatNumber;
    }

    public long getHeatNumber() {
        return heatNumber;
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

    public void addHeatNumber(){
        if (this.isSuperHotSearch())
            this.heatNumber+=2;
        else
            this.heatNumber++;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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

        if (this.getMoney() > o.getMoney()){
            return -1;
        }else if (this.getMoney() == o.getMoney()){
            if (this.heatNumber > o.heatNumber)
                return -1;
            else if (this.heatNumber == o.heatNumber) {
                int res = this.getDesc().compareTo(o.getDesc());
                return Integer.compare(res, 0);
            }else {
                return 1;
            }
        }else
            return 1;
    }

    public void addMoney(int money) {
        this.money+=money;
    }
}
