class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Number> pq = new PriorityQueue<>((a,b)->{
            return b.count - a.count;
        });
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Number(entry.getKey(), entry.getValue()));
        }
        for(int i=0; i<k; i++){
            answer[i] = pq.poll().num;
        }
        return answer;
    }

    class Number {
        int num, count;
        public Number(int n, int c){
            this.num= n;
            this.count = c;
        }
    }
}