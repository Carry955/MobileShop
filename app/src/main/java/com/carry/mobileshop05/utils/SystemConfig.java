package com.carry.mobileshop05.utils;

public class SystemConfig {
    private static final String IS_LOGIN_KEY = "is_login";
    private static final String LOGIN_USER_NAME_KEY = "login_user_name";
    private static final String LOGIN_USER_HEAD_KEY = "login_user_head";
    private static final String LOGIN_USER_EMAIL_KEY = "login_user_email";

    public  static boolean isLogin(){
        return SpTools.getBoolean(IS_LOGIN_KEY,false);
    }
    public static void setLogin(boolean islogin){
        SpTools.putBoolean(IS_LOGIN_KEY,islogin);
    }
    public static String getLoginUsername(){
        return SpTools.getString(LOGIN_USER_NAME_KEY, "");
    }
    public static void setLoginUserName(String userName){
        SpTools.putString(LOGIN_USER_NAME_KEY, userName);
    }
    public static String getLoginUserHead(){
        return SpTools.getString(LOGIN_USER_HEAD_KEY, "");
    }
    public static void setLoginUserHead(String userHead){
        SpTools.putString(LOGIN_USER_HEAD_KEY, userHead);
    }
    public static String getLoginUserEmail(){
        return SpTools.getString(LOGIN_USER_EMAIL_KEY, "");
    }
    public static void setLoginUserEmail(String userEmail){
        SpTools.putString(LOGIN_USER_EMAIL_KEY, userEmail);
    }
    public static void logout(){
        setLogin(false);
        setLoginUserName("");
        setLoginUserHead("");
        setLoginUserEmail("");
    }
}
