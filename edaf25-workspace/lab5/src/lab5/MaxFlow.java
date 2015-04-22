package lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaxFlow {
	private int amountOfNodes = -1;
	private int amountOfEdges = -1;
	private int[][] flowMatrix;

	public MaxFlow(String fileName) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("Couldn't open file: " + fileName);
			System.exit(1);
		}

		amountOfNodes = scanner.nextInt();
		amountOfEdges = scanner.nextInt();
		
		flowMatrix = new int[amountOfNodes][amountOfNodes];
		
		while (scanner.hasNext()) {
			flowMatrix[scanner.nextInt()][scanner.nextInt()] = scanner.nextInt();
		}

		scanner.close();
	}
}
