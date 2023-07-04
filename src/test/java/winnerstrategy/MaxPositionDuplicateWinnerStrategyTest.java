package winnerstrategy;

import static org.assertj.core.api.Assertions.assertThat;

import car.Car;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class MaxPositionDuplicateWinnerStrategyTest {

    @Test
    void test1() {
        List<Car> cars = List.of(
            new Car(3, "a"),
            new Car(5, "b"),
            new Car(5, "c")
        );

        WinnerStrategy winnerStrategy = new MaxPositionDuplicateWinnerStrategy();
        List<Car> winners = winnerStrategy.getWinners(cars);

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.stream().map(Car::getName).collect(Collectors.toList()))
            .containsExactly("b", "c");
    }
}