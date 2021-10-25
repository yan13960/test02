package com.javacto.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="123";
        String pwd = encodePassword(password);
        //$2a$10$1YTigtgtODx3DOPoKt2qtuvK6isGfwOLHcg.MmwYb3luP4/aSd9YW
        //$2a$10$dQD5XhaVPY2RZCVrRXr2lectw3wF9st/QSaT.Wpnt8CW9cfQewxgS
        System.out.print(pwd);
    }
}
