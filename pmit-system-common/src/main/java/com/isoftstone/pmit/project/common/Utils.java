package com.isoftstone.pmit.project.common;


public class Utils {

    /**
     * 校验value值是不是数字
     *
     * @param value
     * @return
     */
    public static boolean isNumber(Object value) {
        try {
            Float.valueOf(value.toString());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
