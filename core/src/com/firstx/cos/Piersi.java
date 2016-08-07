package com.firstx.cos;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;

import screens.SplashScreen;

public class Piersi extends Game {
    public final static String GAME_PREFS = "com.prefsfirstx.cos.pref";
    public final static String GAME_NAME = "FIRST";
    public final static String GAME_SCORE = "com.prefsfirstx.cos.pref.score";
    public final static int WIDTH = 480;
    public final static int HEIGHT = 700;
    private boolean paused;

    private Preferences prefs;
    private int points;

    @Override
    public void create() {

        init();
        this.setScreen(new SplashScreen(this));

        music = Gdx.audio.newMusic(Gdx.files.internal("hymn.mp3"));
        music.play();
//        sound = Gdx.audio.newSound(Gdx.files.internal("Jump.ogg"));

    }

    private void init() {
        prefs = Gdx.app.getPreferences(GAME_PREFS);
        loadScore();
    }

    private void loadScore() {
        points = prefs.getInteger(GAME_SCORE);
    }


    public void addPoints(int pointsToAdd) {
        points +=pointsToAdd;
        updateScore();
    }
    public void addPoint() {
        points++;
        updateScore();
    }


    public void restGameScore() {
        points = 0;
        updateScore();
    }

    private void updateScore() {
        prefs.putInteger(GAME_SCORE, points);
        prefs.flush();
    }
    public void addPassiveIncome() {

    }
    private Music music;
//    private Sound sound;
//    //  private int ale=0;


//    public void update() {
//        timeHelper += Gdx.graphics.getDeltaTime();
//        //if (timeHelper > 0.02f) {
//        // camera.rotate(0.20f);//dooo
//        //    timeHelper = 0;
//
//        //   }
//
//    }

    @Override
    public void dispose() {

        music.dispose();
//        sound.dispose();
    }
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



    public int getPoints() {
        return points;
    }
}
