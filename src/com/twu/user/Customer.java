package com.twu.user;

import com.twu.hotSearchs.HotSearchPool;

public class Customer extends User {
    public Customer(HotSearchPool hotSearches, String name) {
        super(hotSearches, name, false);
    }
}
