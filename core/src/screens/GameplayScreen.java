package screens;


import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.firstx.cos.Piersi;

import entities.Jumper;

/**
 * Created by Karol on 28.07.2016.
 */
public class GameplayScreen extends AbstractScreen {

    private Jumper jumper;
    private Button playerButton;

    public GameplayScreen(Piersi game) {
        super(game);
    }

    @Override
    protected void init() {
        initPlayer();
        initPlayerButton();
    }

    private void initPlayerButton() {
        playerButton = new Button(new Button.ButtonStyle());
        playerButton.setWidth(460);
        playerButton.setHeight(360);
        playerButton.setX(100);
        playerButton.setY(100);
        playerButton.setDebug(true);
        stage.addActor(playerButton);

        playerButton.addListener(new ClickListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
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
        stage.act();
    }
}
