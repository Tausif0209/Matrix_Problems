import java.util.ArrayList;
import java.util.Collections;

public class SortMatrixByDiagonal {
  public int[][] sortMatrix(int[][] grid) {
        if(grid.length==1 && grid[0].length==1) return grid;
        int[][] sortedMatrix=new int[grid.length][grid[0].length];
        ArrayList<Integer> list;
        int i,j,k,row,col;
        for(i=1;i<grid[0].length;i++){
            row=0;col=i;
            list=new ArrayList<>();
            for(j=0;j<grid.length-i;j++){
            list.add(grid[row++][col++]);
            }

            Collections.sort(list);
            row=0;col=i;
            k=0;
            for(j=0;j<grid.length-i;j++){
            sortedMatrix[row++][col++]=list.get(k++);
            }
        }

        for(i=0;i<grid.length;i++){
            row=i;col=0;
            list=new ArrayList<>();
            for(j=0;j<grid[0].length-i;j++){
            list.add(grid[row++][col++]);
            }

            Collections.sort(list,Collections.reverseOrder());
            row=i;col=0;k=0;
            for(j=0;j<grid.length-i;j++){
            sortedMatrix[row++][col++]=list.get(k++);
            }
        } return sortedMatrix;
    }
}
