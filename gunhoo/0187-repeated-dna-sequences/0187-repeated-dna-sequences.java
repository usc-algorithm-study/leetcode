class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int L = 10, n = s.length();
        Set<String> seen = new HashSet<>(), output = new HashSet<>();
        for(int i=0; i<n-L+1; i++){
            String window = s.substring(i, i+L);
            if(seen.contains(window)) output.add(window);
            else seen.add(window);
        }
        return new ArrayList<String>(output);
    }
}