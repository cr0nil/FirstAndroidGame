package UserInterface_UI;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Karol on 05.08.2016.
 */
public class PointsLabel extends Label {
    public PointsLabel(){
        super("",prepareLabelSytyle());
        init();
    }

    private void init() {
        this.setX(370);
        this.setY(660);
    }

    private static LabelStyle prepareLabelSytyle() {
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = new BitmapFont();
        return labelStyle;
    }
}
