import java.util.ArrayList;
import java.util.Arrays;


public class Knights {


    final int NUM_ROWS=8, NUM_COLS=8;
    //                   0 1  2  3  4  5 6 7
    final int[] H_SHIFT={2,1,-1,-2,-2,-1,1,2};
    final int[] V_SHIFT={-1,-2,-2,-1,1,2,2,1};
    int[][]board;

    int locRow, locCol;
    int moveCounter;



    public Knights(){
        board=new int[NUM_ROWS][NUM_COLS];
        resetBoard();
        printBoard();
    }

    //WORK 3
    public int [][] runTour(){
        makeMove(0,0,1);

        return board;
    }

    //WORK 2

    public Boolean makeMove(int locRow, int locCol, int moveCounter){
        board[locRow][locCol] = moveCounter;

        if (moveCounter == 64){
            return true;
        }


        ArrayList<Integer> moves = findAvailableMoves(locRow, locCol);

        for(Integer move: moves){

            int temp1 = locRow + H_SHIFT[move];
            int temp2 = locCol + V_SHIFT[move];


            if (makeMove(temp1, temp2, moveCounter+1)){

                return true;
            }

        }

        board[locRow][locCol] =0;

        return false;
    }



    public ArrayList<Integer> findAvailableMoves(int locRow, int locCol){
        ArrayList<Integer>moves=new ArrayList<>();
        for(int i=0; i<H_SHIFT.length; i++){
            if(validateCell(locRow+H_SHIFT[i], locCol+V_SHIFT[i], board)){

                if(board[locRow+H_SHIFT[i]][locCol+V_SHIFT[i]] == 0)
                    moves.add(i);
            }


        }


        return moves;
    }

    public boolean validateCell(int row, int col, int[][]arr){
        return validateRow(row, arr)&&validateCol(row, col, arr);
    }

    public boolean validateRow(int row, int[][]arr){
        return row>-1&&row<arr.length;

    }

    public boolean validateCol(int row, int col, int [][]arr){
        return col>-1&&col<arr[row].length;
    }


    public void resetBoard(){
        for(int i=0; i<board.length; i++){
            Arrays.fill(board[i], 0); //fills array with 0s

        }
    }


    public void printBoard(){
        for(int[]arr:board)
            System.out.println(Arrays.toString(arr));
    }


}
