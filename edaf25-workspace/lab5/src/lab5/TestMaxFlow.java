package lab5;

public class TestMaxFlow {

	public static void main(String[] args) {
		MaxFlow maxFlow = new MaxFlow("small.txt");
		int[][] test = maxFlow.flowMatrix;
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test.length; j++) {
				System.out.println(i + " " + j + " " + test[i][j]);
			}
		}
	}
}
