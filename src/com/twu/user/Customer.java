package com.twu.user;

import com.twu.hotSearchs.HotSearchPool;

public class Customer extends User {
    private int voteNumber = 10;
    public Customer(HotSearchPool hotSearches, String name) {
        super(hotSearches, name, false);
    }

    public String voteToHotSearch(String hsName) throws IllegalArgumentException {
        if (voteNumber > 0){
            hotSearches.voteHotSearch(hsName);
            reduceVoteNumber();
            return "success";
        }else
            return "vote number is not enough";
    }

    private void reduceVoteNumber() {
        voteNumber--;
    }

    public void buyHotSearch(String hsName, double money) throws IllegalArgumentException {
        hotSearches.buyHotSearch(hsName, money);
    }
}
