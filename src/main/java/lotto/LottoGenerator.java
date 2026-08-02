package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    // 랜덤 로또 한 장 생성
    public Lotto generate() {
        List<LottoNumber> numberPool = createNumberPool();
        Collections.shuffle(numberPool); // 정렬돼있던 번호의 순서 섞음
        return createLotto(numberPool); // 섞인 번호 중 6개를 골라 로또 만듬
    }

    // 1부터 45까지의 번호 들어 있는 목록 만듬
    private List<LottoNumber> createNumberPool() {
        return IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER) // 1부터 45까지의 숫자 생성
                .mapToObj(LottoNumber::new) // 각 정수를 LottoNumber객체로 변환
                .collect(Collectors.toList());
    }

    private Lotto createLotto(List<LottoNumber> numberPool) {
        List<LottoNumber> numbers = new ArrayList<>(
                numberPool.subList(0, LOTTO_NUMBER_COUNT) // 섞인 목록의 0번째부터 6개 가져옴
        );

        return new Lotto(numbers); // subList결과를 새로운 리스트로 복사
    }
}