package org.treadstone.jenkins.analyzer.utils;

import org.treadstone.jenkins.analyzer.Users;

public class Util {

    public static synchronized Users getAuthor(String alias) {
        for (Users user : Users.values()) {
            for (String knownName : user.getKnownNames()) {
                if (alias.contains(knownName)) {
                    return user;
                }
            }
        }
        return null;
    }

}
