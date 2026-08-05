package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoMachine {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    public Lottos purchase(
            int automaticCount,
            List<Lotto> manualLottos
    ) {
        List<Lotto> purchasedLottos = new ArrayList<>(manualLottos);
        purchasedLottos.addAll(createAutomaticLottos(automaticCount));

        return new Lottos(purchasedLottos);
    }

    private List<Lotto> createAutomaticLottos(int count) {
        List<Lotto> automaticLottos = new ArrayList<>();

        for (int index = 0; index < count; index++) {
            automaticLottos.add(createAutomaticLotto());
        }
        return automaticLottos;
    }

    private Lotto createAutomaticLotto() {
        List<Integer> numbers = createNumberPool();
        Collections.shuffle(numbers);

        return new Lotto(
                new ArrayList<>(numbers.subList(0, LOTTO_NUMBER_COUNT))
        );
    }

    private List<Integer> createNumberPool() {
        List<Integer> numbers = new ArrayList<>();

        for (int number = MINIMUM_NUMBER;
             number <= MAXIMUM_NUMBER;
             number++) {
            numbers.add(number);
        }
        return numbers;
    }
}
