package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> numbers) {
        this.lottoNumbers = new LottoNumbers(convert(numbers));
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    private static List<LottoNumber> convert(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    public int countMatchingNumbers(Lotto winningLotto) {
        return lottoNumbers.countMatchingNumbers(
                winningLotto.lottoNumbers
        );
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
