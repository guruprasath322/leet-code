class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] v=new boolean[m][n];
        int r=0;
        int c=0;
        v[r][c]=true;
        while(true){
            char direction=grid[r][c];
            int nextR=r;
            int nextC=c;
            if(direction=='L'){
                nextC--;
                
            }
            else if(direction=='R'){
                nextC++;
            }
            else if(direction=='U'){
                nextR--;
            }
            else if(direction=='D'){
                nextR++;
            }
            if(nextR<0 || nextR>=m || nextC<0 || nextC>=n || v[nextR][nextC]){
                return new int[]{r,c};
            }
            r=nextR;
            c=nextC;
            v[r][c]=true;
            
        }
    }
}