package com.example.gameboi.MathGame;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameboi.UserClasses.User;

import androidx.appcompat.app.AppCompatActivity;

class MathGameFacade extends GameFacade{

    private MathGameManager mathGameManager;
    private MathGameDisplay mathGameDisplay;


    MathGameFacade(Activity activity, User player) {
        super();
        gameManager = new MathGameManager(player);
        mathGameManager = (MathGameManager) gameManager;
        gameDisplay = new MathGameDisplay(activity, mathGameManager.getPlayerIcon());
        mathGameDisplay = (MathGameDisplay) gameDisplay;
    }

    private void updateResponse(){
        mathGameDisplay.updateResponse(mathGameManager.getResponse());
    }

    private void updateEquation() {
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
        updateDisplay();
    }

    User getPlayer() {return mathGameManager.getPlayer();}

    boolean isWinner() {return mathGameManager.isWinner();}

    @Override
    void updateDisplay() {
        super.updateDisplay();
        mathGameDisplay.updateBackgroundColor(mathGameManager.getPlayBackgroundColor());
        mathGameDisplay.updateLivesIcon();
        mathGameManager.newEquation();
        updateEquation();
    }
}
