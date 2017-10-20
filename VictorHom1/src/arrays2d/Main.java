package arrays2d;

public class Main {

	public void changeNeighbors(int[] arr, int x) {
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
