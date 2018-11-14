package com.yehao_test;


    class Annoyance extends Exception {
        private static final long serialVersionUID = 1L;

        public String getName() {
            return "yehao";
        }
        
    }
    class Sneeze extends Annoyance {
        private static final long serialVersionUID = 1L;
        private String name;
        public void setName (String name) {
            this.name = name;
        }
       /* public String getName() {
            return "child method getName...";
        }*/
        
    }

public  class TestException {

        public static void main(String[] args) 
            throws Exception {
            try {
                try {
                    String string = new Sneeze().getName();
                    System.out.println("任何子类的对象都可以当做父类使用："+string);
                    /**
                     * 子类实现父类方法，子类调用该类方法，子类没有实现父类方法，
                     * 则子类调用父类方法。--通常情况下，父类能处理的子类一定能处理
                     */
                    throw new Sneeze();
                } 
                catch ( Annoyance a ) {
                    System.out.println("Caught Annoyance");
                    throw a;
                }
            }catch ( Sneeze s ) {
                System.out.println("Caught Sneeze");
                return ;
            }
            finally {
                System.out.println("Hello World!");
            }
        }
    }
