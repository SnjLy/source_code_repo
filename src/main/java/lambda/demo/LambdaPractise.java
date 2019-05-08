package lambda.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * lambda.demo
 *
 * @author: liuyong
 * @date: 2019-05-07
 */
public class LambdaPractise {

    public static void main(String[] args) {
        listOperate();
        mapLambda();
    }

    public static void listOperate(){
        List<String> features = Arrays.asList("Lambdas", "Method", "Stream API", "Date And Time API");
        System.out.println("使用lambda表达式实现遍历输出");
        features.forEach(System.out::println);
    }

    public static void threadLambda(){
        new Thread(()-> System.out.println("使用lambda实现线程方法")).start();
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("非lambda表达式的写法");
            }
        });*/
    }


    public static void mapLambda(){
        List<Double> costTax = Arrays.asList(100d, 200d, 300d, 400d, 500d);
        costTax.stream().map((cost) -> cost + 0.12*cost).forEach(System.out::println);
    }








}
