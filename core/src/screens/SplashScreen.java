package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.firstx.cos.Piersi;

/**
 * Created by Karol on 27.07.2016.
 */
public class SplashScreen extends AbstractScreen {
    private Texture splashImg;

    public SplashScreen(final Piersi game) {
        super(game);
        init();

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                game.setScreen(new GameplayScreen(game));
            }
        }, 2);
    }
    @Override
    protected void init() {
        splashImg = new Texture("plik.png");

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(splashImg, 240, 0);
        spriteBatch.end();
    }
}
