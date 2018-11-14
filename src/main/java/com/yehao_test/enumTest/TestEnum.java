package com.yehao_test.enumTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.springmvc.model.User;

public class TestEnum {
    
    public enum Util{
        STUDENT("1210315209","tiantian","hubeigongyedaxue"),
        TEACHER("2110315223","huxing","huazhongkejidaxue"),
        CHILD("342451451","huahua","zheshiyeaihuf");
        
        private Util(String id, String desc, String name) {
            this.id = id;
            this.desc = desc;
        }
        
       
        private String id;
        private String desc;
        
        public String toString(){
            return this.id+this.desc;
        }
      
       
        public String getDesc() {
            return desc;
        }
        public void setDesc(String desc) {
            this.desc = desc;
        }
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        
    }
    
    public static void sort(List<User> users){
        Collections.sort(users, new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {
                if(o1.getUsername().compareTo(o2.getUsername())>0){
                    return 1;
                }
                else if(o1.getUsername().compareTo(o2.getUsername())==0){
                    return 0;
                }else {
                    return -1;
                }
                
            }
            
        });
    }

    public static void main(String[] args) {
        Util utils[] =  Util.values();
        for (int i = 0; i < utils.length; i++) {
            System.out.println(utils[i].toString()+utils[i].name());
            
        }
        List<User> users = new ArrayList<User>();
        
        users.add(new User("zhangsan"));
        users.add(new User("wanger"));
        users.add(new User("lisi"));
        users.add(new User("zhaoqi"));
        users.add(new User("yangba"));
        users.add(new User("shushan"));
        System.out.println(users.toString());
        TestEnum.sort(users);
        System.out.println(users);
        
    }

}
