package org.loversAPP.utils;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/2/16.
 */
public class MD5Utils {
    public static final String CHARSET = "UTF-8";
    public static String getMd5(String ll_id){
        String slat="&*yuwiyuw%%%3i4shefshejkefh?lsjkkshkshjsehfjdtjsafsjwjsdsffdg";
        String base=ll_id+"/"+slat;
        String md5= DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
    public static String sign(String prestr)
    {
        StringBuffer buffer = new StringBuffer(32);
        try
        {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] t = md5.digest(prestr.getBytes(CHARSET));
            for(int i = 0; i < t.length; i++)
            {
                buffer.append(Byte.toString(t[i]));
            }
            return buffer.toString();
        }
        catch(NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch(UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return prestr;
    }
}
