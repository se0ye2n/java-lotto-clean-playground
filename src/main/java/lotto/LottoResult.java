package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> rankCounts; // 각 등수별 당첨 개수 저장
    private final PurchaseAmount purchaseAmount;

    private LottoResult(PurchaseAmount purchaseAmount) {
        this.rankCounts = createRankCounts();
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoResult create(
            List<Lotto> lottos,
            Lotto winningLotto,
            PurchaseAmount purchaseAmount
    ) {
        LottoResult result = new LottoResult(purchaseAmount);
        lottos.forEach(lotto -> result.record(lotto, winningLotto)); // 구매한 로또 하나씩 꺼내 당첨 결과 기록
        return result;
    }

    private Map<Rank, Integer> createRankCounts() {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        Rank.availableRanks().forEach(rank -> rankCounts.put(rank, 0)); // 모든 당첨 등수의 초기 개수 0으로 저장
        return rankCounts;
    }

    private void record(Lotto lotto, Lotto winningLotto) {
        long matchCount = lotto.countMatchingNumbers(winningLotto); // 현재 로또와 당첨 번호 몇 개 일치하는지 계산
        Rank rank = Rank.findByMatchCount(matchCount); // 일치 개수 이용해 당첨 등수 찾음
        recordRank(rank);
    }

    private void recordRank(Rank rank) {
        if (rank == Rank.NONE) { // 당첨X> 종료
            return;
        }
        rankCounts.put(rank, rankCounts.get(rank) + 1); // 해당 등수의 기존 당첨 개수+1해 저장
    }

    public int getCount(Rank rank) {
        return rankCounts.get(rank);
    }

    public long totalPrize() {
        return Rank.availableRanks().stream()
                .mapToLong(rank -> rank.getPrize() * getCount(rank)) // 각 등수의 당첨금 X 당첨 횟수
                .sum(); // 모든 등수의 당첨금 합산
    }

    public double profitRate() {
        return purchaseAmount.profitRate(totalPrize());
    }
}