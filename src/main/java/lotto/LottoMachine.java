package lotto;

import java.util.ArrayList;
import java.util.List;

// 구입 금액에 맞게 로또 구매
public class LottoMachine {

    private final PurchaseAmount purchaseAmount; // 구입 금액
    private final LottoGenerator lottoGenerator; // 로또 번호 생성

    public LottoMachine(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount; // 생성자로 전달받은 구입 금액 필드에 저장
        this.lottoGenerator = new LottoGenerator(); // 무작위 로또 생성할 객체 만듬
    }

    public List<Lotto> buy() {
        List<Lotto> lottos = new ArrayList<>(); // 구매한 로또들 저장할 빈 리스트 만듬

        for (int count = 0; count < purchaseAmount.lottoCount(); count++) { // 구입 가능한 로또 개수만큼 반복
            lottos.add(lottoGenerator.generate()); // 무작위 로또 한 장 생성해 리스트에 추가
        }

        return lottos; // 모든 구매 끝난 후 구매한 로또 리스트 반환
    }
}