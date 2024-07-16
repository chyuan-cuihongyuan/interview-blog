package com.chyuan.blog.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author cuihongyuan
 * @Date: 2024/7/16 0016  - 1:05
 * @Description: com.chyuan.blog.util
 * @version: 1.0
 */
public class PasswordUtil {
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}