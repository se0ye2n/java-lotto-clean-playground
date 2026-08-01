package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    // 무작위 로또 한 장 생성
    public Lotto generate() {
        List<LottoNumber> numbers = createAllNumbers(); // 1부터 45까지의 모든 로또 번호 만들어 리스트 저장
        Collections.shuffle(numbers); // 번호 리스트의 순서 무작위로 섞기
        return new Lotto(numbers.subList(0, LOTTO_NUMBER_COUNT)); // 무작위로 섞은 번호 중 앞에서부터 6개만 가져옴
    }

    private List<LottoNumber> createAllNumbers() {
        return new ArrayList<>(IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER) // 수정 가능한 ArrayList로 다시 복사
                .mapToObj(LottoNumber::new) // 각 정수를  LottoNumber객체로 변환
                .toList()); // 변환한 LottoNumber들을 리스트로 만듬
    }
}