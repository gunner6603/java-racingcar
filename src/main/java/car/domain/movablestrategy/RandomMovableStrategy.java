package car.domain.movablestrategy;

import utils.random.RandomGenerator;

public class RandomMovableStrategy implements MovableStrategy {

    private static final int MOVE_THRESHOLD = 4;

    private final RandomGenerator randomGenerator;

    public RandomMovableStrategy(final RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public boolean isMovable() {
        if (randomGenerator.extractRandomSingleDigit() >= MOVE_THRESHOLD) {
            return true;
        }
        return false;
    }
}
