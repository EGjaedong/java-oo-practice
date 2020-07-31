package com.twu.user;

import com.twu.hotSearchs.HotSearchPool;

public class Customer extends User {
    private int voteNumber = 10;
    public Customer(HotSearchPool hotSearches, String name) {
        super(hotSearches, name, false);
    }

    public String voteToHotSearch(String hsName, int votes) throws IllegalArgumentException {
        if (voteNumber > 0){
            hotSearches.voteHotSearch(hsName, votes);
            reduceVoteNumber(votes);
            return "success";
        }else
            return "vote number is not enough";
    }

    private void reduceVoteNumber(int votes) {
        voteNumber--;
    }

    public void buyHotSearch(String hsName, int money) throws IllegalArgumentException {
        hotSearches.buyHotSearch(hsName, money);
    }
}
