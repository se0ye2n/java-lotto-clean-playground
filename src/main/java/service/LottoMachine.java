package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lottos purchase(
            List<Lotto> manualLottos,
            int automaticCount
    ) {
        List<Lotto> purchasedLottos = new ArrayList<>(manualLottos);
        purchasedLottos.addAll(createAutomaticLottos(automaticCount));
        return new Lottos(purchasedLottos);
    }

    private List<Lotto> createAutomaticLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> createAutomaticLotto())
                .collect(Collectors.toList());
    }

    private Lotto createAutomaticLotto() {
        List<Integer> numbers = createNumberCandidates();
        Collections.shuffle(numbers);
        return new Lotto(toLottoNumbers(numbers));
    }

    private List<Integer> createNumberCandidates() {
        return IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }
}