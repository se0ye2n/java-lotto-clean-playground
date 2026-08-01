package lotto;

import java.util.List;

// 당첨 등수 표현하는 열거형 선언
public enum Rank {

    THREE_MATCHES(3, 5000), // 번호 3개 일치 시 5000원 받음
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    SIX_MATCHES(6, 2_000_000_000),
    NONE(0, 0); // 3개 미만시 당첨X(else사용X)

    private final int matchCount; // 일치 번호 개수
    private final long prize; // 당첨금

    Rank(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    // 일치 개수 전달받아 해당하는 당첨 등수 찾음
    public static Rank findByMatchCount(long matchCount) {
        return availableRanks().stream() // 당첨 가능한 등수들 하나씩 확인
                .filter(rank -> rank.matchCount == matchCount) // 전달받은 일치 개수와 같은 등수만 남김
                .findFirst() // 조건에 맞는 첫 번째 등수 가져옴
                .orElse(NONE); // 하나도 해당X> NONE(else사용 X)
    }

    public static List<Rank> availableRanks() {
        return List.of(THREE_MATCHES, FOUR_MATCHES, FIVE_MATCHES, SIX_MATCHES);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }
}