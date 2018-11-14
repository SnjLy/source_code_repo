package com.yehao_test;


class Outer {
    private static final String DESC = "zheshiyigenewversion";
    private int age;
    private String name;
    public int getAge() {
        return age;
    }
  
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    class Inner {}

    //public static void foo() { new Inner();}    //编译不通过
    public static void foo() { new Outer().new Inner();}    //编译通过

    public void bar() { new Inner(); new Outer().getName(); new Outer().DESC.toString(); } //内部类访问外部类的成员变量   
    //使用外部类调用非静态方法   this.bar();通过  。this.foo();编译错误    

    /*public static void main(String[] args) {    //编译不通过
        new Inner();
    }*/
    
    /**
     * Java中非静态内部类对象的创建要依赖其外部类对象，
     * 上面的面试题中foo和main方法都是静态方法，静态方法中没有this，
     * 也就是说没有所谓的外部类对象，因此无法创建内部类对象，
     *  如果要在静态方法中创建内部类对象，可以这样做：new Outer().new Inner();
    */
            
}