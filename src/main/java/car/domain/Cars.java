package car.domain;

import car.domain.movablestrategy.MovableStrategy;
import car.domain.winnerstrategy.WinnerStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> list;

    public Cars(final List<String> names) {
        list = names.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public void move(final MovableStrategy movableStrategy) {
        for (Car car : list) {
            car.move(movableStrategy);
        }
    }

    public List<String> format(final CarFormatter formatter) {
        return list.stream()
                .map(car -> car.format(formatter))
                .collect(Collectors.toList());
    }

    public List<Name> resolveWinnerNames(final WinnerStrategy winnerStrategy) {
        return extractNames(winnerStrategy.selectWinners(list));
    }

    private List<Name> extractNames(final List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
