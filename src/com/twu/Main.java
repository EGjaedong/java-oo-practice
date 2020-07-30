package com.twu;

import com.twu.hotSearchs.HotSearch;
import com.twu.hotSearchs.HotSearchPool;
import com.twu.user.Admin;
import com.twu.user.Customer;
import com.twu.user.UserPool;

public class Main {

    public static void main(String[] args) {
        HotSearchPool hotSearchPool = HotSearchPool.createHotSearchPool();

        UserPool userPool = new UserPool(hotSearchPool);
        addUser(userPool);

        initHotSearch(hotSearchPool);

        System.out.println(userPool);
        System.out.println(hotSearchPool);


    }

    public static void addUser(UserPool userPool){
        userPool.addUser("admin1", true);
        userPool.addUser("admin2", true);
        userPool.addUser("customer1", false);
        userPool.addUser("customer2", false);
        userPool.addUser("customer3", false);
    }

    public static void initHotSearch(HotSearchPool hotSearchPool){
        HotSearch hs1 = new HotSearch("no1");
        HotSearch hs2 = new HotSearch("no2");
        HotSearch hs3 = new HotSearch("no3");

        hotSearchPool.addSearch(hs1);
        hotSearchPool.addSearch(hs2);
        hotSearchPool.addSearch(hs3);
    }
}
