package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.firstx.cos.Piersi;

import UserInterface_UI.IClickCallback;
import UserInterface_UI.PlayButton;

/**
 * Created by Karol on 22.08.2016.
 */
public class MenuScreen extends AbstractScreen {
    private PlayButton playButton;
    private Image background;


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
        stage.addActor(playButton);
        PlayMusicWelcome();
    }
    @Override
    public void init(){
        background=new Image(new Texture("123.png"));
        stage.addActor(background);
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }
    private void PlayMusicWelcome() {
        game.getSoundService().PlayMusicWelcome();
    }
}
