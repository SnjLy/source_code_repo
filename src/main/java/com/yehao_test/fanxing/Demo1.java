package com.yehao_test.fanxing;


public class Demo1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Point<Integer,Integer> p1 = new Point<Integer, Integer>();
        p1.setX(125);
        p1.setY(102);
        System.out.println(p1);
        Point<Double,Double> p2 = new Point<Double,Double>();
        p2.setX(12.5624);
        p2.setY(157.45);
        System.out.println(p2);
        Point<String, String> p3 = new Point<String ,String>();
        p3.setX(p1.getX()+p2.getX()+"");
        p3.setY(p1.getY()+p2.getY()+"");
        System.out.println(p3);
        System.out.println(1<<30);//1<<4 =16   
        
//        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
//        hashMap.put("point1", p1);
//        hashMap.put("point2", p2);
//        hashMap.put("point2", p3);
//        hashMap.size();
//        hashMap.put("point3", p3);
//        System.out.println(hashMap.get("point2"));
        System.out.println(28&15);
        
    }

}

class Point<T1,T2>{
    T1 x;
    T2 y;
    public T1 getX() {
        return x;
    }
    public void setX(T1 x) {
        this.x = x;
    }
    public T2 getY() {
        return y;
    }
    public void setY(T2 y) {
        this.y = y;
    }
    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
    
}
