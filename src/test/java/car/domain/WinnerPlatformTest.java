package car.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerPlatformTest {

    @Test
    @DisplayName("WinnerStrategy에 기반해서 우승자 이름 리스트를 반환한다.")
    void returnWinnerNames() {
        final CarRacingGame game = CarRacingGame.createDefault(List.of("a", "b", "c"), 1);
        final WinnerPlatform winnerPlatform = new WinnerPlatform(cars -> List.of(new Car("a"), new Car("b")));
        assertThat(winnerPlatform.announceWinners(game)).containsExactly(new Name("a"), new Name("b"));
    }
}