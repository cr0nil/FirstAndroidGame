package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.firstx.cos.Piersi;

import Controllers.GameScreenController;

/**
 * Created by Karol on 27.07.2016.
 */
public class SplashScreen extends AbstractScreen {
    private Texture splashImg;
    private GameScreenController gameScreenController;

    public SplashScreen(final Piersi game) {
        super(game);
        init();

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                gameScreenController.push(new MenuScreen());
                // game.setScreen(new GameplayScreen(game));
            }
        }, 3);
    }

    @Override
    protected void init() {
        splashImg = new Texture("jcj.jpg");
        WelcomeSound();

    }


    @Override
    public void render(SpriteBatch sb) {
        this.sb.begin();
        this.sb.draw(splashImg, 0, 0);
        this.sb.end();
    }

    private void WelcomeSound() {
        game.getSoundService().playWelcomeSound();
    }

    @Override
    public void handleInput() {

    }
}
