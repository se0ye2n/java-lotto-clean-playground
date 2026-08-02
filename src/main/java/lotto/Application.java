package lotto;

public class Application {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = InputView.readPurchaseAmount();
        Lottos lottos = purchaseLottos(purchaseAmount);
        OutputView.printPurchasedLottos(lottos);

        WinningLotto winningLotto = readWinningLotto();
        LottoResult lottoResult = lottos.calculateResult(winningLotto);

        OutputView.printResult(lottoResult, purchaseAmount);
    }

    private static Lottos purchaseLottos(
            PurchaseAmount purchaseAmount
    ) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return Lottos.purchase(purchaseAmount, lottoGenerator);
    }

    private static WinningLotto readWinningLotto() {
        Lotto winningNumbers = InputView.readWinningNumbers();
        LottoNumber bonusNumber = InputView.readBonusNumber();
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}