package car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarRacingGameTest {

    @Test
    @DisplayName("게임 실행 횟수는 양수이다.")
    void positivePlayCount() {
        assertThatNoException()
                .isThrownBy(() -> new CarRacingGame(List.of("a", "b"), 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("게임 실행 횟수는 0 또는 음수일 수 없다.")
    void negativePlayCount(final int playCount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarRacingGame(List.of("a", "b"), playCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 8})
    @DisplayName("게임은 입력한 실행 횟수만큼 실행할 수 있다.")
    void repeatedlyPlayRace(final int playCount) {
        final CarRacingGame game = new CarRacingGame(List.of("a", "b"), playCount);
        assertThatNoException().isThrownBy(() -> repeatedlyPlayRace(game, playCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 8})
    @DisplayName("게임은 입력한 실행 횟수를 초과해서 실행하면 예외를 발생시킨다.")
    void raceMoreThanPlayCountTimes(int playCount) {
        final CarRacingGame game = new CarRacingGame(List.of("a", "b"), playCount);
        repeatedlyPlayRace(game, playCount);

        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> game.playRaceOnce());
    }

    @Test
    @DisplayName("게임은 현재 자동차 상태를 포매팅된 문자열 리스트로 반환한다.")
    void formatCars() {
        final CarRacingGame game = new CarRacingGame(List.of("a", "b"), 1);
        final CarFormatter simpleFormatter = car -> car.getName() + "/" + car.getPosition();
        assertThat(game.formatCars(simpleFormatter)).isEqualTo(List.of("a/0", "b/0"));
    }

    private void repeatedlyPlayRace(final CarRacingGame game, final int playCount) {
        for (int i = 0; i < playCount; i++) {
            game.playRaceOnce();
        }
    }
}