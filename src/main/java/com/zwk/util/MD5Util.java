package com.zwk.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author: zwk
 * @time: 2018/10/15
 * 描述
 */
public class MD5Util {
    /**
     *生成加密后的密码
     * @param source  明码明文
     * @param salt   盐
     * @param hashIterations  散列次数
     * @return
     */
    public static String encodePasswordUserMd5(Object source,
                                               Object salt,
                                               int hashIterations){
        return new Md5Hash(source,salt,hashIterations).toString();
    }
}
