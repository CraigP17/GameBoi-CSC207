package com.example.gameboi.MathGame;

import android.app.Activity;
import android.content.Intent;

import com.example.gameboi.UserClasses.User;

import androidx.appcompat.app.AppCompatActivity;

class MathGameFacade extends GameFacade{

    private MathGameManager mathGameManager;
    private MathGameDisplay mathGameDisplay;


    MathGameFacade(MathGame activity) {
        super();
        User player = activity.getIntent().getParcelableExtra("player");
        gameDisplay = new MathGameDisplay(activity);
        gameManager = new MathGameManager(player);
        mathGameManager = (MathGameManager) gameManager;
        mathGameDisplay = new MathGameDisplay(activity);
    }

    private void updateResponse(){
        mathGameDisplay.updateResponse(mathGameManager.getResponse());
    }

    void updateEquation() {
        mathGameDisplay.updateEquation(mathGameManager.getEquation());
    }

    void clickNumButton(int num) {
        mathGameManager.clickNumButton(num);
        updateResponse();
    }

    void pressClear(){
        mathGameManager.clearResponse();
        updateResponse();
    }

    void pressEnter(){
        mathGameManager.submitInput();
        mathGameManager.newEquation();
        updateResponse();
        updateEquation();
    }

    User getPlayer() {return mathGameManager.getPlayer();}

    boolean isWinner() {return mathGameManager.isWinner();}

}
