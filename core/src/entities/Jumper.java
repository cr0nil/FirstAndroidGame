package entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Karol on 17.07.2016.
 */
public class Jumper extends Image {

    private final static int WIDHT = 70;
    private final static int HEIGHT = 100;

    private final static int STARTING_X = 200;
    private final static int STARTING_Y = 200;

    public Jumper() {
        super(new Texture("plik.png"));

        this.setOrigin(WIDHT/2,HEIGHT/2);
        this.setSize(WIDHT,HEIGHT);
        this.setPosition(STARTING_X,STARTING_Y);
    }


}
