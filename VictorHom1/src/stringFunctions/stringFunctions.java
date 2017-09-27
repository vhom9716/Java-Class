package stringFunctions;

public class stringFunctions {

	public static boolean keywordIsIsolated(int pos, String keyword, String s) {
		String a = "a";
		if(keyword.length() == s.length()) {
			return true;
		}
		try {
			if(a.compareTo(s.substring(pos - 1)) < 0 && a.compareTo(s.substring(pos + keyword.length() - 1, pos + keyword.length())) < 0) {
				return true;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			if(pos == 0 && a.compareTo(s.substring(pos + keyword.length() - 1, pos + keyword.length())) < 0) {
				return true;
			}
			if(keyword.length() == pos + keyword.length() - 1 && a.compareTo(s.substring(pos - 1)) < 0) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean noNegations(String s, int pos) {
		return true;
	}
}
