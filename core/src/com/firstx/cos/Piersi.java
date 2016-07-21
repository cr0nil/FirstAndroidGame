package com.firstx.cos;

import com.badlogic.gdx.ApplicationAdapter;
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

public class Piersi extends ApplicationAdapter {
    private SpriteBatch batcher;
    private Texture textura;
    private BitmapFont fonter;
    private Jumper jumper1, jumper2;
    private float timeHelper;
    private OrthographicCamera kamera;
    private Music muzyka;
    private Sound dzwiek;
  //  private int ale=0;

    @Override
    public void create() {
        batcher = new SpriteBatch();
        textura = new Texture("plik.png");
        fonter = new BitmapFont();
        fonter.setColor(Color.BLUE);
        kamera = new OrthographicCamera(1600, 900);
        muzyka = Gdx.audio.newMusic(Gdx.files.internal("hymn.mp3"));
        //muzyka.play();
        dzwiek = Gdx.audio.newSound(Gdx.files.internal("Jump.ogg"));

        jumper1 = new Jumper(textura);
        jumper1.x = 0;
        jumper1.y = 0;
        jumper1.height = jumper1.getTextura().getHeight();
        jumper1.width = jumper1.getTextura().getWidth();


        jumper2 = new Jumper(textura);
        jumper2.x = 200;
        jumper2.y = 300;
        jumper2.height = jumper2.getTextura().getHeight();
        jumper2.width = jumper2.getTextura().getWidth();//wysokosc obrazka

    }


    @Override
    public void render() {
        update();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batcher.begin();
        batcher.draw(jumper1.getTextura(), jumper1.x, jumper1.y);
        batcher.draw(jumper2.getTextura(), jumper2.x, jumper2.y);
        //fonter.draw(batcher,ale,0,0);
        batcher.end();
    }

    public void update() {
        kamera.update();
        batcher.setProjectionMatrix(kamera.combined);
        kamera.position.set(jumper1.x + jumper1.width / 2, jumper1.y + jumper1.height / 2, 0);

      //  if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
      //      kamera.zoom += 0.02f;
       // }
       // if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
        //    kamera.zoom -= 0.02f;
      //  }


        if (Gdx.input.isKeyPressed(Input.Buttons.MIDDLE)) {
            jumper1.x += 300 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            jumper1.x -= 300 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            jumper1.y -= 300 * Gdx.graphics.getDeltaTime();

        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            jumper1.y += 300 * Gdx.graphics.getDeltaTime();

        }
        if (jumper1.overlaps(jumper2)) {
            dzwiek.play(); //kolizja
            jumper1.x = 0;
            jumper1.y = 0;

           // ale++;
        }

        timeHelper += Gdx.graphics.getDeltaTime();
        //if (timeHelper > 0.02f) {
            // kamera.rotate(0.20f);//dooo
        //    timeHelper = 0;

    //   }

    }

    @Override
    public void dispose() {
        fonter.dispose();
        batcher.dispose();
        textura.dispose();
        muzyka.dispose();
        dzwiek.dispose();
    }
}
