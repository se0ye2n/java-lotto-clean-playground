package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6; // 로또 한 장에 반드시 6개의 번호

    private final List<LottoNumber> numbers; // 로또 번호들 저장하는 컬렉션

    public Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = new ArrayList<>(numbers); // 외부에서 전달된 리스트 새로운 리스트로 복사
        this.numbers.sort(LottoNumber::compareTo); // 로또 번호 오름차순 정렬
    }

    // 입력된 로또 번호 6개인지 확인
    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    // 중복된 번호 확인
    private void validateDuplicate(List<LottoNumber> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) { // 리스트를 HashSet으로 변환> 중복 제거한 Set의 크기와 원래 크기 다를 시 중복 번호 존재
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    // 현재 로또와 당첨 로또가 몇 개 일치하는지 계산
    public long countMatchingNumbers(Lotto winningLotto) {
        return numbers.stream() // 현재 로또 번호들을 하나씩 처리하는 스트림 만듬
                .filter(winningLotto::contains) // 현재 번호 중 당첨 로또에 포함된 번호만 남김
                .count();
    }

    private boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return List.copyOf(numbers); // 복사된 읽기 전용 리스트 반환(외부에서 로또 번호 수정X)
    }
}