package car.domain;

import car.domain.movablestrategy.MovableStrategy;
import car.domain.movablestrategy.RandomMovableStrategy;
import car.domain.winnerstrategy.WinnerStrategy;
import utils.random.RandomGenerator;

import java.util.List;

public class CarRacingGame {

    private final Cars cars;
    private int leftPlayCount;
    private final MovableStrategy movableStrategy;

    public CarRacingGame(final List<String> carNames, final int playCount, final MovableStrategy movableStrategy) {
        this.cars = new Cars(carNames);
        validatePositive(playCount);
        this.leftPlayCount = playCount;
        this.movableStrategy = movableStrategy;
    }

    public static CarRacingGame createDefault(final List<String> carNames, final int playCount) {
        return new CarRacingGame(carNames, playCount, new RandomMovableStrategy(new RandomGenerator()));
    }

    public void playRaceOnce() {
        if (isFinished()) {
            throw new IllegalStateException("남은 실행 횟수가 0이므로 더 이상 실행할 수 없습니다.");
        }

        cars.move(movableStrategy);
        leftPlayCount--;
    }

    public List<String> formatCars(final CarFormatter formatter) {
        return cars.format(formatter);
    }

    public List<Name> resolveWinnerNames(final WinnerStrategy winnerStrategy) {
        return cars.resolveWinnerNames(winnerStrategy);
    }

    public boolean isNotFinished() {
        return leftPlayCount > 0;
    }

    private boolean isFinished() {
        return leftPlayCount == 0;
    }

    private void validatePositive(final int playCount) {
        if (playCount <= 0) {
            throw new IllegalArgumentException(String.format("실행 횟수는 양수여야 합니다. 입력한 데이터 : %d", playCount));
        }
    }
}
