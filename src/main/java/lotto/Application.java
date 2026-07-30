package lotto;

import java.util.List;

public class Application {

    public  static void  main(String[] args) { // 시작
        int purchaseAmount = InputView.readPurchaseAmount(); // 입력 받아 달라 요청
        int lottoCount = LottoMachine.calculateLottoCount(purchaseAmount); // 구매 금액으로 로또 구매 수량 계산
        List<Lotto> lottos = LottoMachine.buyLottos(lottoCount); // 로또 만들기

        OutputView.printPurchaseCount(lottoCount); // 구매한 로또 출력
        OutputView.printLottos(lottos);
    }
}
