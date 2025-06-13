package com.alivinfer.utils;

/**
 * @author Fer
 * @version 1.0
 * @description 利用 ThreadLocal 获取当前登录用户的 id
 * @date 2025/5/27
 */

public class CurrentHolder {

    private static final ThreadLocal<Integer> CURRENT_USER_ID = new ThreadLocal<>();

    private static final ThreadLocal<String> CURRENT_USERNAME = new ThreadLocal<>();

    public static void setCurrentUserInfo(Integer employeeId, String username) {
        CURRENT_USER_ID.set(employeeId);
        CURRENT_USERNAME.set(username);
    }

    public static Integer getCurrentUserId() {
        return CURRENT_USER_ID.get();
    }

    public static String getUsername() {
        return CURRENT_USERNAME.get();
    }

    public static void remove() {
        CURRENT_USER_ID.remove();
        CURRENT_USERNAME.remove();
    }
}
