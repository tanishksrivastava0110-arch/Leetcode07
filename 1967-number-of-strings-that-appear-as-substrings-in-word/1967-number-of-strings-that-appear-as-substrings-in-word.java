class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String p : patterns) {
            if (isSubstring(p, word)) {
                count++;
            }
        }

        return count;
    }
    public boolean isSubstring(String p, String word) {
        for (int i = 0; i <= word.length() - p.length(); i++) {
            int j=0;

            for (j = 0; j < p.length(); j++) {
                if (word.charAt(i + j) != p.charAt(j)) {
                    break;
                }
            }

            if (j == p.length()) {
                return true;
            }
        }
        return false;
    }
}