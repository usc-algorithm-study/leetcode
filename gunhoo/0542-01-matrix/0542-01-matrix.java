class Solution {
    private int[][] dir = {{1,0}, {-1,0}, {0,1},{0,-1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0) q.offer(new int[]{i, j});
                else mat[i][j] = -1;
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            for(int i=0; i<4; i++){
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if(0<=nx && nx<m && 0<=ny && ny<n && mat[nx][ny] == -1){
                    mat[nx][ny] = mat[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return mat;
    }
}