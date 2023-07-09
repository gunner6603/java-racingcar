package car.domain;

import car.domain.winnerstrategy.WinnerStrategy;

import java.util.List;

public class WinnerPlatform {

    private final WinnerStrategy winnerStrategy;

    public WinnerPlatform(final WinnerStrategy winnerStrategy) {
        this.winnerStrategy = winnerStrategy;
    }

    public List<Name> announceWinners(final CarRacingGame game) {
        return game.resolveWinnerNames(winnerStrategy);
    }
}