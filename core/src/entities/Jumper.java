package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Karol on 17.07.2016.
 */
public class Jumper extends Image {

    private fianl static int WIDHT = 70;
    private fianl static int HEIGHT = 100;

    private fianl static int STARTING_X = 0;
    private fianl static int STARTING_Y = 0;

    public Jumper() {
        super(new Texture("plik.png"));

        this.setOrigin(WIDHT/2,HEIGHT/2);
        this.setSize(WIDHT,HEIGHT);
        this.setPosition(STARTING_X,STARTING_Y);
    }

    public Texture getTextura() {
        return textura;
    }
}
