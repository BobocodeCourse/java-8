package com.bobocode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * FunctionFactory is an API that allows you to store and retrieve functions by name. Functions are stored in a HashMap,
 * where the key is a function name, and the value is a Function<T,R> instance. Methods addFunction(), and getFunction()
 * are already implemented.
 * <p>
 * The task is to create different types of functions and manage them using FunctionFactory. The instruction is placed
 * to the main method.
 */
public class FunctionFactoryTask {

    static class FunctionFactory<T, R> {
        private Map<String, Function<T, R>> functionMap = new HashMap<>();

        public void addFunction(String name, Function<T, R> function) {
            functionMap.put(name, function);
        }

        public Function<T, R> getFunction(String name) {
            if (functionMap.containsKey(name)) {
                return functionMap.get(name);
            } else {
                throw new InvalidFunctionNameException(name);
            }
        }
    }

    static class InvalidFunctionNameException extends RuntimeException {
        public InvalidFunctionNameException(String functionName) {
            super("Function " + functionName + " doesn't exist.");
        }
    }

    /**
     * Follow the instructions to finish the task
     */
    public static void main(String[] args) {
        FunctionFactory<Integer, Integer> functionFactory = new FunctionFactory<>();
        // 1. add simple functions "square", "increment", "decrement", "negative"
        // 2. get each function by name, and apply to argument 5, print a result (should be 25, 6, 4,-5 accordingly)
        // 3. add simple function "abs" using method reference (use class Math)
        // 4. add try/catch block, catch InvalidFunctionNameException and print some error message to the console
        // 5. try to get function with invalid name

        functionFactory.addFunction("square", n -> n * n);
        functionFactory.addFunction("abs", Math::abs);

        functionFactory.getFunction("square").apply(5);
        try{
            functionFactory.getFunction("abs").apply(5);
        }catch (InvalidFunctionNameException e){
            System.out.println(e.getMessage());
        }




    }

}


