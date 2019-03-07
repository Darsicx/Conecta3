package com.example.carlos.conecta3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //0=yellow, 1=red
    int activePlayer=0;
    boolean activeGame=true;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view) {
        ImageView ficha5 = (ImageView) view;

        int tappedCounter = Integer.parseInt(ficha5.getTag().toString());

        //  ficha5.animate().translationY(-1000f);

        //ficha5.animate().translationYBy(1000f).setDuration(1500);

        if (gameState[tappedCounter] == 2 && activeGame) {
            gameState[tappedCounter]=activePlayer;
            if (activePlayer == 0) {
                ficha5.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                ficha5.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
        }
        for(int[] winningPosition:winningPositions){
            if(gameState[winningPosition[0]] == 1 && gameState[winningPosition[1]] == 1 && gameState[winningPosition[2]] == 1){
                Toast.makeText(this, "Felicidades han ganado las fichas rojas", Toast.LENGTH_SHORT).show();
                LinearLayout caja= findViewById(R.id.playAgainLayout);
                caja.setVisibility(View.VISIBLE);
                activeGame=false;
            }
            else if(gameState[winningPosition[0]]== 0 && gameState[winningPosition[1]] == 0 && gameState[winningPosition[2]] == 0){
                Toast.makeText(this, "Felicidades han ganado las fichas amarillas", Toast.LENGTH_SHORT).show();
                LinearLayout caja= findViewById(R.id.playAgainLayout);
                caja.setVisibility(View.VISIBLE);
                activeGame=false;
            }
//            else {
//                boolean gameOver=true;
//                for(int i=0;i<gameState.length;i++) {
//                    if(gameState[i]==2 && gameState[7]==2){
//                        gameOver=false;
//                    }
//                 if(gameOver ==true) {
//                     Toast.makeText(this, "ES UN EMPATE, JUEGA OTRA VEZ", Toast.LENGTH_SHORT).show();
//                     LinearLayout caja = findViewById(R.id.playAgainLayout);
//                     caja.setVisibility(View.VISIBLE);
//                 }
//                }
//            }

        }

    }
    public void weGoAgain(View view){
        LinearLayout caja= findViewById(R.id.playAgainLayout);
        caja.setVisibility(View.INVISIBLE);
        activePlayer=0;
        activeGame=true;

        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        //GridLayout principal=findViewById(R.id.gridLayout);
        android.support.v7.widget.GridLayout principal= (android.support.v7.widget.GridLayout) findViewById(R.id.gridLayout);
        for (int i=0;i<principal.getChildCount();i++){
            ((ImageView) principal.getChildAt(i)).setImageResource(0);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
