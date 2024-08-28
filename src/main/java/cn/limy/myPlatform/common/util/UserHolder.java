package cn.limy.myPlatform.common.util;


import cn.limy.myPlatform.entity.User;

/**
 * @author mijiupro
 */
public class UserHolder {
    private static final ThreadLocal<User> TOKEN_HOLDER = new ThreadLocal<>();

    public static void setInfoByToken( User user) {
        TOKEN_HOLDER.set( user);
    }

    public static User getInfoByToken() {
        return TOKEN_HOLDER.get();
    }

    public static void clear() {
        TOKEN_HOLDER.remove();
    }

}
