package com.firstx.cos;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import screens.SplashScreen;

public class Piersi extends Game {
    public final static String GAME_NAME = "FIRST";
    public final static int WIDTH = 480;
    public final static int HEIGHT = 700;
    private boolean paused;

//
//    private BitmapFont font;
//    private Jumper jumper1, jumper2;
//    private float timeHelper;
//
   private Music music;
//    private Sound sound;
//    //  private int ale=0;

    @Override
    public void create() {

        this.setScreen(new SplashScreen(this));
//        font = new BitmapFont();
//        font.setColor(Color.BLUE);
//        camera = new OrthographicCamera(1600, 900);
        music = Gdx.audio.newMusic(Gdx.files.internal("hymn.mp3"));
        music.play();
//        sound = Gdx.audio.newSound(Gdx.files.internal("Jump.ogg"));
//
////        jumper1 = new Jumper(texture);
////        jumper1.x = 0;
////        jumper1.y = 0;
////        jumper1.height = jumper1.getTextura().getHeight();
////        jumper1.width = jumper1.getTextura().getWidth();
////
////
////        jumper2 = new Jumper(texture);
////        jumper2.x = 200;
////        jumper2.y = 300;
////        jumper2.height = jumper2.getTextura().getHeight();
////        jumper2.width = jumper2.getTextura().getWidth();//wysokosc obrazka
//
   }
//
//
//
//
//    public void update() {
//        camera.update();
////        batch.setProjectionMatrix(camera.combined);
////        camera.position.set(jumper1.x + jumper1.width / 2, jumper1.y + jumper1.height / 2, 0);
//
//        //  if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
//        //      camera.zoom += 0.02f;
//        // }
//        // if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
//        //    camera.zoom -= 0.02f;
//        //  }
//
//
//        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
//            jumper1.x += 300 * Gdx.graphics.getDeltaTime();
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
//            jumper1.x -= 300 * Gdx.graphics.getDeltaTime();
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
//            jumper1.y -= 300 * Gdx.graphics.getDeltaTime();
//
//        }
//        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
//            jumper1.y += 300 * Gdx.graphics.getDeltaTime();
//
//        }
//        if (jumper1.overlaps(jumper2)) {
//            sound.play(); //kolizja
//            jumper1.x = 0;
//            jumper1.y = 0;
//
//            // ale++;
//        }
//
//        timeHelper += Gdx.graphics.getDeltaTime();
//        //if (timeHelper > 0.02f) {
//        // camera.rotate(0.20f);//dooo
//        //    timeHelper = 0;
//
//        //   }
//
//    }
//
   @Override
    public void dispose() {
//        font.dispose();
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
}
