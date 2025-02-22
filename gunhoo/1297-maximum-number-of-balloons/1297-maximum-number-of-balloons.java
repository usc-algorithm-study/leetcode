class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        int answer = 0;
        for(char c : text.toCharArray()){
            counts[c-'a']+=1;
        }
        // for(int i=0; i<26;i++) System.out.println(i+" "+counts[i]);
        while(counts[0]-1>=0 && counts[1]-1>=0 && counts[11]-2>=0 && counts[13]-1>=0 && counts[14]-2>=0){
            counts[0]-=1;
            counts[1]-=1;
            counts[11]-=2;
            counts[13]-=1;
            counts[14]-=2;
            answer++;
        }
        return answer;
    }
}