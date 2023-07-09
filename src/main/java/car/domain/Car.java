package car.domain;

import car.domain.movablestrategy.MovableStrategy;

import java.util.List;

public class Car {

    private static final int MOVE_STEP = 1;

    private int position;
    private final Name name;

    public Car(final String name) {
        this(0, name);
    }

    public Car(final int position, final String name) {
        this.position = position;
        this.name = new Name(name);
    }

    public void move(final MovableStrategy movableStrategy) {
        if (movableStrategy.isMovable()) {
            position += MOVE_STEP;
        }
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String format(final CarFormatter carFormatter) {
        return carFormatter.format(this);
    }

    public boolean positionIsEqualTo(final int otherPosition) {
        return this.position == otherPosition;
    }

    public static int calculateMaxPosition(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차 리스트는 비어 있을 수 없습니다."));
    }
}
