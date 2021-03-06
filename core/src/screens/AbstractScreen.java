package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.firstx.cos.Piersi;

/**
 * Created by Karol on 27.07.2016.
 */
public abstract class AbstractScreen implements Screen {
    protected Piersi game;
    protected Stage stage;
    private OrthographicCamera camera;
    protected SpriteBatch spriteBatch;
    protected Vector3 mouse;


    public AbstractScreen(Piersi game) {
        this.game = game;
        createCamera();
        stage = new Stage(new StretchViewport(Piersi.WIDTH,Piersi.HEIGHT,camera));
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        init();
    }

    protected abstract void init();

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Piersi.WIDTH, Piersi.HEIGHT);
        camera.update();
    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose(){
        game.dispose();
    }
    @Override
    public void hide(){}
    @Override
    public void resize(int width,int height){

    }



}
