package lotto;

import java.util.List;

public class OutputView {

    // 구매한 로또 개수 출력
    public static void printPurchaseCount(int lottoCount) {
        System.out.println(); // 빈 줄 출력
        System.out.println(lottoCount + "개를 구매하였습니다."); // 구매 수량 출력
    }

    // 구매한 모든 로또 출력
    public  static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) { // lottos에 들어 있는 로또 한 장씩 꺼냄
            System.out.println(lotto.getNumbers()); // 현재 로또의 번호 가져와 출력
        }
    }
}
