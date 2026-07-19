class Solution {
    public String removeDuplicateLetters(String s) {

        if (s.length() == 0)
            return "";

        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int pos = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;

            freq[s.charAt(i) - 'a']--;

            if (freq[s.charAt(i) - 'a'] == 0)
                break;
        }

        char first = s.charAt(pos);

        String remaining = s.substring(pos + 1).replaceAll("" + first, "");

        return first + removeDuplicateLetters(remaining);
    }
}