package io.recepkara.project.library.system;

import io.recepkara.project.library.repo.user.AdminUser;
import io.recepkara.project.library.repo.user.Customer;
import io.recepkara.project.library.repo.user.SystemUser;
import io.recepkara.project.library.exceptions.UserLogInException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class SystemContext {
    private static  Integer loggedInUserId;
    private  static  boolean isAdmin=false;
    private static  final Map<String,String> properties= new HashMap<>();

    public static void addProperty(String name,String value)
    {
        properties.put(name,value);
    }
    public static String  getProperty(String name)
    {
       return properties.get(name);
    }
    public static boolean isLoggedInUserAdmin(){

        return isAdmin;

    }
    public  static  Integer getLoggedInUserId(){
        return Optional
                .ofNullable(loggedInUserId)
                .orElseThrow(() -> new UserLogInException("No log in info available"));
        }
    public  static  void  logInUser(SystemUser user){
        switch (user) {
            case null -> throw new UserLogInException("Log in user is null");
            case Customer customer -> {
                loggedInUserId = user.getId();
                isAdmin=false;
            }
            case AdminUser adminUser ->{
                loggedInUserId = user.getId();
                isAdmin=true;
            }
            default -> throw new UserLogInException("Unsupported user type: "+user);
        }
    }
    public  static  void logOut(){
        loggedInUserId=null;
        isAdmin=false;
    }

    public static void removeProperty(String key) {
        properties.remove(key);
    }
}
