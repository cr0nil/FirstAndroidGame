package screens;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.firstx.cos.Piersi;

import entities.Jumper;

/**
 * Created by Karol on 28.07.2016.
 */
public class GameplayScreen extends AbstractScreen {

    private Jumper jumper;
    private Button playerButton;
    private Label pointsLabel;

    public GameplayScreen(Piersi game) {
        super(game);
    }

    @Override
    protected void init() {
        initPlayer();
        initPlayerButton();
        initPointsLabel();
    }

    private void initPointsLabel() {
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        pointsLabel = new Label("",labelStyle);
        pointsLabel.setX(350);
        pointsLabel.setY(650);
        stage.addActor(pointsLabel);
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
        pointsLabel.setText("Score :"+ game.getPoints());
        stage.act();
    }
}
