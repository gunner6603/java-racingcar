package car.domain.winnerstrategy;

import static org.assertj.core.api.Assertions.assertThat;

import car.domain.Car;
import car.domain.Name;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaxPositionDuplicateWinnerStrategyTest {

    final WinnerStrategy winnerStrategy = new MaxPositionDuplicateWinnerStrategy();

    @Test
    @DisplayName("position 값이 가장 큰 자동차를 우승자로 선출한다.")
    void maxPositionWinner() {
        final List<Car> cars = List.of(
            new Car(3, "a"),
            new Car(5, "b"),
            new Car(5, "c")
        );

        final List<Car> winners = winnerStrategy.selectWinners(cars);
        final List<Name> winnerNames = winners.stream()
            .map(Car::getName)
            .collect(Collectors.toList());

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winnerNames).containsExactly(new Name("b"), new Name("c"));
    }
}
