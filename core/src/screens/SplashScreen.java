package screens;

import com.badlogic.gdx.graphics.Texture;
import com.firstx.cos.Piersi;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Karol on 27.07.2016.
 */
public class SplashScreen extends AbstractScreen{
    private Texture splashImg;

    public SplashScreen(Piersi game) {
        super(game);
        init();
    }

    private void init() {
        splashImg = new Texture("plik.png");

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(splashImg,0,0);
        spriteBatch.end();
    }
}
