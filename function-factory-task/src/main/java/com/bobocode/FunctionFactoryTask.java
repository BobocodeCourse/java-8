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
        Function<Integer, Integer> fSquare = f -> f * f;
        functionFactory.addFunction("square", fSquare);
        functionFactory.addFunction("increment", f -> f + 1);
        functionFactory.addFunction("increment2", f-> { f++; int i = f; return  i;});
        functionFactory.addFunction("decrement", f -> f - 1);
        functionFactory.addFunction("negative", f -> f > 0 ? -f : f);

        // 2. get each function by name, and apply to argument 5, print a result (should be 25, 6, 4,-5 accordingly)
        functionFactory.functionMap.forEach((key, value) -> System.out.println(key + ": " + value.apply(5)));

        // 3. add simple function "abs" using method reference (use class Math)
        functionFactory.addFunction("abs", Math::abs);

        // 4. add try/catch block, catch InvalidFunctionNameException and print some error message to the console
        try {
            functionFactory.getFunction("square");
        } catch (InvalidFunctionNameException e) {
            System.out.println(e.getMessage());
        }

        // 5. try to get function with invalid name
        try {
            functionFactory.getFunction("123");
        } catch (InvalidFunctionNameException e) {
            System.out.println(e.getMessage());
        }
    }

}


