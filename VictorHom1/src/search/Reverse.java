package search;

public class Reverse {

	public static void main(String[] args) {
		System.out.println(reverse("abcdefg"));
	}
	
	public static String reverse(String s) {
		if(s.length() == 1) {
			return s;
		}else {
			return s.substring(s.length() - 1, s.length()) + reverse(s.substring(0, s.length() - 1));
		}
	}

}
