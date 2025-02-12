class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> answer = new ArrayList<>();

        Map<String, List<Integer>> emailToAccount = new HashMap<String, List<Integer>>();
        for(int i=0; i<accounts.size(); i++){
            List<String> account = accounts.get(i);
            for(int j=1; j<account.size(); j++){
                if(emailToAccount.get(account.get(j)) == null){
                    emailToAccount.put(account.get(j), new ArrayList<Integer>());
                }
                emailToAccount.get(account.get(j)).add(i);
            }
        }

        UnionFind uf = new UnionFind(accounts.size());
        for(Map.Entry<String, List<Integer>> entry : emailToAccount.entrySet()){
            List<Integer> accountIndexList = entry.getValue();
            int baseIndex = accountIndexList.get(0);
            for(int i=1; i<accountIndexList.size(); i++){
                uf.union(baseIndex, accountIndexList.get(i));
            }
        }
        List<Integer> mergeList[] = new List[accounts.size()];
        for(int i=0; i<accounts.size(); i++){
            int root = uf.find(i);
            if(mergeList[root] == null) mergeList[root] = new ArrayList<>();
            mergeList[root].add(i);
        }

        for(int i=0; i<accounts.size(); i++){
            if(mergeList[i] != null){
                String name = accounts.get(i).get(0);
                Set<String> emails = new HashSet<String>();

                for(int j=0; j<mergeList[i].size(); j++){
                    List<String> account = accounts.get(mergeList[i].get(j));
                    emails.addAll(account.subList(1, account.size()));
                }
                List<String> account = new ArrayList<String>(emails);
                Collections.sort(account);
                account.add(0, name);
                answer.add(account);
            }
        }
        return answer;
    }

}

class UnionFind{
    int[] parent, height;

    public UnionFind(int size){
        parent = new int[size];
        height = new int[size];
        for(int i=0; i<size; i++){
            parent[i] = i;
            height[i] = 1;
        }
    }

    public int find(int i){
        return parent[i] == i ? parent[i] : find(parent[i]);
    }

    public void union(int i, int j){
        int a = find(i), b = find(j);
        if(height[a] < height[b]){
            parent[a] = b;
        } else if(height[a] > height[b]){
            parent[b] = a;
        } else {
            parent[a] = b;
            height[b] += 1;
        }
    }
}
// minhojan@usc.edu