package cn.lg.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.lg.hash.povo.User;

public class HashMapFun {
    public static void main(String[] args) throws InterruptedException {
//        threadSafeSWhenUseIterator();
        hongheiTreeOnJdk8();
    }


    /**
     * 横向大于64
     * 纵向大于8
     *
     * 开始横向8 纵向0 纵向到达8（内部定义），扩容、然后rehash
     * 当纵向大于8  很想大于64 编程红黑树
     *
     * 最极限的状态：重写hash
     * 8   16
     * 9   32
     * 10  64
     * 11  变红黑树
     */
    public static  void hongheiTreeOnJdk8(){
        HashMap<User, String> hongHei = new HashMap<>();
        for (int i = 0; i < 15; i++) {
            User user = new User();
            hongHei.put(user, "11");
            
        }

        // ConcurrentHashMap<User, String> cMap = new ConcurrentHashMap<>();

    }

    //使用迭代器变量hashmap的时候，是线程安全的
    //触发ConcurrentModificationException  Fail-Fast机制
    //原理： 当进入迭代器的时候会 记录这个map的 modCount 每次取值的时候会比较这个值是否发生变化
    public static void  threadSafeSWhenUseIterator(){
        HashMap<String, String> iteratorHashMap = new HashMap<>();
        iteratorHashMap.put("1", "11");
        iteratorHashMap.put("2", "11");
        iteratorHashMap.put("3", "11");
        iteratorHashMap.put("11", "11");

        Iterator<Map.Entry<String, String>> mapIterator = iteratorHashMap.entrySet().iterator();
        boolean flag = true;
        if (flag) {
            System.out.println("flag=" + flag);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    iteratorHashMap.put("11", "13");
                    iteratorHashMap.put("21", "13");
                    iteratorHashMap.put("31", "11");
                    iteratorHashMap.put("13", "11");

                }
            }).start();
            flag = false;
        }

        while (mapIterator.hasNext()) {
            Map.Entry<String, String> next = mapIterator.next();
            System.out.println(next);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
