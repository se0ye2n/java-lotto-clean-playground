package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.ManualPurchaseCount;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        PurchaseAmount purchaseAmount = readPurchaseAmount();
        int totalCount = purchaseAmount.calculateLottoCount();
        ManualPurchaseCount manualCount = readManualCount(totalCount);
        playLotto(purchaseAmount, manualCount, totalCount);
    }

    private void playLotto(
            PurchaseAmount purchaseAmount,
            ManualPurchaseCount manualCount,
            int totalCount
    ) {
        Lottos lottos = purchaseLottos(manualCount, totalCount);
        WinningLotto winningLotto = readWinningLotto();
        printResult(lottos, winningLotto, purchaseAmount);
    }

    private Lottos purchaseLottos(
            ManualPurchaseCount manualCount,
            int totalCount
    ) {
        List<Lotto> manualLottos = readManualLottos(manualCount.getValue());
        int automaticCount = manualCount.calculateAutomaticCount(totalCount);
        Lottos lottos = lottoMachine.purchase(manualLottos, automaticCount);
        printLottos(manualCount.getValue(), automaticCount, lottos);
        return lottos;
    }

    private void printLottos(
            int manualCount,
            int automaticCount,
            Lottos lottos
    ) {
        outputView.printPurchasedLottos(
                manualCount,
                automaticCount,
                lottos
        );
    }

    private WinningLotto readWinningLotto() {
        Lotto winningNumbers = readWinningNumbers();
        return readWinningLotto(winningNumbers);
    }

    private WinningLotto readWinningLotto(Lotto winningNumbers) {
        try {
            return new WinningLotto(
                    winningNumbers,
                    inputView.readBonusNumber()
            );
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return readWinningLotto(winningNumbers);
        }
    }

    private void printResult(
            Lottos lottos,
            WinningLotto winningLotto,
            PurchaseAmount purchaseAmount
    ) {
        WinningStatistics statistics =
                lottos.createStatistics(winningLotto);

        outputView.printStatistics(statistics, purchaseAmount);
    }

    private PurchaseAmount readPurchaseAmount() {
        try {
            return new PurchaseAmount(inputView.readPurchaseAmount());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return readPurchaseAmount();
        }
    }

    private ManualPurchaseCount readManualCount(int totalCount) {
        try {
            int count = inputView.readManualPurchaseCount();
            return new ManualPurchaseCount(count, totalCount);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return readManualCount(totalCount);
        }
    }

    private List<Lotto> readManualLottos(int count) {
        try {
            return inputView.readManualLottos(count);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return readManualLottos(count);
        }
    }

    private Lotto readWinningNumbers() {
        try {
            return inputView.readWinningNumbers();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return readWinningNumbers();
        }
    }
}