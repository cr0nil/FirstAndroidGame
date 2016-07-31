package screens;


import com.firstx.cos.Piersi;

import entities.Jumper;

/**
 * Created by Karol on 28.07.2016.
 */
public class GameplayScreen extends AbstractScreen {

    private Jumper jumper;

    public GameplayScreen(Piersi game) {
        super(game);
    }

    @Override
    protected void init() {
        initPlayer();
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
