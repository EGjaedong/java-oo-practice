package com.twu;

import com.twu.hotSearchs.HotSearchPool;
import com.twu.user.Admin;
import com.twu.user.Customer;
import com.twu.user.UserPool;

public class Main {

    public static void main(String[] args) {
        HotSearchPool hotSearchPool = HotSearchPool.createHotSearchPool();

        UserPool userPool = new UserPool(hotSearchPool);

        userPool.addUser("admin1", true);
        userPool.addUser("admin2", true);
        userPool.addUser("customer1", false);
        userPool.addUser("customer2", false);
        userPool.addUser("customer3", false);





    }
}
