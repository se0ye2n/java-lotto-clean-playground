package lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = InputView.readPurchaseAmount(); // InputView에게 구입 금액을 입력 요청
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount); // 입력받은 구입 금액 이용해 로또 판매 기계 만듬
        List<Lotto> lottos = lottoMachine.buy(); // 로또 구매 요청> 구매한 로또들 리스트에 저장

        OutputView.printPurchasedLottos(lottos); // 구매한 로또 개수와 각 로또 번호 출력

        Lotto winningLotto = InputView.readWinningLotto(); // 당첨 결과 계산
        LottoResult result = LottoResult.create(lottos, winningLotto, purchaseAmount);

        OutputView.printResult(result);
    }
}
