package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void createWinningLottoWithDuplicateBonusNumber() {
        Lotto lotto = new Lotto(
                List.of(1, 2, 3, 4, 5, 6)
        );

        assertThatThrownBy(
                () -> new WinningLotto(
                        lotto,
                        LottoNumber.from(6)
                )
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void determineSecondRank() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                LottoNumber.from(7)
        );

        Lotto purchasedLotto = new Lotto(
                List.of(1, 2, 3, 4, 5, 7)
        );

        assertThat(winningLotto.determineRank(purchasedLotto))
                .isEqualTo(Rank.SECOND);
    }

    @Test
    void determineFirstRank() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                LottoNumber.from(7)
        );

        Lotto purchasedLotto = new Lotto(
                List.of(1, 2, 3, 4, 5, 6)
        );

        assertThat(winningLotto.determineRank(purchasedLotto))
                .isEqualTo(Rank.FIRST);
    }

    @Test
    void determineThirdRank() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                LottoNumber.from(7)
        );

        Lotto purchasedLotto = new Lotto(
                List.of(1, 2, 3, 4, 5, 8)
        );

        assertThat(winningLotto.determineRank(purchasedLotto))
                .isEqualTo(Rank.THIRD);
    }
}
