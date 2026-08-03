package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> values;

    public Lottos(List<Lotto> values) {
        this.values = Collections.unmodifiableList(
                new ArrayList<>(values)
        );
    }

    public List<Lotto> getValues() {
        return new ArrayList<>(values);
    }

    public WinningStatistics createStatistics(WinningLotto winningLotto) {
        WinningStatistics statistics = new WinningStatistics();
        values.forEach(lotto -> addResult(statistics, lotto, winningLotto));
        return statistics;
    }

    private void addResult(
            WinningStatistics statistics,
            Lotto lotto,
            WinningLotto winningLotto
    ) {
        Rank rank = winningLotto.findRank(lotto);
        statistics.add(rank);
    }
}