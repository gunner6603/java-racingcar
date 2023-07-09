package car.controller;

import car.domain.CarRacingGame;
import car.domain.WinnerPlatform;
import car.domain.winnerstrategy.MaxPositionDuplicateWinnerStrategy;
import car.view.InputView;
import car.view.OutputView;

public class CarRacingController {

    private final WinnerPlatform winnerPlatform = new WinnerPlatform(new MaxPositionDuplicateWinnerStrategy());

    public void playGame() {
        final CarRacingGame game = CarRacingGame.createDefault(InputView.getCarNames(), InputView.getPlayCount());

        OutputView.startPrintingResult();
        while (game.isNotFinished()) {
            game.playRaceOnce();
            OutputView.printCurrentStatus(game);
        }

        OutputView.printWinners(winnerPlatform.announceWinners(game));
    }
}
