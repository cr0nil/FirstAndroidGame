package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.firstx.cos.Piersi;

import Controllers.GameScreenController;

/**
 * Created by Karol on 27.07.2016.
 */
public abstract class AbstractScreen {
    protected Piersi game;
    protected Stage stage;
    private OrthographicCamera camera;
    protected SpriteBatch sb;
    protected Vector3 mouse;
    protected GameScreenController gsc;

    public AbstractScreen(Piersi game) {
        this.game = game;
        createCamera();
        stage = new Stage(new StretchViewport(Piersi.WIDTH,Piersi.HEIGHT,camera));
        sb = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        init();
    }
    public AbstractScreen(GameScreenController gsc){
        this.gsc = gsc;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,240,400);
    }

    protected abstract void init();


    public OrthographicCamera getCamera() {
        return camera;
    }

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Piersi.WIDTH, Piersi.HEIGHT);
        camera.update();
    }

    public abstract void render(SpriteBatch sb) ;


//    @Override
//    public void pause() {
//        game.setPaused(true);
//    }



    public abstract void update(float dt);
    public abstract void handleInput();

}
