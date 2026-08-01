package lotto;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다."); // 구매한 로또 리스트의 크기 이용해 구매 개수 출력
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers())); // 구매한 로또 하나씩 출력
    }

    public static void printResult(LottoResult result) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRankCounts(result);
        System.out.printf("총 수익률은 %.2f입니다.%n", result.profitRate()); // 총수익률 소수점 둘째 자리까지 출력
    }

    // // 각 등수별 당첨 개수 출력
    private static void printRankCounts(LottoResult result) {
        Rank.availableRanks().forEach(rank -> printRank(result, rank)); // 일치 등수 하나씩 꺼내 출력
    }

    private static void printRank(LottoResult result, Rank rank) {
        System.out.printf(
                "%d개 일치 (%d원)- %d개%n",
                rank.getMatchCount(),
                rank.getPrize(),
                result.getCount(rank)
        );
    }
}
