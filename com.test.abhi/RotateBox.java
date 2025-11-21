/**
 * https://leetcode.com/problems/rotating-the-box/
 * 
 * NOT Complete
 */

class RotateBox {
    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] returnGrid = new char[boxGrid[0].length][boxGrid.length];

        int row=0;
        for(int i=0; i< boxGrid[0].length; i++){
            int col=0;
            for(int j=boxGrid.length-1; j>=0 ; j--){
                if('.' == boxGrid[j][i]) continue;
                int realRow = calcYValue(boxGrid[j], row);
                returnGrid[realRow][col] = boxGrid[j][i];
                if(realRow!=row){
                    returnGrid[row][col] = '.';
                }
                col++;
            }
            row++;
        }

        return returnGrid;
    }

    /**
        This is calculating if the stone should fall. That's why it starts to look at the next value (i = col+1).
        Then if it falls, i counter gets moved 1 extra time, so return i-1.
     */
    private Integer calcYValue(char[] boxXGrid, int col){
        System.out.println("col: "+col+ " val: "+boxXGrid[col]);
        
        int i = col+1;
        while(i< boxXGrid.length){
            System.out.println("i: "+i+ " val: "+boxXGrid[i]);
            if('*' == boxXGrid[i] || '#' == boxXGrid[i]) { 
                break;
            }
            i++;
        }


        return i-1; //wtf
    }
}