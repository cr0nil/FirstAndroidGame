package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.firstx.cos.Piersi;

/**
 * Created by Karol on 27.07.2016.
 */
public class SplashScreen extends AbstractScreen {
    private Texture splashImg;

    public SplashScreen(final Piersi game) {
        super(game);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new MenuScreen(game));
            }
        }, 3);
    }

    @Override
    protected void init() {
        splashImg = new Texture("jcj.jpg");
        WelcomeSound();

    }



    private void WelcomeSound() {
        game.getSoundService().playWelcomeSound();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(splashImg,0,0);
        spriteBatch.end();
    }
}
