package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningStatistics {

    private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);

    public WinningStatistics() {
        initialize();
    }

    private void initialize() {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    public void add(Rank rank) {
        int count = results.get(rank);
        results.put(rank, count + 1);
    }

    public int getCount(Rank rank) {
        return results.get(rank);
    }

    public double calculateProfitRate(PurchaseAmount purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        return (double) totalPrize / purchaseAmount.getValue();
    }

    private long calculateTotalPrize() {
        return results.entrySet()
                .stream()
                .mapToLong(this::calculatePrize)
                .sum();
    }

    private long calculatePrize(Map.Entry<Rank, Integer> entry) {
        return entry.getKey().getPrize() * entry.getValue();
    }
}