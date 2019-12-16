package com.tt.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request, String key) {
        try {
            //将请求的参数信息转换为整数
            return Integer.decode(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request, String key) {
        try {
            //将请求的参数信息转换为整数
            return Long.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static double getDouble(HttpServletRequest request, String key) {
        try {
            //将请求的参数信息转换为整数
            return Double.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1d;
        }
    }

    public static boolean getBoolean(HttpServletRequest request, String key) {
        try {
            //将请求的参数信息转换为整数
            return Boolean.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String getString(HttpServletRequest request, String key) {
        try {
            //将请求的参数信息转换为整数
            String result = request.getParameter(key);
            if (result != null) {
                result = result.trim();
            }
            if ("".equals(result)) {
                result = null;
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
