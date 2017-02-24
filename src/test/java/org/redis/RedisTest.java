package org.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/2/24.
 */
public class RedisTest {
    @Test
    public void test(){
        Jedis jedis = new Jedis("139.199.174.189");
        jedis.auth("zdfcc123");
        System.out.println("Connection to server sucessfully");
        // 查看服务是否运行
        System.out.println("Server is running: " + jedis.ping());
    }
}
