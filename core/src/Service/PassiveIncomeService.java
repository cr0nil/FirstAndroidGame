package Service;

import com.badlogic.gdx.utils.Timer;

/**
 * Created by Karol on 14.08.2016.
 */
public class PassiveIncomeService {
    private ScoreService scoreService;
    private final static int INFINITE = 100000000;
    public PassiveIncomeService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }
    public void start(){
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
              scoreService.addPoints(scoreService.getPasssivIncome());
            }
        },1,1,INFINITE);
    }
}
