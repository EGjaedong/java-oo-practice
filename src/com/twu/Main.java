package com.twu;

import com.twu.hotSearchs.HotSearch;
import com.twu.hotSearchs.HotSearchPool;
import com.twu.user.Admin;
import com.twu.user.Customer;
import com.twu.user.User;
import com.twu.user.UserPool;

import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        HotSearchPool hotSearchPool = HotSearchPool.createHotSearchPool();

        UserPool userPool = new UserPool(hotSearchPool);
        addUser(userPool);

        initHotSearch(hotSearchPool);

        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (true) {
            System.out.println("Please input your name to login:\n");
            input = scanner.nextLine();
            if (input.equals("quit"))
                break;
            if (input.equals("logout"))
                continue;
            User user = findUser(userPool, input);
            if (user == null) {
                System.out.println("User is not exist, Please try again.");
                continue;
            }
            boolean isAdmin = user.isAdmin();
            String optionString = null;
            if (isAdmin) {
                optionString = adminOption(scanner, user);
            }
            else {
                optionString = costumerOption(scanner, user);
            }
            assert optionString != null;
            if (optionString.equals("quit"))
                break;
            else if (optionString.equals("logout"))
                continue;
        }
    }

    private static String adminOption(Scanner scanner, User user) {
        while (true) {
            System.out.println("Please select your option: 1、watch hot search. 2、add hot search. 3、add super hot search\n");
            String input = scanner.nextLine();
            if (input.equals("quit") || input.equals("logout"))
                return input;
            switch (input) {
                case "1":
                    watchHotSearch(user);
                    break;
                case "2":
                    addHotSearch(scanner, user);
                    watchHotSearch(user);
                    break;
                case "3":
                    addSuperHotSearch(scanner, user);
                    watchHotSearch(user);
                    break;
                default:
                    System.out.println("Please select right option!");
                    break;
            }
        }
    }

    private static String costumerOption(Scanner scanner, User user) {
        while (true) {
            System.out.println("Please select your option: 1、watch hot search. 2、add hot search. 3、vote to hot search. 4、by hot search\n");
            String input = scanner.nextLine();
            if (input.equals("quit") || input.equals("logout"))
                return input;
            switch (input) {
                case "1":
                    watchHotSearch(user);
                    break;
                case "2":
                    addHotSearch(scanner, user);
                    watchHotSearch(user);
                    break;
                case "3":
                    System.out.println("Please input hot search name:\n");
                    input = scanner.nextLine();
                    Customer customer = (Customer) user;
                    try {
                        customer.voteToHotSearch(input);
                    }catch (Exception e){
                        System.out.println("Hot Search not found");
                        break;
                    }
                    watchHotSearch(user);
                    System.out.println("3");
                    break;
                case "4":

                    System.out.println("4");
                    break;
                default:
                    System.out.println("Please select right option!");
                    break;
            }
        }
    }

    private static void voteToHotSearch(User user) {

    }

    private static void addSuperHotSearch(Scanner scanner, User user) {
        Admin admin = null;
        if (user.isAdmin()){
            admin = (Admin) user;
        }
        System.out.println("Please input hot search name");
        String input = scanner.nextLine();
        assert admin != null;
        admin.addSuperHotSearch(input);
    }

    private static void printHotSearchRank(Set<HotSearch> hotSearches){
        hotSearches.stream().limit(10).forEach(hs->{
            String su = hs.isSuperHotSearch() ? " ---- super" : "";
            System.out.println(hs.getDesc() + " heat number is " + hs.getHeatNumber() + su);
        });
    }

    private static void watchHotSearch(User user){
        Set<HotSearch> hotSearches = user.viewHotSearchRank();
        printHotSearchRank(hotSearches);
    }

    private static void addHotSearch(Scanner scanner, User user){
        System.out.println("Please input hot search name");
        String input = scanner.nextLine();
        user.addHotSearch(input);
    }

    public static void addUser(UserPool userPool) {
        userPool.addUser("admin1", true);
        userPool.addUser("admin2", true);
        userPool.addUser("customer1", false);
        userPool.addUser("customer2", false);
        userPool.addUser("customer3", false);
    }

    public static void initHotSearch(HotSearchPool hotSearchPool) {
        HotSearch hs1 = new HotSearch("no1");
        hs1.setHeatNumber(10);
        HotSearch hs2 = new HotSearch("no2");
        hs2.setHeatNumber(15);
        HotSearch hs3 = new HotSearch("no3");
        hs3.setHeatNumber(13);
        HotSearch hs4 = new HotSearch("no4");
        hs4.setHeatNumber(7);
        HotSearch hs5 = new HotSearch("no5");
        hs5.setHeatNumber(7);

        hotSearchPool.addSearch(hs1);
        hotSearchPool.addSearch(hs2);
        hotSearchPool.addSearch(hs3);
        hotSearchPool.addSearch(hs4);
        hotSearchPool.addSearch(hs5);
    }

    public static User findUser(UserPool userPool, String userName) {
        User user = userPool.findUser(userName);
        return user;
    }
}
