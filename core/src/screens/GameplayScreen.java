package screens;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.firstx.cos.Piersi;

import entities.Jumper;

/**
 * Created by Karol on 28.07.2016.
 */
public class GameplayScreen extends AbstractScreen {

    private Jumper jumper;
    private Button playerButton;
    private Button resetScoreButton;
    private Label pointsLabel;

    public GameplayScreen(Piersi game) {
        super(game);
    }

    @Override
    protected void init() {
        initPlayer();
        initPlayerButton();
        initPointsLabel();
        initRestScoreButton();
    }

    private void initRestScoreButton() {
        resetScoreButton = new Button(new Button.ButtonStyle());
        resetScoreButton.setWidth(100);
        resetScoreButton.setHeight(100);
        resetScoreButton.setX(0);
        resetScoreButton.setY(600);
        resetScoreButton.setDebug(true);
        stage.addActor(resetScoreButton);

        resetScoreButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
            game.restGameScore();

                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }


    private void initPlayerButton() {
        playerButton = new Button(new Button.ButtonStyle());
        playerButton.setWidth(480);
        playerButton.setHeight(700);
        playerButton.setX(0);
        playerButton.setY(0);
        playerButton.setDebug(false);
        stage.addActor(playerButton);

        playerButton.addListener(new ClickListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                jumper.reactiOnClick();

                game.addPoint();// zmienic na dodwanie w przypadku kolizji

                return super.touchDown(event, x, y, pointer, button);
            }
        });

    }

    private void initPointsLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        pointsLabel = new Label("", labelStyle);

        pointsLabel.setX(370);
        pointsLabel.setY(660);
        stage.addActor(pointsLabel);
    }

    private void initPlayer() {
        jumper = new Jumper();
        stage.addActor(jumper);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void update() {
        pointsLabel.setText("Score :" + game.getPoints());
        stage.act();
    }
}
