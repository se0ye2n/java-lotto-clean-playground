package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 6개여야 합니다."
            );
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 중복될 수 없습니다."
            );
        }
    }

    private List<LottoNumber> sortNumbers(List<LottoNumber> numbers) {
        List<LottoNumber> copiedNumbers = new ArrayList<>(numbers);
        Collections.sort(copiedNumbers);
        return Collections.unmodifiableList(copiedNumbers);
    }

    public int countMatchingNumbers(LottoNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
