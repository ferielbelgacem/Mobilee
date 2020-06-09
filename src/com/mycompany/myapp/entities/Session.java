package com.mycompany.myapp.entities;

/**
 *
 * @author arij
 */
public class Session {
    
    

    private static User User=null;

    public static void start(User currentUser) {
        User = currentUser;
    }

    public static User getCurrentSession() {
        if (User != null) {
            return User;
        }
        return null;

    }
    
        public static void close() throws Exception {
        if (User != null) {
            User =null;
        } else {
            throw new Exception("Session has not started yet!");
        }
    }

    public void show() {
    }

}
