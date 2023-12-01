package com.oswizar.io.algorithm.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolveNQueens {

    @Test
    public void show() {
        System.out.println(solveNQueens(5));
    }

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] i : board) {
            Arrays.fill(i, '.');
        }
        backtrack(board, 0);
        return res;
    }

    void backtrack(char[][] board, int row) {

        //
        if (row == board.length) {
            res.add(array2List(board));
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isValid(board, row, j)) {
                board[row][j] = 'Q';
                backtrack(board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        // 检查同一列上是否已经有Q
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查当前位置的左上方是否已经有Q
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查当前位置的右上方是否已经有Q
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    List<String> array2List(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (char i : row) {
                sb.append(i);
            }
            //
            res.add(sb.toString());
        }
        return res;
    }
}
