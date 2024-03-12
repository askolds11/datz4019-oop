package jtm.activity08;

// TODO implement basic mathematical operations with int numbers in range
// of [-10..+10] (including)
// Note that:
// 1. input range is checked using assertions (so if they are disabled, inputs can be any int)
// 2. outputs are always checked and exception is thrown if it is outside proper range

public class SimpleCalc {
	private static final int min = -10;
	private static final int max = 10;

	public static int add(int a, int b) throws SimpleCalcException {
		validateInput(a, b);
		return validateOutput(a, b, "+");
	}

	public static int subtract(int a, int b) throws SimpleCalcException {
		validateInput(a, b);
		return validateOutput(a, b, "-");
	}

	public static int multiply(int a, int b) throws SimpleCalcException {
		validateInput(a, b);
		return validateOutput(a, b, "*");
	}

	public static int divide(int a, int b) throws SimpleCalcException {
		validateInput(a, b);
		return validateOutput(a, b, "/");
	}

	// Validate that inputs are in range of -10..+10 using assertions
	// Catch assertion errors and wrap them in SimpleCalcExceptions with
	// message "Assertion error" and caught assertion error as a cause.
	private static void validateInput(int a, int b) throws SimpleCalcException {
		try {
			assert !(a < min) || !(b < min) : "input value a: " + a + " is below -10 and b: " + b + " is below -10";
			assert !(a > max) || !(b < min) : "input value a: " + a + " is above 10 and b: " + b + " is below -10";
			assert !(a < min) || !(b > max) : "input value a: " + a + " is below -10 and b: " + b + " is above 10";
			assert !(a > max) || !(b > max) : "input value a: " + a + " is above 10 and b: " + b + " is above 10";
			assert !(a < min) : "input value a: " + a + " is below -10";
			assert !(a > max) : "input value a: " + a + " is above 10";
			assert !(b < min) : "input value b: " + b + " is below -10";
			assert !(b > max): "input value b: " + b + " is above 10";
		} catch (AssertionError e) {
			throw new SimpleCalcException("Assertion error", e);
		}
	}

	// TODO use this method to check that result of operation is also in
	// range of -10..+10.
	// If result is not in range:
	// throw SimpleCalcException with message:
	// "output value a oper b = result is above 10"
	// "output value a oper b = result is below -10"
	// where oper is +, -, *, /
	// Else:
	// return result
	// Hint:
	// If division by zero is performed, catch original exception and create
	// new SimpleCalcException with message "division by zero" and add
	// original division exception as a cause for it.
	private static int validateOutput(int a, int b, String operation) throws SimpleCalcException {
		int result = 0;
		switch (operation) {
			case "+":
				result = a + b;
				break;
			case "-":
				result = a - b;
				break;
			case "*":
				result = a * b;
				break;
			case "/":
				try {
					result = a / b;
				} catch (Exception e) {
					throw new SimpleCalcException("division by zero", e);
				}
				break;
		}
		if (result > max) throw new SimpleCalcException("output value " + a + " " + operation + " " + b + " = " + result + " is above 10");
		if (result < min) throw new SimpleCalcException("output value " + a + " " + operation + " " + b + " = " + result + " is below -10");
		return result;
	}
}
