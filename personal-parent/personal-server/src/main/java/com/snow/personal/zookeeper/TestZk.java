package com.snow.personal.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.zookeeper.data.Stat;

/**
 * date: 2018-1-13 18:05
 * author: snowxuyu
 * describe:
 */
public class TestZk {
    public static void main(String[] args){
        String zKUrl = "127.0.0.1:2181";
        ZkClient zkClient = new ZkClient(zKUrl, 1000, 10000, new SerializableSerializer());
        System.out.println("zkclient创建成功");

    /*    User user = new User();
        user.setAddress("上海市");
        user.setPhone("xxxxx");
        user.setUserName("xxx");

        String path = zkClient.create("/testUserNode", user, CreateMode.PERSISTENT);

        System.out.println("create path:" + path);
*/
        Stat stat = new Stat();
        Object o = zkClient.readData("/testUserNode", stat);
        System.out.println(o.toString());
        System.out.println(stat);

    }
}
