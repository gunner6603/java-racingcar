package car.domain.movablestrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.random.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovableStrategyTest {

    @Test
    @DisplayName("랜덤값이 4 이상이면 움직인다.")
    void movable() {
        final RandomMovableStrategy randomMovableStrategy = new RandomMovableStrategy(new RandomGenerator() {
            @Override
            public int extractRandomSingleDigit() {
                return 4;
            }
        });
        assertThat(randomMovableStrategy.isMovable()).isTrue();
    }

    @Test
    @DisplayName("랜덤값이 4 미만이면 움직이지 않는다.")
    void notMovable() {
        final RandomMovableStrategy randomMovableStrategy = new RandomMovableStrategy(new RandomGenerator() {
            @Override
            public int extractRandomSingleDigit() {
                return 3;
            }
        });
        assertThat(randomMovableStrategy.isMovable()).isFalse();
    }
}