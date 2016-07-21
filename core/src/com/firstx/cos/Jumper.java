package com.firstx.cos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Karol on 17.07.2016.
 */
public class Jumper extends Rectangle {
    private Texture textura;

    public Jumper(Texture textura) {
        this.textura = textura;
    }

    public Texture getTextura() {
        return textura;
    }
}
