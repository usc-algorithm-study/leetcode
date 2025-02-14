class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for(int i=0; i<magazine.length(); i++){
            count[magazine.charAt(i)-'a'] += 1;
        }
        for(int i=0; i<ransomNote.length(); i++){
            if(count[ransomNote.charAt(i)-'a'] < 1) return false;
            count[ransomNote.charAt(i)-'a'] -= 1;
        }
        return true;
    }
}