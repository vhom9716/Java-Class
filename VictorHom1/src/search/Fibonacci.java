package search;

public class Fibonacci {

	public static void main(String[] args) {
		int count = 20;
		for(int i = 0; i < count; i++) {
			System.out.println(fibonacci(i));
		}
		
	}
	
	public static int fibonacci(int num) {
		if(num == 0) {
			return 1;
		}else {
			if(num == 1) {
				return 1;
			}else {
				return fibonacci(num - 1) + fibonacci(num - 2);
			}
		}
	}
}
