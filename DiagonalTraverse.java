public class DiagonalTraverse {
  int index=0;
    public int[] findDiagonalOrder(int[][] mat) {
        boolean[][] isVisited=new boolean[mat.length][mat[0].length];
        int[] diagonalTraverse=new int[mat.length*mat[0].length];
        helper(0,0,mat,isVisited,true,diagonalTraverse);
        return diagonalTraverse;
    }
    private void helper(int i,int j,int[][] mat,boolean[][] isVisited,boolean upDir,int[] dt){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length ||
        isVisited[i][j]) return ;
        isVisited[i][j]=true;
        dt[index++]=mat[i][j];
        //same direction
        if(upDir) helper(i-1,j+1,mat,isVisited,upDir,dt);
        else helper(i+1,j-1,mat,isVisited,upDir,dt);
        //direction change
        if(i==0 || i==mat.length-1){
            helper(i,j+1,mat,isVisited,!upDir,dt);
            helper(i+1,j,mat,isVisited,!upDir,dt);
        }
        else {
            helper(i+1,j,mat,isVisited,!upDir,dt);
            helper(i,j+1,mat,isVisited,!upDir,dt);
        }
    }
}
