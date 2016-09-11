package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.firstx.cos.Piersi;

import UserInterface_UI.IClickCallback;
import UserInterface_UI.PlayButton;

/**
 * Created by Karol on 22.08.2016.
 */
public class MenuScreen extends AbstractScreen {
    private PlayButton playButton;
    private Texture background;


    public MenuScreen(final Piersi game) {
        super(game);
        init();
        playButton = new PlayButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.setScreen(new GameplayScreen(game));
//                game.getScoreService().restGameScore();
            }
        });
        //stage.addActor(playButton);
    }
    @Override
    public void init(){
        background=new Texture("123.png");
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        spriteBatch.draw(background,0,0);
        spriteBatch.draw(playButton,0,0);
        spriteBatch.end();
    }
}
