package com.firstx.cos.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.firstx.cos.Piersi;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = Piersi.GAME_NAME;
        config.width = Piersi.WIDTH;
        config.height = Piersi.HEIGHT;
        config.resizable = false;
        new LwjglApplication(new Piersi(), config);
    }
}
