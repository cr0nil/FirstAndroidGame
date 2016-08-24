package screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.firstx.cos.Piersi;

import Controllers.GameScreenController;
import UserInterface_UI.IClickCallback;
import UserInterface_UI.PlayButton;

/**
 * Created by Karol on 22.08.2016.
 */
public class MenuScreen extends AbstractScreen {
    private PlayButton playButton;
    private Texture background;
    public MenuScreen(GameScreenController gsc) {
        super(gsc);
        background = new Texture("123.png");

    }
//    @Override
//    public void init(){
//        initPlayButton();
//    }
    @Override
    public void handleInput() {
        playButton = new PlayButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.setScreen(new GameplayScreen(game));
//                game.getScoreService().restGameScore();
            }
        });
        stage.addActor(playButton);
    }
//    private void initPlayButton() {
//
//    }

    @Override
    public void update(float dt) {
handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, Piersi.WIDTH,Piersi.HEIGHT);
        sb.end();

    }

}
