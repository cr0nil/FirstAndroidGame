package Controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.firstx.cos.Piersi;

import entities.FlyingObject;

/**
 * Created by Karol on 12.08.2016.
 */
public class FlyingObjController {
    public int spawnTime;

    public FlyingObjController(Piersi game, Stage stage) {
        init(game, stage);
    }

    private void init(final Piersi game, final Stage stage) {
        randomizeSpawnTime();
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        addRandomFlyingObjToStage(game, stage);
                        randomizeSpawnTime();

                    }


                }, spawnTime);
            }
        }, 0, 5);
    }

    private void randomizeSpawnTime() {
        spawnTime = MathUtils.random(3, 6);
    }

    private void addRandomFlyingObjToStage(Piersi game, Stage stage) {
        FlyingObject flyingObject = null;
        if (MathUtils.randomBoolean()) {
            flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.TITS, game);
        } else {
            flyingObject = new FlyingObject(FlyingObject.FlyingObjectType.PASSIVE, game);
        }
        stage.addActor(flyingObject);
        flyingObject.fly();
        //if(flyingObject.overlaps(Piersi.WIDTH))
    }

}
