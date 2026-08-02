package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> result; // 각 등수별 당첨 개수 저장

    public LottoResult() {
        this.result = new EnumMap<>(Rank.class); // 키가 enum시 Map사용
        initialize();
    }

    // 각 등수의 초기 당첨 개수 0으로 설정
    private void initialize() {
        for (Rank rank : Rank.values()) { // 모든 등수 하나씩 가져와
            result.put(rank, 0); // 각 등수의 당첨 개수 0으로 저장
        }
    }

    // 특정 등수의 당첨 개수 1증가
    public void add(Rank rank) {
        result.put(rank, result.get(rank) + 1); // 현재 저장된 개수 가져온 뒤 1더해 다시 저장
    }

    public int getCount(Rank rank) {
        return result.get(rank);
    }

    // 모든 등수의 당첨금 더해 총 당첨금 계산
    public long calculateTotalPrize() {
        return result.entrySet()
                .stream()
                .mapToLong(this::calculatePrize) // 각 등수의 당첨금 X 해당 등수의 당첨 개수
                .sum(); // 계산한 모든 당첨금 합침
    }
    
    private long calculatePrize(Map.Entry<Rank, Integer> entry) {
        long prize = entry.getKey().getPrize();
        int count = entry.getValue();
        return prize * count;
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        double totalPrize = calculateTotalPrize();
        return totalPrize / purchaseAmount.getValue(); // 총 당첨금을 구매 금액으로 나눠 수익률 계산
    }
}