class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;

        if(s.equals(goal)){
            Set<Character> setS = new HashSet<>();
            for(char c : s.toCharArray()){
                setS.add(c);
            }
            if(setS.size() == goal.length()) return false;
            else return true;
        }

        
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int counts = 0; // counts the number of different characters between s and goal
        char prevS = '0';
        char prevGoal = '0';

        for(int i=0; i<n; i++){
            char a = s.charAt(i);
            char b = goal.charAt(i);

            if(a != b){
                counts += 1;
                if(counts > 2) return false;
                set.add(a); 
                set.add(b);
                if(counts == 2){
                    if(a == prevGoal && b == prevS) continue;
                    else return false;
                }
                prevS = a;
                prevGoal = b;
            } 
        }
        if(set.size() > 2 || counts < 2) return false;
        return true;
    }
}

// 1. Iterate all characters in s
//      - compare a character in s to goal
//      - count the difference and store the last(first) different characters in s
//      - compare the last different characters in s to the second index
//      - s = "abb", b = "bac" <- save difference counts : counts > 2 -> return false

// if both strings are same:
// make a set
// compare the size of both sets 
// if same : true
// else : false 