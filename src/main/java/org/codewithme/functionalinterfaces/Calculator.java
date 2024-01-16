package org.codewithme.functionalinterfaces;

public class Calculator {
    // Lambda expressions for basic binary operations
    private final MathOperation addition = (a, b) -> a + b;
    private final MathOperation subtraction = (a, b) -> a - b;
    private final MathOperation multiplication = (a, b) -> a * b;
    private final MathOperation division = (a, b) -> (b != 0) ? a / b : Double.NaN;

    // Perform a calculation based on the selected operation
    public double calculate(double operand1, double operand2, MathOperation operation) {
        return operation.operate(operand1, operand2);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double num1 = 10.0;
        double num2 = 5.0;

        // Perform addition
        double resultAdd = calculator.calculate(num1, num2, calculator.addition);
        System.out.println("Addition: " + resultAdd);

        // Perform subtraction
        double resultSub = calculator.calculate(num1, num2, calculator.subtraction);
        System.out.println("Subtraction: " + resultSub);

        // Perform multiplication
        double resultMul = calculator.calculate(num1, num2, calculator.multiplication);
        System.out.println("Multiplication: " + resultMul);

        // Perform division
        double resultDiv = calculator.calculate(num1, num2, calculator.division);
        System.out.println("Division: " + resultDiv);
    }
}
