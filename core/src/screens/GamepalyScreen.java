package screens;


import com.firstx.cos.Piersi;

import entities.Jumper;

/**
 * Created by Karol on 28.07.2016.
 */
public class GamepalyScreen extends AbstractScreen {

    private Jumper jumper;
    public GamepalyScreen(Piersi game) {
        super(game);
        init();
    }

    private void init() {
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
