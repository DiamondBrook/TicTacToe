package com.example.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var board = Array(9) {0} //array of 9, one cell for each square in the grid
    var currentPlayer = 1
    var gameOver = false
    var playerOneWins = 0
    var playerTwoWins = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /* Check the global variable board to see if a certain player has won the game */
    private fun checkForWin(board: Array<Int>, player: Int): Boolean {

        var color = if(player == 1){
            R.drawable.red_style
        } else {
            R.drawable.blue_style
        }
        //check for horizontal wins
        println("Checking for a win for player $player")
        if (board[0] == player && board[1] == player && board[2] == player) {
            findViewById<TextView>(R.id.topLeft).setBackgroundResource(color)
            findViewById<TextView>(R.id.top).setBackgroundResource(color)
            findViewById<TextView>(R.id.topRight).setBackgroundResource(color)
            if(player == 1){
                playerOneWins++
                findViewById<TextView>(R.id.p1WinView).text = playerOneWins.toString()
            }
            else{
                playerTwoWins++
                findViewById<TextView>(R.id.p2WinView).text = playerTwoWins.toString()
            }
            println("Win detected!")
            return true
        }
        else if(board[3] == player && board[4] == player && board[5] == player){
            findViewById<TextView>(R.id.left).setBackgroundResource(color)
            findViewById<TextView>(R.id.mid).setBackgroundResource(color)
            findViewById<TextView>(R.id.right).setBackgroundResource(color)
            if(player == 1){
                playerOneWins++
                findViewById<TextView>(R.id.p1WinView).text = playerOneWins.toString()
            }
            else{
                playerTwoWins++
                findViewById<TextView>(R.id.p2WinView).text = playerTwoWins.toString()
            }
            println("Win detected!")
            return true
        }
        else if(board[6] == player && board[7] == player && board[8] == player){
            findViewById<TextView>(R.id.botLeft).setBackgroundResource(color)
            findViewById<TextView>(R.id.bot).setBackgroundResource(color)
            findViewById<TextView>(R.id.botRight).setBackgroundResource(color)
            if(player == 1){
                playerOneWins++
                findViewById<TextView>(R.id.p1WinView).text = playerOneWins.toString()
            }
            else{
                playerTwoWins++
                findViewById<TextView>(R.id.p2WinView).text = playerTwoWins.toString()
            }
            println("Win detected!")
            return true
        }
        //check for vertical wins
        else if (board[0] == player && board[3] == player && board[6] == player){
            findViewById<TextView>(R.id.botLeft).setBackgroundResource(color)
            findViewById<TextView>(R.id.left).setBackgroundResource(color)
            findViewById<TextView>(R.id.topLeft).setBackgroundResource(color)
            if(player == 1){
                playerOneWins++
                findViewById<TextView>(R.id.p1WinView).text = playerOneWins.toString()
            }
            else{
                playerTwoWins++
                findViewById<TextView>(R.id.p2WinView).text = playerTwoWins.toString()
            }
            println("Win detected!")
            return true
        }
        else if (board[1] == player && board[4] == player && board[7] == player){
            findViewById<TextView>(R.id.top).setBackgroundResource(color)
            findViewById<TextView>(R.id.mid).setBackgroundResource(color)
            findViewById<TextView>(R.id.bot).setBackgroundResource(color)
            if(player == 1){
                playerOneWins++
                findViewById<TextView>(R.id.p1WinView).text = playerOneWins.toString()
            }
            else{
                playerTwoWins++
                findViewById<TextView>(R.id.p2WinView).text = playerTwoWins.toString()
            }
            println("Win detected!")
            return true
        }
        else if(board[2] == player && board[5] == player && board[8] == player){
            findViewById<TextView>(R.id.botRight).setBackgroundResource(color)
            findViewById<TextView>(R.id.right).setBackgroundResource(color)
            findViewById<TextView>(R.id.topRight).setBackgroundResource(color)
            if(player == 1){
                playerOneWins++
                findViewById<TextView>(R.id.p1WinView).text = playerOneWins.toString()
            }
            else{
                playerTwoWins++
                findViewById<TextView>(R.id.p2WinView).text = playerTwoWins.toString()
            }
            println("Win detected!")
            return true
        }
        //check for diagonal wins
        else if(board[0] == player && board[4] == player && board[8] == player){
            findViewById<TextView>(R.id.topLeft).setBackgroundResource(color)
            findViewById<TextView>(R.id.mid).setBackgroundResource(color)
            findViewById<TextView>(R.id.botRight).setBackgroundResource(color)
            if(player == 1){
                playerOneWins++
                findViewById<TextView>(R.id.p1WinView).text = playerOneWins.toString()
            }
            else{
                playerTwoWins++
                findViewById<TextView>(R.id.p2WinView).text = playerTwoWins.toString()
            }

            println("Win detected!")
            return true
        }
        else if(board[2] == player && board[4] == player && board[6] == player){
            findViewById<TextView>(R.id.topRight).setBackgroundResource(color)
            findViewById<TextView>(R.id.mid).setBackgroundResource(color)
            findViewById<TextView>(R.id.botLeft).setBackgroundResource(color)
            if(player == 1){
                playerOneWins++
                findViewById<TextView>(R.id.p1WinView).text = playerOneWins.toString()
            }
            else{
                playerTwoWins++
                findViewById<TextView>(R.id.p2WinView).text = playerTwoWins.toString()
            }
            println("Win detected!")
            return true
        }
        return false
    }

    fun resetScores(view: View) {
        playerOneWins = 0
        playerTwoWins = 0
        findViewById<TextView>(R.id.p1WinView).text = playerOneWins.toString()
        findViewById<TextView>(R.id.p2WinView).text = playerTwoWins.toString()
    }

    /* When a won has been found, disable all the buttons*/
    private fun disableButtons(){
        val buttons = arrayOf(findViewById<Button>(R.id.topLeft),
            findViewById(R.id.top),
            findViewById(R.id.topRight),
            findViewById(R.id.left),
            findViewById(R.id.mid),
            findViewById(R.id.right),
            findViewById(R.id.botLeft),
            findViewById(R.id.bot),
            findViewById(R.id.botRight))

        for (butt in buttons){
            butt.isEnabled = false
        }
    }

    /* Insert an int into a cell */
    private fun updateBoard(cell: Int, player: Int){
        board[cell] = player
    }

    //debugging only
    private fun printBoard(arr: Array<Int>){
        println("_______")
        println("|" + arr[0] + "|" + arr[1] + "|" + arr[2] + "|")
        println("|" + arr[3] + "|" + arr[4] + "|" + arr[5] + "|")
        println("|" + arr[6] + "|" + arr[7] + "|" + arr[8] + "|")
        println("-------")
    }

    /* Reset all the buttons to their default behaviors and appearances */
    fun startGame(view: View){

        board = Array(9) {0}

        val currentPlayerView = findViewById<TextView>(R.id.current_player_view)
        gameOver = false

        findViewById<TextView>(R.id.rulesView).setText("")
        findViewById<TextView>(R.id.rulesView2).setText("")
        val buttons = arrayOf(findViewById<Button>(R.id.topLeft),
            findViewById(R.id.top),
            findViewById(R.id.topRight),
            findViewById(R.id.left),
            findViewById(R.id.mid),
            findViewById(R.id.right),
            findViewById(R.id.botLeft),
            findViewById(R.id.bot),
            findViewById(R.id.botRight))

        for (butt in buttons) {
            butt.text = ""
            butt.isEnabled = true
            butt.setTextColor(Color.parseColor("#000000"))
            butt.setBackgroundResource( R.drawable.bt_style)
            butt.visibility = View.VISIBLE

            butt.setOnClickListener(View.OnClickListener {
                butt.isEnabled = false
                val cell = butt.tag.toString().toInt()
                updateBoard(cell, currentPlayer)
                printBoard(board)
                if (currentPlayer == 1) {
                    butt.text = "X"
                    if(checkForWin(board, currentPlayer)){
                        disableButtons()
                        gameOver = true
                    } else {
                        currentPlayer = 2
                        currentPlayerView.text = this.getString(R.string.current_player_o)
                    }
                } else {
                    butt.text = "O"
                    if (checkForWin(board, currentPlayer)) {
                        disableButtons()
                        gameOver = true
                    } else {
                        currentPlayer = 1
                        currentPlayerView.text = this.getString(R.string.current_player_x)
                    }
                }
            })
        }
    }
}
