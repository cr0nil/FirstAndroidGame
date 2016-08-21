package Controllers;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.firstx.cos.Piersi;

/**
 * Created by Karol on 21.08.2016.
 */
public class RandomEventController {

    private static final int RANDOM_TICK_INTERVAL = 5;
    private Piersi game;
    private Stage stage;
    public RandomEventController(Piersi game, Stage stage) {
        this.game = game;
        this.stage = stage;
        init();
    }

    private void init() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                if (MathUtils.randomBoolean()) {
                    triggerRandomEvent();
                }
            }


        }, RANDOM_TICK_INTERVAL, RANDOM_TICK_INTERVAL);
    }

    private void triggerRandomEvent() {
        int randomNumber = MathUtils.random(1, 2);
        switch (randomNumber) {
            case 1:
                moneyEvent();
                break;
            case 2:
                loseMoneyEvent();
                break;
            case 3:
                gainPassiveIncome();
                break;
            default:
                break;
        }
    }

    private void gainPassiveIncome() {
        game.getScoreService().getPasssivIncome();
    }

    private void loseMoneyEvent() {
        game.getScoreService().addPoints(-120);
    }

    private void moneyEvent() {
        game.getScoreService().addPoints(120);
    }

}
