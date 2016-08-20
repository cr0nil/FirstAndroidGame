package Service;

import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

import java.util.concurrent.TimeUnit;

/**
 * Created by Karol on 14.08.2016.
 */
public class PassiveIncomeService {
    private ScoreService scoreService;
    private int pointsToAdd;
    private final static int INFINITE = 100000000;

    public PassiveIncomeService(ScoreService scoreService) {
        this.scoreService = scoreService;
        calculateGaindPassiveIncome();
    }

    public void start() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                scoreService.addPoints(scoreService.getPasssivIncome());
            }
        }, 1, 1, INFINITE);
    }

    private void calculateGaindPassiveIncome() {
        long savedTimestamp = scoreService.getSavedTimestamp();
        if (savedTimestamp > 0) {
            long milisPassed = TimeUtils.timeSinceMillis(savedTimestamp);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(milisPassed);
            addPointsBasedOnPassedTime(seconds);

        }
    }

    private void addPointsBasedOnPassedTime(long seconds) {//dodawnie pkt na podstawie przekazywania czasu
        if (seconds > 0) {
            pointsToAdd = (int) (seconds * scoreService.getPasssivIncome());
            pointsToAdd = pointsToAdd / 5;
            scoreService.addPoints(pointsToAdd);
        }
    }
    public int getPointsToAdd(){
        return pointsToAdd;
    }
}
