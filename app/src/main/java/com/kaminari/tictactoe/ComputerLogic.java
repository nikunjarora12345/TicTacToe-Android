package com.kaminari.tictactoe;

import android.os.Handler;

import java.util.Random;

public class ComputerLogic {

    private MainActivity board;
    private boolean computerFirst = false;
    private boolean movePlayed = false; // Check to see if the computer played it's move

    public void nextMove(final MainActivity board) {
        computerFirst = !board.cross.isChecked() && board.isEmpty(); // is Computer going first
        this.board = board;

        if(board.playerTurn)
            return;

        Handler handler = new Handler(); // Give a delay of 1 second to make it look realistic
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                movePlayed = false;
                if (computerFirst && board.button5.getText().equals("")) {
                    board.button5.setText("X"); // Place the move in the center
                    movePlayed = true;
                } else if(!computerFirst) {
                    if(!movePlayed) win(); // First priority goes to winning
                    if(!movePlayed) defend(); // Second priority goes to preventing player from winning
                    if(!movePlayed) randomMove(); // Make a random move
                }

                if(movePlayed) {
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
            }
        }, 1000);

    }
    
    private void defend() {
        if(board.cross.isChecked()) {
            if(board.button1.getText().equals("X") && board.button2.getText().equals("X") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("O");
                movePlayed = true;
            } else if(board.button3.getText().equals("X") && board.button2.getText().equals("X") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("O");
                movePlayed = true;
            } else if(board.button1.getText().equals("X") && board.button3.getText().equals("X") && board.button2.getText().equals("") && !board.playerTurn) {
                board.button2.setText("O");
                movePlayed = true;
            }
            else if(board.button4.getText().equals("X") && board.button5.getText().equals("X") && board.button6.getText().equals("") && !board.playerTurn) {
                board.button6.setText("O");
                movePlayed = true;
            } else if(board.button6.getText().equals("X") && board.button5.getText().equals("X") && board.button4.getText().equals("") && !board.playerTurn) {
                board.button4.setText("O");
                movePlayed = true;
            } else if(board.button4.getText().equals("X") && board.button6.getText().equals("X") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("O");
                movePlayed = true;
            }
            else if(board.button7.getText().equals("X") && board.button8.getText().equals("X") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("O");
                movePlayed = true;
            } else if(board.button9.getText().equals("X") && board.button8.getText().equals("X") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("O");
                movePlayed = true;
            } else if(board.button7.getText().equals("X") && board.button9.getText().equals("X") && board.button8.getText().equals("") && !board.playerTurn) {
                board.button8.setText("O");
                movePlayed = true;
            }
            else if(board.button1.getText().equals("X") && board.button4.getText().equals("X") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("O");
                movePlayed = true;
            } else if(board.button7.getText().equals("X") && board.button4.getText().equals("X") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("O");
                movePlayed = true;
            } else if(board.button1.getText().equals("X") && board.button7.getText().equals("X") && board.button4.getText().equals("") && !board.playerTurn) {
                board.button4.setText("O");
                movePlayed = true;
            }
            else if(board.button2.getText().equals("X") && board.button5.getText().equals("X") && board.button8.getText().equals("") && !board.playerTurn) {
                board.button8.setText("O");
                movePlayed = true;
            } else if(board.button8.getText().equals("X") && board.button5.getText().equals("X") && board.button2.getText().equals("") && !board.playerTurn) {
                board.button2.setText("O");
                movePlayed = true;
            } else if(board.button2.getText().equals("X") && board.button8.getText().equals("X") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("O");
                movePlayed = true;
            }
            else if(board.button3.getText().equals("X") && board.button6.getText().equals("X") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("O");
                movePlayed = true;
            } else if(board.button9.getText().equals("X") && board.button6.getText().equals("X") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("O");
                movePlayed = true;
            } else if(board.button3.getText().equals("X") && board.button9.getText().equals("X") && board.button6.getText().equals("") && !board.playerTurn) {
                board.button6.setText("O");
                movePlayed = true;
            }
            else if(board.button1.getText().equals("X") && board.button5.getText().equals("X") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("O");
                movePlayed = true;
            } else if(board.button9.getText().equals("X") && board.button5.getText().equals("X") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("O");
                movePlayed = true;
            } else if(board.button1.getText().equals("X") && board.button9.getText().equals("X") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("O");
                movePlayed = true;
            }
            else if(board.button3.getText().equals("X") && board.button5.getText().equals("X") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("O");
                movePlayed = true;
            } else if(board.button7.getText().equals("X") && board.button5.getText().equals("X") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("O");
                movePlayed = true;
            } else if(board.button3.getText().equals("X") && board.button7.getText().equals("X") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("O");
                movePlayed = true;
            }
        } else if(board.naught.isChecked()) {
            if(board.button1.getText().equals("O") && board.button2.getText().equals("O") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("X");
                movePlayed = true;
            } else if(board.button3.getText().equals("O") && board.button2.getText().equals("O") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("X");
                movePlayed = true;
            } else if(board.button1.getText().equals("O") && board.button3.getText().equals("O") && board.button2.getText().equals("") && !board.playerTurn) {
                board.button2.setText("X");
                movePlayed = true;
            }
            else if(board.button4.getText().equals("O") && board.button5.getText().equals("O") && board.button6.getText().equals("") && !board.playerTurn) {
                board.button6.setText("X");
                movePlayed = true;
            } else if(board.button6.getText().equals("O") && board.button5.getText().equals("O") && board.button4.getText().equals("") && !board.playerTurn) {
                board.button4.setText("X");
                movePlayed = true;
            } else if(board.button4.getText().equals("O") && board.button6.getText().equals("O") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("X");
                movePlayed = true;
            }
            else if(board.button7.getText().equals("O") && board.button8.getText().equals("O") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("X");
                movePlayed = true;
            } else if(board.button9.getText().equals("O") && board.button8.getText().equals("O") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("X");
                movePlayed = true;
            } else if(board.button7.getText().equals("O") && board.button9.getText().equals("O") && board.button8.getText().equals("") && !board.playerTurn) {
                board.button8.setText("X");
                movePlayed = true;
            }
            else if(board.button1.getText().equals("O") && board.button4.getText().equals("O") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("X");
                movePlayed = true;
            } else if(board.button7.getText().equals("O") && board.button4.getText().equals("O") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("X");
                movePlayed = true;
            } else if(board.button1.getText().equals("O") && board.button7.getText().equals("O") && board.button4.getText().equals("") && !board.playerTurn) {
                board.button4.setText("X");
                movePlayed = true;
            }
            else if(board.button2.getText().equals("O") && board.button5.getText().equals("O") && board.button8.getText().equals("") && !board.playerTurn) {
                board.button8.setText("X");
                movePlayed = true;
            } else if(board.button8.getText().equals("O") && board.button5.getText().equals("O") && board.button2.getText().equals("") && !board.playerTurn) {
                board.button2.setText("X");
                movePlayed = true;
            } else if(board.button2.getText().equals("O") && board.button8.getText().equals("O") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("X");
                movePlayed = true;
            }
            else if(board.button3.getText().equals("O") && board.button6.getText().equals("O") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("X");
                movePlayed = true;
            } else if(board.button9.getText().equals("O") && board.button6.getText().equals("O") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("X");
                movePlayed = true;
            } else if(board.button3.getText().equals("O") && board.button9.getText().equals("O") && board.button6.getText().equals("") && !board.playerTurn) {
                board.button6.setText("X");
                movePlayed = true;
            }
            else if(board.button1.getText().equals("O") && board.button5.getText().equals("O") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("X");
                movePlayed = true;
            } else if(board.button9.getText().equals("O") && board.button5.getText().equals("O") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("X");
                movePlayed = true;
            } else if(board.button1.getText().equals("O") && board.button9.getText().equals("O") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("X");
                movePlayed = true;
            }
            else if(board.button3.getText().equals("O") && board.button5.getText().equals("O") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("X");
                movePlayed = true;
            } else if(board.button7.getText().equals("O") && board.button5.getText().equals("O") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("X");
                movePlayed = true;
            } else if(board.button3.getText().equals("O") && board.button7.getText().equals("O") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("X");
                movePlayed = true;
            }
        }
    }
    
    private void win() {
        if(board.cross.isChecked()) {
            if(board.button1.getText().equals("O") && board.button2.getText().equals("O") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("O");
                movePlayed = true;
            } else if(board.button3.getText().equals("O") && board.button2.getText().equals("O") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("O");
                movePlayed = true;
            } else if(board.button1.getText().equals("O") && board.button3.getText().equals("O") && board.button2.getText().equals("") && !board.playerTurn) {
                board.button2.setText("O");
                movePlayed = true;
            }
            else if(board.button4.getText().equals("O") && board.button5.getText().equals("O") && board.button6.getText().equals("") && !board.playerTurn) {
                board.button6.setText("O");
                movePlayed = true;
            } else if(board.button6.getText().equals("O") && board.button5.getText().equals("O") && board.button4.getText().equals("") && !board.playerTurn) {
                board.button4.setText("O");
                movePlayed = true;
            } else if(board.button4.getText().equals("O") && board.button6.getText().equals("O") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("O");
                movePlayed = true;
            }
            else if(board.button7.getText().equals("O") && board.button8.getText().equals("O") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("O");
                movePlayed = true;
            } else if(board.button9.getText().equals("O") && board.button8.getText().equals("O") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("O");
                movePlayed = true;
            } else if(board.button7.getText().equals("O") && board.button9.getText().equals("O") && board.button8.getText().equals("") && !board.playerTurn) {
                board.button8.setText("O");
                movePlayed = true;
            }
            else if(board.button1.getText().equals("O") && board.button4.getText().equals("O") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("O");
                movePlayed = true;
            } else if(board.button7.getText().equals("O") && board.button4.getText().equals("O") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("O");
                movePlayed = true;
            } else if(board.button1.getText().equals("O") && board.button7.getText().equals("O") && board.button4.getText().equals("") && !board.playerTurn) {
                board.button4.setText("O");
                movePlayed = true;
            }
            else if(board.button2.getText().equals("O") && board.button5.getText().equals("O") && board.button8.getText().equals("") && !board.playerTurn) {
                board.button8.setText("O");
                movePlayed = true;
            } else if(board.button8.getText().equals("O") && board.button5.getText().equals("O") && board.button2.getText().equals("") && !board.playerTurn) {
                board.button2.setText("O");
                movePlayed = true;
            } else if(board.button2.getText().equals("O") && board.button8.getText().equals("O") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("O");
                movePlayed = true;
            }
            else if(board.button3.getText().equals("O") && board.button6.getText().equals("O") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("O");
                movePlayed = true;
            } else if(board.button9.getText().equals("O") && board.button6.getText().equals("O") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("O");
                movePlayed = true;
            } else if(board.button3.getText().equals("O") && board.button9.getText().equals("O") && board.button6.getText().equals("") && !board.playerTurn) {
                board.button6.setText("O");
                movePlayed = true;
            }
            else if(board.button1.getText().equals("O") && board.button5.getText().equals("O") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("O");
                movePlayed = true;
            } else if(board.button9.getText().equals("O") && board.button5.getText().equals("O") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("O");
                movePlayed = true;
            } else if(board.button1.getText().equals("O") && board.button9.getText().equals("O") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("O");
                movePlayed = true;
            }
            else if(board.button3.getText().equals("O") && board.button5.getText().equals("O") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("O");
                movePlayed = true;
            } else if(board.button7.getText().equals("O") && board.button5.getText().equals("O") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("O");
                movePlayed = true;
            } else if(board.button3.getText().equals("O") && board.button7.getText().equals("O") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("O");
                movePlayed = true;
            }

        } else if(board.naught.isChecked()) {
            if(board.button1.getText().equals("X") && board.button2.getText().equals("X") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("X");
                movePlayed = true;
            } else if(board.button3.getText().equals("X") && board.button2.getText().equals("X") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("X");
                movePlayed = true;
            } else if(board.button1.getText().equals("X") && board.button3.getText().equals("X") && board.button2.getText().equals("") && !board.playerTurn) {
                board.button2.setText("X");
                movePlayed = true;
            }
            else if(board.button4.getText().equals("X") && board.button5.getText().equals("X") && board.button6.getText().equals("") && !board.playerTurn) {
                board.button6.setText("X");
                movePlayed = true;
            } else if(board.button6.getText().equals("X") && board.button5.getText().equals("X") && board.button4.getText().equals("") && !board.playerTurn) {
                board.button4.setText("X");
                movePlayed = true;
            } else if(board.button4.getText().equals("X") && board.button6.getText().equals("X") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("X");
                movePlayed = true;
            }
            else if(board.button7.getText().equals("X") && board.button8.getText().equals("X") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("X");
                movePlayed = true;
            } else if(board.button9.getText().equals("X") && board.button8.getText().equals("X") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("X");
                movePlayed = true;
            } else if(board.button7.getText().equals("X") && board.button9.getText().equals("X") && board.button8.getText().equals("") && !board.playerTurn) {
                board.button8.setText("X");
                movePlayed = true;
            }
            else if(board.button1.getText().equals("X") && board.button4.getText().equals("X") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("X");
                movePlayed = true;
            } else if(board.button7.getText().equals("X") && board.button4.getText().equals("X") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("X");
                movePlayed = true;
            } else if(board.button1.getText().equals("X") && board.button7.getText().equals("X") && board.button4.getText().equals("") && !board.playerTurn) {
                board.button4.setText("X");
                movePlayed = true;
            }
            else if(board.button2.getText().equals("X") && board.button5.getText().equals("X") && board.button8.getText().equals("") && !board.playerTurn) {
                board.button8.setText("X");
                movePlayed = true;
            } else if(board.button8.getText().equals("X") && board.button5.getText().equals("X") && board.button2.getText().equals("") && !board.playerTurn) {
                board.button2.setText("X");
                movePlayed = true;
            } else if(board.button2.getText().equals("X") && board.button8.getText().equals("X") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("X");
                movePlayed = true;
            }
            else if(board.button3.getText().equals("X") && board.button6.getText().equals("X") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("X");
                movePlayed = true;
            } else if(board.button9.getText().equals("X") && board.button6.getText().equals("X") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("X");
                movePlayed = true;
            } else if(board.button3.getText().equals("X") && board.button9.getText().equals("X") && board.button6.getText().equals("") && !board.playerTurn) {
                board.button6.setText("X");
                movePlayed = true;
            }
            else if(board.button1.getText().equals("X") && board.button5.getText().equals("X") && board.button9.getText().equals("") && !board.playerTurn) {
                board.button9.setText("X");
                movePlayed = true;
            } else if(board.button9.getText().equals("X") && board.button5.getText().equals("X") && board.button1.getText().equals("") && !board.playerTurn) {
                board.button1.setText("X");
                movePlayed = true;
            } else if(board.button1.getText().equals("X") && board.button9.getText().equals("X") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("X");
                movePlayed = true;
            }
            else if(board.button3.getText().equals("X") && board.button5.getText().equals("X") && board.button7.getText().equals("") && !board.playerTurn) {
                board.button7.setText("X");
                movePlayed = true;
            } else if(board.button7.getText().equals("X") && board.button5.getText().equals("X") && board.button3.getText().equals("") && !board.playerTurn) {
                board.button3.setText("X");
                movePlayed = true;
            } else if(board.button3.getText().equals("X") && board.button7.getText().equals("X") && board.button5.getText().equals("") && !board.playerTurn) {
                board.button5.setText("X");
                movePlayed = true;
            }
        }
    }
    
    private void randomMove() {
        Random r = new Random();

        while (!movePlayed) {
            switch (r.nextInt(9)) {
                case 0:
                    if(board.button1.getText().equals("") && !board.playerTurn) {
                        if(board.cross.isChecked())
                            board.button1.setText("O");
                        else
                            board.button1.setText("X");
                        
                        movePlayed = true;
                    }
                    break;
                case 1:
                    if(board.button2.getText().equals("") && !board.playerTurn) {
                        if(board.cross.isChecked())
                            board.button2.setText("O");
                        else
                            board.button2.setText("X");

                        movePlayed = true;
                    }
                    break;
                case 2:
                    if(board.button3.getText().equals("") && !board.playerTurn) {
                        if(board.cross.isChecked())
                            board.button3.setText("O");
                        else
                            board.button3.setText("X");

                        movePlayed = true;
                    }
                    break;
                case 3:
                    if(board.button4.getText().equals("") && !board.playerTurn) {
                        if(board.cross.isChecked())
                            board.button4.setText("O");
                        else
                            board.button4.setText("X");

                        movePlayed = true;
                    }
                    break;
                case 4:
                    if(board.button5.getText().equals("") && !board.playerTurn) {
                        if(board.cross.isChecked())
                            board.button5.setText("O");
                        else
                            board.button5.setText("X");

                        movePlayed = true;
                    }
                    break;
                case 5:
                    if(board.button6.getText().equals("") && !board.playerTurn) {
                        if(board.cross.isChecked())
                            board.button6.setText("O");
                        else
                            board.button6.setText("X");

                        movePlayed = true;
                    }
                    break;
                case 6:
                    if(board.button7.getText().equals("") && !board.playerTurn) {
                        if(board.cross.isChecked())
                            board.button7.setText("O");
                        else
                            board.button7.setText("X");

                        movePlayed = true;
                    }
                    break;
                case 7:
                    if(board.button8.getText().equals("") && !board.playerTurn) {
                        if(board.cross.isChecked())
                            board.button8.setText("O");
                        else
                            board.button8.setText("X");

                        movePlayed = true;
                    }
                    break;
                case 8:
                    if(board.button9.getText().equals("") && !board.playerTurn) {
                        if(board.cross.isChecked())
                            board.button9.setText("O");
                        else
                            board.button9.setText("X");

                        movePlayed = true;
                    }
                    break;
            }
        }
    }
}
