package org.loversAPP.utils;

import org.springframework.util.DigestUtils;

/**
 * Created by Administrator on 2017/2/16.
 */
public class MD5Utils {
    public static String getMd5(String ll_id){
        String slat="&*yuwiyuw%%%3i4shefshejkefh?lsjkkshkshjsehfjdtjsafsjwjsdsffdg";
        String base=ll_id+"/"+slat;
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
