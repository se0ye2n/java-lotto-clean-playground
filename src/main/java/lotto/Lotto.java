package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    // 로또 번호 검증
    private void validate(List<LottoNumber> numbers) {
        validateNumberCount(numbers);
        validateDuplicate(numbers);
    }

    // 번호 개수 6개인지 검사
    private void validateNumberCount(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    // 중복 번호 검사
    private void validateDuplicate(List<LottoNumber> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_NUMBER_COUNT) { // Set은 중복 값 저장X
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    // 현재 로또와 당첨 로또가 몇 개 일치하는지 계산
    public int countMatchingNumbers(Lotto winningLotto) {
        return (int) numbers.stream() // 현재 로또 번호 6개 확인
                .filter(winningLotto::contains) // 각 번호가 당첨 번호에 포함되는 경우만 남김
                .count(); // 남은 번호 개수 세기
    }

    // 현재 로또에 특정 숫자 포함 여부 알려줌
    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers); // 내부 리스트를 직접 반환하지않고 복사해 반환
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}