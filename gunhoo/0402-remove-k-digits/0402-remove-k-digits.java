class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int len = num.length();
        if(len == k) return "0";
        for(char c : num.toCharArray()){
            while(!stack.isEmpty() && k > 0 && stack.peek() > c){
                stack.pop();
                k--;
            }
            stack.add(c);
        }
        for(int i=0; i<k; i++) stack.pop();

        StringBuilder sb = new StringBuilder();
        Boolean leading = true;
        for(char c : stack){
            if(leading && c == '0'){
                continue;
            }
            leading = false;
            sb.append(c);
        }
        return leading ? "0" : sb.toString();
    }
}