package com.firstx.cos;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Controllers.GameScreenController;
import Service.ScoreService;
import Service.SoundService;
import screens.MenuScreen;
import screens.SplashScreen;

public class Piersi extends Game {
    public final static String GAME_NAME = "FIRST";
    public final static int WIDTH = 480;
    public final static int HEIGHT = 700;
    private GameScreenController gameScreenController;
    private SpriteBatch batch;
    private SoundService soundService;
    private ScoreService scoreService;

    private boolean paused;

    @Override
    public void create() {

        init();
        this.setScreen(new SplashScreen(this));

    }

    @Override
    public void render() {
        gameScreenController.update(Gdx.graphics.getDeltaTime());
        gameScreenController.render(batch);
    }

    private void init() {

        initSoundService();
        initScoreService();
    }

    private void initScoreService() {
        scoreService = new ScoreService();
    }

    private void initSoundService() {
        soundService = new SoundService();
    }


//    public void update() {
//        timeHelper += Gdx.graphics.getDeltaTime();
//        //if (timeHelper > 0.02f) {
//        // camera.rotate(0.20f);//dooo
//        //    timeHelper = 0;
//
//        //   }
//
//    }

    /*
    -
    getters & setters
     */

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public SoundService getSoundService() {
        return soundService;
    }

    public ScoreService getScoreService() {
        return scoreService;
    }
}

