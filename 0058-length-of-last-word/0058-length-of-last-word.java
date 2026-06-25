class Solution {
    public int lengthOfLastWord(String s) {
        s = s.stripTrailing();
        int n = s.length();
        int lst =s.lastIndexOf(' ');
        String s1 = s.substring(lst+1,n);
        return s1.length();
    }
}