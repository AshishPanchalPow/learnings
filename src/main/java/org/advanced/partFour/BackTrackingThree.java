package org.advanced.partFour;

import java.util.ArrayList;

public class BackTrackingThree {
    public static void main(String[] args) {
        int N=4;
        int[][] board=new int[N][N];
        int i=0; int j=0;
        ArrayList<ArrayList<Integer>> path=new ArrayList<>();
        System.out.println(NQueen(board,i,j,N,path));
        System.out.println(board);
        System.out.println(path);

    }

    private static boolean NQueen(int[][] board, int row, int col, int N, ArrayList<ArrayList<Integer>> path) {

        if(row==N){
            System.out.println("Queens can be placed");
            return true;
        }
        for(int j=0; j<N; j++){
            board[row][j]=1;
            ArrayList<Integer> p=new ArrayList<>();
            p.add(row);
            p.add(j);
            path.add(p);
            if(canPlaceQueen(row,j,board, N) && NQueen(board, row+1, j, N,path)){

                return true;
            }
            if(path.size()>0)path.remove(path.size()-1);
            board[row][j]=0;
        }
        return false;
    }
    private static boolean canPlaceQueen(int i, int j, int[][]board, int N){
        System.out.println(i+" "+j);
        //Iterate over all rows except this one & check the column
        for(int row=0; row<N; row++){
            if(row==i) continue;
            if(board[row][j]==1) return false;
        }
        // Diagonal
        return diagonalOne(board,i,j);
    }
    private static boolean diagonalOne(int[][] board, int i, int j){
        int x=i; int y=j;
        int N=board.length;
        while (x<N-1 && y<N-1){
            x++; y++;
            if(board[x][y]==1) return false;
        }
        x=i; y=j;
        while (x>0 && y>0){
            x--; y--;
            if(board[x][y]==1) return false;
        }
        x=i; y=j;
        while(x<N-1 && y>0){
            x++;y--;
            if(board[x][y]==1) return false;
        }
        x=i; y=j;
        while(x>0 && y<N-1){
            x--;y++;
            if(board[x][y]==1) return false;
        }
        //return true;
        return true;
    }
}















