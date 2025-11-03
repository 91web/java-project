package project1;

public class Operations {

        // Addition
        public static double add(double... numbers) {
            if (numbers == null || numbers.length == 0) {
                throw new IllegalArgumentException("Input cannot be null or empty.");
            }
            double sum = 0;
            for (double num : numbers) {
                sum += num;
            }
            return sum;
        }

        // Subtraction
        public static double subtract(double num1, double num2) {
            return num1 - num2;
        }

        // Multiplication
        public static double multiply(double... numbers) {
            if (numbers == null || numbers.length == 0) {
                throw new IllegalArgumentException("Input cannot be null or empty.");
            }
            double product = 1;
            for (double num : numbers) {
                product *= num;
            }
            return product;
        }

        // Division
        public static double divide(double num1, double num2) {
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            return num1 / num2;
        }

        // Square
        public static double square(double num) {
            return num * num;
        }

        // Square Root
        public static double squareRoot(double num) {
            if (num < 0) {
                throw new IllegalArgumentException("Square root of a negative number is not allowed.");
            }
            return Math.sqrt(num);
        }
    }
