
# Java: The Optional Class

The `Optional` class in Java is a container object used to contain not-null objects. Optional object is used to represent null with absent value. It was introduced in Java 8 and is a public final class. It's used to avoid `NullPointerException` that can be thrown when an object is null.

## Overview

- Introduced in Java 8.
- Provides a way to express an optional value (a value that might be present or absent).
- Helps in writing clean code by avoiding explicit null checks.

## Syntax

Creating an Optional object:

```java
Optional<String> optional = Optional.of("value");
```

Creating an empty Optional:

```java
Optional<String> optionalEmpty = Optional.empty();
```

Creating an Optional object that may or may not contain a non-null value:

```java
Optional<String> optionalNullable = Optional.ofNullable(value);
```

## Use Cases

- Returning a value from a method where there's a chance it might be null.
- Reducing null checks and avoiding `NullPointerException`.
- Providing a more expressive and fluent API.

## Advantages

- **Code Quality**: Helps in writing more readable and clean code by handling the absence of a value gracefully.
- **Null Safe**: Prevents `NullPointerException`, a common issue in Java applications.
- **Functional Programming**: Supports functional programming patterns like monads, making it easier to handle values that might be null in a functional style.

## Methods

- `isPresent()`: Returns true if there's a value present, otherwise false.
- `ifPresent()`: If a value is present, it invokes the specified consumer with the value, otherwise does nothing.
- `orElse()`: Returns the value if present, otherwise returns a default value.
- `orElseThrow()`: Returns the contained value if present, otherwise throws an exception.

## Example

```java
Optional<String> optionalValue = Optional.ofNullable("Hello World");
optionalValue.ifPresent(System.out::println); // prints "Hello World"
```

In this example, `ifPresent` is used to print the value of `optionalValue` if it's not null.

---

In conclusion, the `Optional` class in Java is a robust tool for handling the presence or absence of a value, thus preventing unexpected `NullPointerException` and leading to cleaner, more readable code.