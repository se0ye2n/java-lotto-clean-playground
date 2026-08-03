package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    private final int matchingCount;
    private final boolean bonusRequired;
    private final long prize;

    Rank(int matchingCount, boolean bonusRequired, long prize) {
        this.matchingCount = matchingCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
    }

    public static Rank find(int matchingCount, boolean bonusMatched) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(matchingCount, bonusMatched))
                .findFirst()
                .orElse(MISS);
    }

    private boolean matches(int count, boolean bonusMatched) {
        if (this == SECOND) {
            return count == matchingCount && bonusMatched;
        }
        if (this == THIRD) {
            return count == matchingCount && !bonusMatched;
        }
        return count == matchingCount;
    }

    public long getPrize() {
        return prize;
    }
}