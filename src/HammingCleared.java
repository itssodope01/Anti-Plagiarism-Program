public class HammingCleared extends Hamming {

    //clearing the string from whitespaces, tabulators, and underlines
    private String clear(String str) {
        return str.replaceAll("[\\s_]+", "");
    }

    @Override
    public int compare(String str1, String str2) throws IllegalArgumentException {
        String clearedStr1 = clear(str1);
        String clearedStr2 = clear(str2);
        return super.compare(clearedStr1, clearedStr2);
    }

    public static void main(String[] args) {
        try {
            //Test case 1
            String str1 = "medication";
            String str2 = "meditation  ";
            HammingCleared hammingCleared1 = new HammingCleared();
            int distance1 = hammingCleared1.compare(str1, str2);
            System.out.println("Cleared Hamming Distance between '" + str1 + "' and '" + str2 + "': " + distance1);

            //Test case 2
            String str3 = "speed ";
            String str4 = " speeding";
            HammingCleared hammingCleared2 = new HammingCleared();
            int distance2 = hammingCleared2.compare(str3, str4);
            System.out.println("Cleared Hamming Distance between '" + str3 + "' and '" + str4 + "': " + distance2);

            //Test case 3
            String str5 = "";
            String str6 = "Query";
            HammingCleared hammingCleared3 = new HammingCleared();
            int distance3 = hammingCleared3.compare(str5, str6);
            System.out.println("Cleared Hamming Distance between '" + str5 + "' and '" + str6 + "': " + distance3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
