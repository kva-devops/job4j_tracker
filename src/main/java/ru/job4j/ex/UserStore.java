package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User elem : users) {
            if (elem.getUsername().equals(login)) {
                return elem;
            } else {
                throw new UserNotFoundException("User not found");
            }
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl =  user.isValid() && user.getUsername().length() >= 3;
        if (!rsl) {
            throw new UserInvalidException("Username not valid");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Vladimir", true)
        };
        try {
            validate(findUser(users, "Vladimir"));
            System.out.println("This user has an access");
        } catch (UserInvalidException e1) {
            e1.printStackTrace();
        } catch (UserNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
