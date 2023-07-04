package client;

import car.Car;
import carracingfield.CarRacingField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import validator.StringNameValidator;
import winnerstrategy.MaxPositionDuplicateWinnerStrategy;

public class CarRacingGame {

    private static List<String> names;
    private static int count;

    public static void main(String[] args) {

        getUserInput();
        validateCarNames();
        printWinners(playAndSelectWinners());
    }

    private static void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String name =  scanner.nextLine();
        names = Arrays.asList(name.split(","));
        System.out.println("시도할 횟수는 몇 회인가요?");
        count = scanner.nextInt();
    }

    private static void validateCarNames() {
        names.forEach(StringNameValidator::validate);
    }

    private static List<Car> playAndSelectWinners() {
        CarRacingField carRacingField = new CarRacingField(
            names,
            new MaxPositionDuplicateWinnerStrategy()
        );
        System.out.println("\n실행 결과");
        carRacingField.moveCarsByCount(count);
        return carRacingField.getWinners();
    }

    private static void printWinners(List<Car> winners) {
        String winnerString = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));
        System.out.println(winnerString + "가 최종 우승했습니다.");
    }
}