package com.indie_an.tictactoe;

import android.os.Handler;

import java.util.ArrayList;

public class PerfectComputerLogic {

    private MainActivity board;
    private String[] textBoard = new String[9]; // The state of the board in text form
    private static String max; // The piece computer is controlling(X or O)
    private static String min; // The piece player is controlling(X or O)
    private String level; // Current level of operation (Max or Min)

    public void nextMove(final MainActivity board) {
        this.board = board;

        if(board.playerTurn)
            return;

        if(board.naught.isChecked()) {
            max = "X";
            min = "O";
        } else {
            max = "O";
            min = "X";
        }
        level = "max";

        Handler handler = new Handler(); // Create a time delay of 1 second to make it realistic
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setTextBoard(); // Convert the current board state in text format
                ResultMM bestMove = minimax(textBoard, level, 0, 0); // (textBoard, level, recurse, depth)
                applyTextBoard(bestMove.matrix); // Apply the text board to the actual view
                board.check();
                if (board.playerWon && !board.draw)
                    board.text.setText("Player Won!");
                else if (board.computerWon && !board.draw)
                    board.text.setText("Computer Won!");
                else if (board.draw)
                    board.text.setText("It's a draw!");
                else
                    board.changeTurn();
            }
        }, 1000);
    }

    private ResultMM getResult(ArrayList<ResultMM> listScore, String level) {
        ResultMM result = listScore.get(0);

        if(level.equals("max")) {
            for(int i = 1; i < listScore.size(); i++) {
                if((listScore.get(i).getScore() > result.getScore()) ||
                        (listScore.get(i).getScore() == result.getScore()
                                && listScore.get(i).depth < result.depth))
                    result = listScore.get(i);
            }
        } else {
            for(int i = 1; i < listScore.size(); i++) {
                if((listScore.get(i).getScore() < result.getScore()) ||
                        (listScore.get(i).getScore() == result.getScore()
                                && listScore.get(i).depth < result.depth))
                    result = listScore.get(i);
            }
        }

        return result;
    }

    private ResultMM minimax(String[] textBoard, String level, int recurse, int depth) {
        ArrayList<String[]> children = generateSuccessor(textBoard, level); // Get list of all possible moves

        if(children == null || gameOver(textBoard)) {
            return new ResultMM(textBoard, getScore(textBoard), depth); // if no children or game over
        } else {
            ArrayList<ResultMM> listScore = new ArrayList<>(); // Get a list of scores for all available children
            for(int i = 0; i < children.size(); i++) {
                listScore.add(minimax(children.get(i), invertLevel(level), 1, depth + 1)); // recursive call
                                                                                           // with recurse = 1 and depth + 1
            }

            ResultMM res = getResult(listScore, level); // Get the child
                                                        // with maximum (for max condition) or minimum (for min condition) score
            if(recurse == 1)
                res.setMatrix(textBoard); // If this is a recursive call, set the result
            return res;
        }
    }



    private ArrayList<String[]> generateSuccessor(String[] textBoard, String level) {
        ArrayList<String[]> successor = new ArrayList<>();

        for(int i = 0; i < textBoard.length; i++) {
            if(textBoard[i].equals("")) {
                String[] child = new String[9];
                System.arraycopy(textBoard, 0, child, 0, 9); // First match the child with the parent board state

                if(level.equals("max"))
                    child[i] = max;
                else if(level.equals("min"))
                    child[i] = min;

                successor.add(child);
            }
        }

        return (successor.size() == 0) ? null : successor;
    }

    private String invertLevel(String level) {
        return (level.equals("max")) ? "min" : "max"; // If the level is max, set to min and vice-versa
    }

    private boolean gameOver(String[] textBoard) {
        return (getScore(textBoard) != 0); // Is the game over (is the score not 0)
    }

    // Return +1 when the computer wins, -1 when the computer loses and 0 otherwise
    private int getScore(String[] textBoard) {
        if(max.equals("O")) {
            if((textBoard[0].equals("X") && textBoard[1].equals("X") && textBoard[2].equals("X")) ||
                    (textBoard[3].equals("X") && textBoard[4].equals("X") && textBoard[5].equals("X")) ||
                    (textBoard[6].equals("X") && textBoard[7].equals("X") && textBoard[8].equals("X")) ||
                    (textBoard[0].equals("X") && textBoard[3].equals("X") && textBoard[6].equals("X")) ||
                    (textBoard[1].equals("X") && textBoard[4].equals("X") && textBoard[7].equals("X")) ||
                    (textBoard[2].equals("X") && textBoard[5].equals("X") && textBoard[8].equals("X")) ||
                    (textBoard[0].equals("X") && textBoard[4].equals("X") && textBoard[8].equals("X")) ||
                    (textBoard[2].equals("X") && textBoard[4].equals("X") && textBoard[6].equals("X")))
                return -1;
            else if((textBoard[0].equals("O") && textBoard[1].equals("O") && textBoard[2].equals("O")) ||
                    (textBoard[3].equals("O") && textBoard[4].equals("O") && textBoard[5].equals("O")) ||
                    (textBoard[6].equals("O") && textBoard[7].equals("O") && textBoard[8].equals("O")) ||
                    (textBoard[0].equals("O") && textBoard[3].equals("O") && textBoard[6].equals("O")) ||
                    (textBoard[1].equals("O") && textBoard[4].equals("O") && textBoard[7].equals("O")) ||
                    (textBoard[2].equals("O") && textBoard[5].equals("O") && textBoard[8].equals("O")) ||
                    (textBoard[0].equals("O") && textBoard[4].equals("O") && textBoard[8].equals("O")) ||
                    (textBoard[2].equals("O") && textBoard[4].equals("O") && textBoard[6].equals("O")))
                return 1;
        } else if(max.equals("X")) {
            if((textBoard[0].equals("X") && textBoard[1].equals("X") && textBoard[2].equals("X")) ||
                    (textBoard[3].equals("X") && textBoard[4].equals("X") && textBoard[5].equals("X")) ||
                    (textBoard[6].equals("X") && textBoard[7].equals("X") && textBoard[8].equals("X")) ||
                    (textBoard[0].equals("X") && textBoard[3].equals("X") && textBoard[6].equals("X")) ||
                    (textBoard[1].equals("X") && textBoard[4].equals("X") && textBoard[7].equals("X")) ||
                    (textBoard[2].equals("X") && textBoard[5].equals("X") && textBoard[8].equals("X")) ||
                    (textBoard[0].equals("X") && textBoard[4].equals("X") && textBoard[8].equals("X")) ||
                    (textBoard[2].equals("X") && textBoard[4].equals("X") && textBoard[6].equals("X")))
                return 1;
            else if((textBoard[0].equals("O") && textBoard[1].equals("O") && textBoard[2].equals("O")) ||
                    (textBoard[3].equals("O") && textBoard[4].equals("O") && textBoard[5].equals("O")) ||
                    (textBoard[6].equals("O") && textBoard[7].equals("O") && textBoard[8].equals("O")) ||
                    (textBoard[0].equals("O") && textBoard[3].equals("O") && textBoard[6].equals("O")) ||
                    (textBoard[1].equals("O") && textBoard[4].equals("O") && textBoard[7].equals("O")) ||
                    (textBoard[2].equals("O") && textBoard[5].equals("O") && textBoard[8].equals("O")) ||
                    (textBoard[0].equals("O") && textBoard[4].equals("O") && textBoard[8].equals("O")) ||
                    (textBoard[2].equals("O") && textBoard[4].equals("O") && textBoard[6].equals("O")))
                return -1;
        }

        return 0;
    }

    private void setTextBoard() {
        textBoard[0] = board.button1.getText().toString();
        textBoard[1] = board.button2.getText().toString();
        textBoard[2] = board.button3.getText().toString();
        textBoard[3] = board.button4.getText().toString();
        textBoard[4] = board.button5.getText().toString();
        textBoard[5] = board.button6.getText().toString();
        textBoard[6] = board.button7.getText().toString();
        textBoard[7] = board.button8.getText().toString();
        textBoard[8] = board.button9.getText().toString();
    }

    private void applyTextBoard(String[] textBoard) {
        board.button1.setText(textBoard[0]);
        board.button2.setText(textBoard[1]);
        board.button3.setText(textBoard[2]);
        board.button4.setText(textBoard[3]);
        board.button5.setText(textBoard[4]);
        board.button6.setText(textBoard[5]);
        board.button7.setText(textBoard[6]);
        board.button8.setText(textBoard[7]);
        board.button9.setText(textBoard[8]);
    }

}
