package lotto;

import java.util.ArrayList;
import java.util.List;


// 일급 컬렉션: 컬렉션 하나만 필드로 가지는 클래스
public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    // 구매 금액에 맞는 로또 목록 생성
    public static Lottos purchase(
            PurchaseAmount purchaseAmount,
            LottoGenerator lottoGenerator
    ) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = purchaseAmount.calculateLottoCount(); // 구매 금액으로 구매할 로또 개수 계산
        generateLottos(lottos, lottoCount, lottoGenerator); // 계산된 개수만큼 로또 생성
        return new Lottos(lottos);
    }

    private static void generateLottos(
            List<Lotto> lottos,
            int lottoCount,
            LottoGenerator lottoGenerator
    ) {
        for (int count = 0; count < lottoCount; count++) { // 0부터 구매 개수보다 작을 때까지 반복
            lottos.add(lottoGenerator.generate()); // 반복할 때마다 랜덤 로또 한 장 생성해 목록에 추가
        }
    }

    // 모든 구매 로또의 당첨 결과 계산
    public LottoResult calculateResult(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult(); // 등수별 당첨 개수 기록할 객체 만듬
        lottos.forEach(lotto -> addResult(lottoResult, winningLotto, lotto)); // 구매한 모든 로또 하나씩 확인
        return lottoResult;
    }

    private void addResult(
            LottoResult lottoResult,
            WinningLotto winningLotto,
            Lotto lotto
    ) {
        Rank rank = winningLotto.findRank(lotto); // 현재 로또 한 장의 당첨 등수 구함
        lottoResult.add(rank); // 구해진 등수의 당첨 개수 1증가시킴
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}