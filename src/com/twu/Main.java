package com.twu;

import com.twu.hotSearchs.HotSearch;
import com.twu.hotSearchs.HotSearchPool;
import com.twu.user.User;
import com.twu.user.UserPool;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HotSearchPool hotSearchPool = HotSearchPool.createHotSearchPool();

        UserPool userPool = new UserPool(hotSearchPool);
        addUser(userPool);

        initHotSearch(hotSearchPool);

        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (true) {
            System.out.println("Please input your name:\n");
            input = scanner.nextLine();
            if (input.equals("quit"))
                break;
            User user = findUser(userPool, input);
            if (user == null) {
                System.out.println("User is not exist,Please try again.");
                continue;
            }
            boolean isAdmin = judgeIsAdmin(user);
            if (isAdmin) {
                boolean isQuit = adminOption(scanner, input);
                if (isQuit)
                    break;
            }
            else {
                boolean isQuit = costumerOption(scanner, input);
                if (isQuit)
                    break;
            }
        }
    }

    private static boolean adminOption(Scanner scanner, String input) {
        while (true) {
            System.out.println("Please select your option: 1、watch hot search. 2、add hot search. 3、add super hot search\n");
            input = scanner.nextLine();
            if (input.equals("quit"))
                return true;
            switch (input) {
                case "1":
                    System.out.println("1");
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                default:
                    System.out.println("Please select right option!");
                    break;
            }
        }
    }

    private static boolean costumerOption(Scanner scanner, String input) {
        while (true) {
            System.out.println("Please select your option: 1、watch hot search. 2、vote to hot search. 3、add hot search. 4、by hot search\n");
            input = scanner.nextLine();
            if (input.equals("quit"))
                return true;
            switch (input) {
                case "1":
                    System.out.println("1");
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
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

    private static boolean judgeIsAdmin(User user) {
        return user.isAdmin();
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
        HotSearch hs2 = new HotSearch("no2");
        HotSearch hs3 = new HotSearch("no3");

        hotSearchPool.addSearch(hs1);
        hotSearchPool.addSearch(hs2);
        hotSearchPool.addSearch(hs3);
    }

    public static User findUser(UserPool userPool, String userName) {
        User user = userPool.findUser(userName);
        return user;
    }
}
