class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] kClosestPoints = new int[k][2];
        List<Point> list = new ArrayList<>();

        for(int i=0; i<points.length; i++){
            list.add(new Point(points[i][0], points[i][1], (int)Math.pow(points[i][0],2)+(int)Math.pow(points[i][1],2)));
        }
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2){
                return p1.distance - p2.distance;
            }
        });
        for(int i=0; i<k; i++){
            Point p = list.get(i);
            kClosestPoints[i][0] = p.x;
            kClosestPoints[i][1] = p.y; 
        }
        return kClosestPoints;
    }

    class Point{
        int x, y, distance;
        public Point(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}