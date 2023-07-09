package car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("자동차를 한꺼번에 이동시킨다.")
    void moveAllCars() {
        final Cars cars = new Cars(List.of("a", "b"));
        cars.move(() -> true);
        assertThat(cars.format(car -> "name : " + car.getName() + ", position : " + car.getPosition()))
                .containsExactly("name : a, position : 1", "name : b, position : 1");
    }

    @Test
    @DisplayName("WinnerStrategy 객체를 받아 우승자 이름을 반환한다.")
    void returnWinnerNames() {
        final Cars cars = new Cars(List.of("a", "b", "c"));
        final List<Name> names = cars.resolveWinnerNames(carList -> List.of(new Car("a"), new Car("b")));
        assertThat(names).containsExactly(new Name("a"), new Name("b"));
    }
}