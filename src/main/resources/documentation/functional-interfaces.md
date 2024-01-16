# Functional Interfaces in Java

Functional interfaces in Java are interfaces that have exactly one abstract method. They play a crucial role in supporting functional programming features, such as lambdas and method references. Here's an overview of common functional interfaces in Java along with their descriptions and usage examples.

## 1. Runnable

- **Description**: Represents a task that can be run without any arguments and doesn't return a value.
- **Method**: `void run()`

**Usage Example:**
```java
Runnable task = () -> {
    // Code to run
    System.out.println("Task is running...");
};
```

## 2. Supplier\<T\>

- **Description**: Represents a supplier of results and has a single `get()` method that takes no arguments and returns a result of type `T`.
- **Method**: `T get()`

**Usage Example:**
```java
Supplier<String> messageSupplier = () -> "Hello, World!";
String message = messageSupplier.get();
System.out.println(message);
```

## 3. Consumer\<T\>

- **Description**: Represents an operation that takes a single input argument of type `T` and returns no result.
- **Method**: `void accept(T t)`

**Usage Example:**
```java
Consumer<Integer> printNumber = (num) -> System.out.println("Number: " + num);
printNumber.accept(42);
```

## 4. Function\<T, R\>

- **Description**: Represents a function that takes an argument of type `T` and returns a result of type `R`.
- **Method**: `R apply(T t)`

**Usage Example:**
```java
Function<Integer, Integer> square = (x) -> x * x;
int result = square.apply(5); // result will be 25
```

## 5. Predicate\<T\>

- **Description**: Represents a predicate (boolean-valued function) of one argument.
- **Method**: `boolean test(T t)`

**Usage Example:**
```java
Predicate<String> isUpperCase = (str) -> str.equals(str.toUpperCase());
boolean result = isUpperCase.test("HELLO"); // result will be true
```

## 6. BiFunction\<T, U, R\>

- **Description**: Represents a function that takes two arguments of types `T` and `U`, and returns a result of type `R`.
- **Method**: `R apply(T t, U u)`

**Usage Example:**
```java
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
int sum = add.apply(3, 5); // sum will be 8
```

These functional interfaces simplify the use of lambdas and method references, making your code more concise and expressive.