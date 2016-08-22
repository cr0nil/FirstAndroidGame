package Controllers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

import screens.AbstractScreen;

/**
 * Created by Karol on 22.08.2016.
 */
public class GameScreenController {
    private Stack<AbstractScreen> screens;

    public GameScreenController() {
        screens = new Stack<AbstractScreen>();
    }
    public void push(AbstractScreen screen){
        screens.push(screen);
    }
    public  void pop(){
        screens.pop();
    }

    public void set(AbstractScreen screen) {
        screens.pop();
        screens.push(screen);

    }
    public void update(float dt){
        screens.peek().update(dt);

    }
    public void render(SpriteBatch spriteBatch){
        screens.peek().render(spriteBatch);

    }
}
