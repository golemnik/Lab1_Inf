import java.util.Scanner;

public class Lab1 {
	static final String NUMS = "0123456789ABCDEF";	

	static int factorial (int n) {
		int result = 1;
		for (int i = 1; i <=n; i++)  {
			result = result * i;
		}
		return result;
	}
	static int fibonachi (int n) {
		if (n < 2) return 1;
		int row[] = new int [n+1];
		row[0] = 1;
		row[1] = 1;
		for (int i = 2; i < n+1; i++) {
			row[i] = row[i-1] + row[i-2];
		}
		return row[n];
	}
	
	static boolean checkFormat (String number) {
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) == 'b') return true;
		}
		return false;
	}

	//every number support get base and number. Check number for standart.

	static int getBase (String number) {
		int baseDigits = 0;
		for (int i = number.length()-1; i >= 0; i--) {
			if (number.charAt(i) == 'b') break;
			else baseDigits += 1;
		}
		int result = 0;
		for (int i = 0; i < baseDigits; i++) {
			result += (Character.getNumericValue(number.charAt(number.length() - 1-i)) * Math.pow (10, i));
		}
		return result;
	}

	static String getDigit (String number) {
		int digits = 0;
		for (int i = 0; i < number.length(); i++) {
			if (number.charAt(i) == 'b') break;
			else digits += 1;
		}
		String result = "";
		for (int i = 0; i < digits; i++) {
			result += number.charAt(i);			
		}
		return result;
	}

	// convertert bToDec and decToB
	
	static String decToB (String number, int base) {
		if ((checkFormat(number) == false) && getBase(number) == 10) {
			System.out.println("Wrong num format.");
			return "NULL";
		}
		String result = "";
		int temp_number = 0;
		for (int i = 0; i < getDigit(number).length(); i++) {
			temp_number += Character.getNumericValue(number.charAt(i))*Math.pow(10, getDigit(number).length() -1-i);
		}
		while (temp_number >= base) {
			result = NUMS.charAt(temp_number%base) + result;
			temp_number = temp_number / base;
			if (temp_number < base) result = temp_number + result;		
		}		
		result += "b" + base;		
		return result;
	}

	static String bToDec (String number) {
		if ((checkFormat(number) == false)) {
			System.out.println("Wrong num format.");
			return "NULL";
		}
		int result = 0;
		for (int i = 0; i < getDigit(number).length(); i++) {
			result += Character.getNumericValue(number.charAt(i))*Math.pow(getBase(number), getDigit(number).length() -1-i);
		}
		return String.valueOf(result);
	}

	static String bToB (String number, int base) {
		String result = "";
		result = decToB(bToDec(number), base);
		return result;
	}

	static String inputNum() {
		System.out.println("Enter number: ");
		Scanner in = new Scanner(System.in);
		String number = in.next();
		System.out.println("Enter number base: ");
		number += 'b';
		number = in.next();
		return number;
	}
	
	static void outputNum(String number) {
		System.out.print(number);
	}
	

	public static void main (String args[]) {
		//System.out.println(getDigit("8b10"));
		//System.out.println(decToB("31b10", 2));
		System.out.println(bToDec("1111b2"));
		System.out.println(bToB("1111b2", 4));
	}
}