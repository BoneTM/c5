package com.bone.c5;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Bone
 * @Package com.bone.c5
 * @date 2020/7/5 17:46
 */
public class Test {
    public static void main(String[] args){
        System.out.println(new BCryptPasswordEncoder().encode("12345678"));
    }
}
