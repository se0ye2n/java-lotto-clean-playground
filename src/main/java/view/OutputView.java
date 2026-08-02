package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

public class OutputView {

    public void printPurchasedLottos(
            int manualCount,
            int automaticCount,
            Lottos lottos
    ) {
        System.out.println();
        printPurchaseCount(manualCount, automaticCount);
        lottos.getValues().forEach(System.out::println);
    }

    private void printPurchaseCount(int manualCount, int automaticCount) {
        System.out.printf(
                "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n",
                manualCount,
                automaticCount
        );
    }

    public void printStatistics(
            WinningStatistics statistics,
            PurchaseAmount purchaseAmount
    ) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRankResults(statistics);
        printProfitRate(statistics, purchaseAmount);
    }

    private void printRankResults(WinningStatistics statistics) {
        printRank("3개 일치 (5000원)", Rank.FIFTH, statistics);
        printRank("4개 일치 (50000원)", Rank.FOURTH, statistics);
        printRank("5개 일치 (1500000원)", Rank.THIRD, statistics);
        printRank("5개 일치, 보너스 볼 일치(30000000원)", Rank.SECOND, statistics);
        printRank("6개 일치 (2000000000원)", Rank.FIRST, statistics);
    }

    private void printRank(
            String message,
            Rank rank,
            WinningStatistics statistics
    ) {
        System.out.printf(
                "%s - %d개%n",
                message,
                statistics.getCount(rank)
        );
    }

    private void printProfitRate(
            WinningStatistics statistics,
            PurchaseAmount purchaseAmount
    ) {
        double profitRate = statistics.calculateProfitRate(purchaseAmount);
        System.out.printf("총 수익률은 %.2f입니다.%n", profitRate);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}