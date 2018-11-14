package test;import com.alibaba.fastjson.JSON;import java.util.*;/** * Created by admin on 2017/5/24. */public class TestList {    public static void main(String[] args) {        List<String> list = new ArrayList<>();        list.add("1");        list.add("2");        list.add("3");        Iterator<String> it = list.iterator();        while (it.hasNext()){            String tmp = it.next();            if ("3".equals(tmp)){                it.remove();            }        }        System.out.println(JSON.toJSONString(list));        list.add("4");        list.add("5");        list.add("6");        /**         * 不要在foreach循环里进行元素的remove/add操作。remove元素请使用Iterator方式，         * 如果并发操作，需要对Iterator对象加锁。         */        for (String temp : list) {            if ("1".equals(temp)) {                //list.remove(temp);   //这里执行会出错                System.out.println(list.listIterator());            }        }        System.out.println(JSON.toJSONString(list));        /*List<String>  numbers = new ArrayList<>();        numbers.add("1");        numbers.add("2");        for (String a : numbers){            if ("2".equals(a)) {   //"1".equuals(a){ numbers.remove(a)} //则是正常执行                numbers.remove(a); // 此处会报错            }        }        System.out.println(JSON.toJSONString(numbers));*/        /**使用entrySet遍历Map类集合K，而不是keySet方式进行遍历。***/        System.out.println("------------------------------------------");        Map<String, String> hashMap = new HashMap<>();        hashMap.put("1","helloWorld");        hashMap.put("2", "Chinese");        hashMap.put("3", "English");        hashMap.put("4", "Japenies");        hashMap.put("4", "Japenies");        for (Map.Entry<String, String> s : hashMap.entrySet()){            System.out.println(s + "--"+ s.getKey() + "**" + s.getValue());        }    }}