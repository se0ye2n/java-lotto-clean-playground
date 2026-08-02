package lotto;

public class OutputView {

    private OutputView() {
    }

    public static void printPurchasedLottos(Lottos lottos) {
        System.out.println();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.getLottos().forEach(System.out::println);
    }

    public static void printResult(
            LottoResult lottoResult,
            PurchaseAmount purchaseAmount
    ) {
        printResultHeader();
        printRankResults(lottoResult);
        printProfitRate(lottoResult, purchaseAmount);
    }

    private static void printResultHeader() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void printRankResults(LottoResult lottoResult) {
        printRank(lottoResult, Rank.FIFTH);
        printRank(lottoResult, Rank.FOURTH);
        printRank(lottoResult, Rank.THIRD);
        printRank(lottoResult, Rank.SECOND);
        printRank(lottoResult, Rank.FIRST);
    }

    private static void printRank(
            LottoResult lottoResult,
            Rank rank
    ) {
        int count = lottoResult.getCount(rank);
        System.out.println(rank.getDescription() + " - " + count + "개");
    }

    private static void printProfitRate(
            LottoResult lottoResult,
            PurchaseAmount purchaseAmount
    ) {
        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        System.out.printf("총 수익률은 %.2f입니다.%n", profitRate);
    }
}
