package arrays2d;

public class Main {

	//this is another major topic in AP CSA 
	//avoiding an ArrayIndexOutOfBoundException
	public static void changeNeighbors(int[] arr, int x) {
		if(arr.length > x) {
			arr[x]++;
			if(arr.length > x + 1) {
				arr[x + 1]--;
			}
			if(x > 0) {
				arr[x - 1]--;
			}
		}
	}
}
