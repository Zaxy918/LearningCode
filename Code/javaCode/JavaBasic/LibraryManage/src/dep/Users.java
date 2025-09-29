package dep;

import java.util.ArrayList;

public class Users {
    private static ArrayList<User> users;
    private static final int MAX_USERS = 50;

    static {
        users = new ArrayList<User>(MAX_USERS);
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static void removeUser(User user) {
        users.remove(user);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User getUser(String id, String passWord) {
        for (User user : users) {
            if (user.getId().equals(id) && user.getPassWord().equals(passWord)) {
                return user;
            }
        }
        return null;
    }

    public static boolean userExists(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}