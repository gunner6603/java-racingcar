package car.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("a");
    }

    @Test
    @DisplayName("움직이는 것이 가능하면 1칸 전진한다.")
    void move() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("움직이는 것이 불가능하면 움직이지 않는다.")
    void stop() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 리스트를 받아 가장 큰 position을 반환한다.")
    void calculateMaxPosition() {
        final List<Car> cars = List.of(new Car(3, "a"), new Car(5, "b"), new Car(1, "c"));
        final int maxPosition = Car.calculateMaxPosition(cars);
        assertThat(maxPosition).isEqualTo(5);
    }
}
