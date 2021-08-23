package com.atreya._100_practice;

public class LogicalOperation {
    static class ReturnSomething{
        public ReturnSomething getNull(){
            return null;
        }
        public ReturnSomething getData(){
            return new ReturnSomething();
        }

    }
    public static void main(String[] args) {
        ReturnSomething something = new ReturnSomething();
    }
}
