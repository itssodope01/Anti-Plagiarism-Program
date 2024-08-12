public class Hamming {
    
    public int compare(String str1, String str2) throws IllegalArgumentException {
        if (str1.isEmpty() || str2.isEmpty()) {
            throw new IllegalArgumentException("Strings cannot be empty");
        }

        int hammingDistance = 0;
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                hammingDistance++;
            }
        }
        hammingDistance += Math.abs(str1.length() - str2.length());
        return hammingDistance;
    }
    public static void main(String[] args) {
        try {
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
