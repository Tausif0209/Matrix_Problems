public class MinimumAreasToCoverAllOnes_2 {
  public int minimumSum(int[][] grid) {
        int minArea=900;
        //case 1:- Two horizontal split
        for(int rowSplit1=1;rowSplit1<=grid.length-2;rowSplit1++){
            for(int rowSplit2=rowSplit1+1;rowSplit2<=grid.length-1;rowSplit2++){
                minArea=Math.min(minArea,minAreaFun(0,rowSplit1-1,0,grid[0].length-1,grid)
                +minAreaFun(rowSplit1,rowSplit2-1,0,grid[0].length-1,grid)
                +minAreaFun(rowSplit2,grid.length-1,0,grid[0].length-1,grid));
        }
        }
        //case 2:- Two vertical split
        for(int colSplit1=1;colSplit1<=grid[0].length-2;colSplit1++){
            for(int colSplit2=colSplit1+1;colSplit2<=grid[0].length-1;colSplit2++){
                minArea=Math.min(minArea,minAreaFun(0,grid.length-1,0,colSplit1-1,grid)
                +minAreaFun(0,grid.length-1,colSplit1,colSplit2-1,grid)
                +minAreaFun(0,grid.length-1,colSplit2,grid[0].length-1,grid));
        }
        }
        //case 3:One horizontal and one one vertical split
        for(int rowSplit=1;rowSplit<=grid.length-1;rowSplit++){
            for(int colSplit=1;colSplit<=grid[0].length-1;colSplit++){
                int sumArea1=minAreaFun(0,rowSplit-1,0,colSplit-1,grid)
                +minAreaFun(0,rowSplit-1,colSplit,grid[0].length-1,grid)
                +minAreaFun(rowSplit,grid.length-1,0,grid[0].length-1,grid);

                int sumArea2=minAreaFun(0,rowSplit-1,0,grid[0].length-1,grid)
                +minAreaFun(rowSplit,grid.length-1,0,colSplit-1,grid)
                +minAreaFun(rowSplit,grid.length-1,colSplit,grid[0].length-1,grid);

                minArea=Math.min(minArea,Math.min(sumArea1,sumArea2));
            }
        } 
        //case 4:one vertical and then one horizontal
        for(int colSplit=1;colSplit<=grid[0].length-1;colSplit++){
            for(int rowSplit=1;rowSplit<=grid.length-1;rowSplit++){
                int sumArea1=minAreaFun(0,rowSplit-1,0,colSplit-1,grid)
                +minAreaFun(rowSplit,grid.length-1,0,colSplit-1,grid)
                +minAreaFun(0,grid.length-1,colSplit,grid[0].length-1,grid);

                int sumArea2=minAreaFun(0,grid.length-1,0,colSplit,grid)
                +minAreaFun(0,rowSplit,colSplit,grid[0].length-1,grid)
                +minAreaFun(rowSplit,grid.length-1,colSplit,grid[0].length-1,grid);

                minArea=Math.min(minArea,Math.min(sumArea1,sumArea2));
            }
        }
        return minArea;
    }
    private int minAreaFun(int rowStart,int rowEnd,int colStart,int colEnd,int[][] grid){
        int minRow=30,maxRow=-1,minCol=30,maxCol=-1;
        for(int i=rowStart;i<=rowEnd;i++){
            for(int j=colStart;j<=colEnd;j++){
                if(grid[i][j]==1){
                    minRow=Math.min(minRow,i);
                    maxRow=Math.max(maxRow,i);
                    minCol=Math.min(minCol,j);
                    maxCol=Math.max(maxCol,j);
                }
            }
        } return maxRow==-1?0:(maxRow-minRow+1)*(maxCol-minCol+1);
    }
}
