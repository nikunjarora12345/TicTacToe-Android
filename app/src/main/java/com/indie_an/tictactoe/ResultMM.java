package com.indie_an.tictactoe;

public class ResultMM {

    String[] matrix; // The state of the board at a given stage
    int score; // The score associated with the board (win = +1, lose = -1, else = 0)
    int depth; // The depth in the tree structure in which this state exists

    public ResultMM(String[] matrix, int score, int depth) {
        this.matrix = matrix;
        this.score = score;
        this.depth = depth;
    }

    public int getScore() {
        return score;
    }

    public void setMatrix(String[] matrix) {
        this.matrix = matrix;
    }
}
