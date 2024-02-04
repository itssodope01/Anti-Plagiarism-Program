import java.io.*;
public class CheckDirectory {
    private static final double Threshold = 2.0;
    private Hamming hamming = new Hamming();
    public void InDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            System.out.println("The provided path is not a directory.");
            return;
        }
        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory.");
            return;
        }
        for (int i = 0; i < files.length - 1; i++) {
            for (int j = i + 1; j < files.length; j++) {
                compareFiles(files[i], files[j]);
            }
        }
    }
    private void compareFiles(File file1, File file2) {
        try {
            String[] lines1 = readLines(file1);
            String[] lines2 = readLines(file2);

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

            //Hamming_Distance
            double averageHammingDistance = totalHammingDistance / lines1.length;
            System.out.println("Comparison between files: " + file1.getName() + " and " + file2.getName());
            System.out.println("Average Hamming Distance: " + averageHammingDistance);
            System.out.println("Identical Lines: " + identicalLines);
            if (averageHammingDistance < Threshold) {
                System.out.println("Plagiarism detected!");
            } else {
                System.out.println("No plagiarism detected.");
            }
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
    private String[] readLines(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().toArray(String[]::new);
        }
    }
    public static void main(String[] args) {
        CheckDirectory plagiarismChecker = new CheckDirectory();
        plagiarismChecker.InDirectory("compare");
    }
}
