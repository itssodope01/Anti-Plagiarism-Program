import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckTwoFiles {

    //Threshold
    private static final double T = 2.0;
    private Hamming hamming = new Hamming();

    public void compareFiles(String filePath1, String filePath2) {
        try {
            String[] lines1 = readLines(filePath1);
            String[] lines2 = readLines(filePath2);

            int identicalLines = 0;
            double totalHammingDistance = 0;

            for (String line1 : lines1) {
                double minHammingDistance = Double.MAX_VALUE;
                for (String line2 : lines2) {
                    try {
                        //hamming
                        int hammingDistance = hamming.compare(line1, line2);
                        minHammingDistance = Math.min(minHammingDistance, hammingDistance);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error comparing lines: " + e.getMessage());
                    }
                }

                if (minHammingDistance == 0) {
                    identicalLines++;
                }
                totalHammingDistance += minHammingDistance;
            }
            double averageHammingDistance = totalHammingDistance / lines1.length;
            System.out.println("Average Hamming Distance: " + averageHammingDistance);
            System.out.println("Identical Lines: " + identicalLines);
            if (averageHammingDistance < T) {
                System.out.println("Plagiarism detected!");
            } else {
                System.out.println("No plagiarism detected.");
            }
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
    private String[] readLines(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().toArray(String[]::new);
        }
    }
    public static void main(String[] args) {
        CheckTwoFiles plagiarismChecker = new CheckTwoFiles();
        plagiarismChecker.compareFiles("compare/code1.java", "compare/code2.java");
    }
}
