package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000; // 로또 한 장
    private static final int START_NUMBER = 1; // 1부터
    private static final int END_NUMBER = 45; // 45까지의 로또 번호 생성
    private static final int LOTTO_NUMBER_COUNT = 6; // 로또 한 장에 들어가는 숫자 개수

    // 구매 수량 계산
    public static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE; // 구매 금액 / 로또 가격
    }

    // 여러 장 구매
    public static List<Lotto> buyLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>(); // 빈 목록 만듬

        for (int count = 0; count < lottoCount; count++) { // 구매 수량만큼 반복
            lottos.add(createLotto()); // 로또 한 장 생성 뒤 lottos에 추가
        }
        return lottos; // 모든 로또 반환
    }

    // 로또 한 장 생성
    private static Lotto createLotto() {
        List<Integer> numbers = createNumbers(); // 1부터 45까지 숫자가 담긴 목록 만듬(제네릭 컬렉션!)
        Collections.shuffle(numbers); // 순서 섞기> 중복 없는 번호 6개

        List<Integer> selectedNumbers = new ArrayList<>(numbers.subList(0, LOTTO_NUMBER_COUNT)); // 섞인 숫자 앞 6개 가져옴
        Collections.sort(selectedNumbers); // 오름차순 정렬
        return new Lotto(selectedNumbers); // 정렬된 숫자 6개로 Lotto객체 만들고 반환
    }

    // 1부터 45까지 생성
    private static  List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>(); // 빈 목록

        for (int number = START_NUMBER; number <= END_NUMBER; number++) { // number를 1부터 45까지 하나씩 증가
            numbers.add(number); // 현재 숫자를 리스트에 넣음
        }
        return numbers; // 완성된 숫자 목록 반환
    }
}
