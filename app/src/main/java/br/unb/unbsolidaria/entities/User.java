package br.unb.unbsolidaria.entities;

import java.io.Serializable;
import java.util.List;

import br.unb.unbsolidaria.persistency.Database;

/**
 * asm95 day 2016-12-04
 * Ideally this should be a super class of Voluntary and Organization because both of them are Users.
 * However, doing that so will just mess up with .persistency.DataBase
 */
public class User implements Serializable {
    private String      login;
    private String      password;
    private UserType    type;
    private int         id;

    public enum UserType{
        organization, voluntary
    }

    private static int PASS_MAX_LEN = 45;
    private static List<User> mUserList = Database.getInstance().getUsers();

    //source: http://stackoverflow.com/a/16058059
    private static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public User(String login, String password, UserType type, int id) {
        if (id < 0)
            throw new IllegalArgumentException("User ID must be positive");
        if (!isValidEmailAddress(login))
            throw new IllegalArgumentException("E-mail adress is not valid");
        if (password.length() > PASS_MAX_LEN)
            throw new IllegalArgumentException("Password is not valid. Length > " + PASS_MAX_LEN);

        this.login = login;
        this.password = password;
        this.type = type;
        this.id = id;
    }

    public static User getUserFromCredentials(String login, String password){
        if (!User.isValidEmailAddress(login))
            throw  new IllegalArgumentException("E-mail adress is not valid");
        if (password.length() > PASS_MAX_LEN)
            throw new IllegalArgumentException("Password is not valid. Length > " + PASS_MAX_LEN);

        //note: As the database is local we just use the very basic linear search O(n).
        for(User user : mUserList){
            if (user.login.equals(login))
                if (user.password.equals(password))
                    return user;
        }

        return null;
    }

    public int getId(){
        return this.id;
    }

    public UserType getType(){
        return this.type;
    }
}
