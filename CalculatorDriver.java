package calculator;

public class CalculatorDriver {
	public static void main(String[] arguments) 
    {
		System.out.println("Input format: \nNumber -> operator -> ( additional number if neccessary ) -> = " );
		System.out.println("Clear (AC) before a new operation");
        Calculator calc = new Calculator();
    }
}
