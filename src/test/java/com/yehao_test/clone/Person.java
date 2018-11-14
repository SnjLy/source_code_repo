package com.yehao_test.clone;

import java.io.Serializable;

 class Person implements Serializable{
        private static final long serialVersionUID = 1L;
        
        private String name;    // 姓名
        private int age;        // 年龄
        private Car car;        // 座驾
        public Person(String name, int age, Car car) {
            this.name = name;
            this.age = age;
            this.car = car;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public Car getCar() {
            return car;
        }
        public void setCar(Car car) {
            this.car = car;
        }
        
        public String toString() {
            return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
        }
 }


     class Car implements Serializable{
        public Car(String brand, int maxSpeed) {
            super();
            this.brand = brand;
            this.maxSpeed = maxSpeed;
        }
        private static final long serialVersionUID = 1L;
        
        public String getBrand() {
            return brand;
        }
        public void setBrand(String brand) {
            this.brand = brand;
        }
        public int getMaxSpeed() {
            return maxSpeed;
        }
        public void setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
        }
        private String brand;       // 品牌
        private int maxSpeed;       // 最高时速
        
        public String toString() {
            return "Car [brand=" + brand + ", maxSpeed=" + maxSpeed + "]";
        }
        
     
    
}
