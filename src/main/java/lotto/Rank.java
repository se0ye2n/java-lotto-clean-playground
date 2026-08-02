package lotto;

import java.util.Arrays;

// enum: 정해진 종류의 값 관리할 때 사용
public enum Rank {

    FIRST(6, false, 2_000_000_000, "6개 일치 (2000000000원)"), // 1등 정보: 당첨 번호 6개 일치, 보너스 번호 판단 필요X, 당첨금 20억
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30000000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1500000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50000원)"),
    FIFTH(3, false, 5000, "3개 일치 (5000원)"),
    MISS(0, false, 0, "낙첨");

    private final int matchCount;
    private final boolean bonusRequired;
    private final int prize;
    private final String description;

    Rank(
            int matchCount,
            boolean bonusRequired,
            int prize,
            String description
    ) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
        this.description = description;
    }

    // 번호 일치 개수와 보너스 번호 일치 여부 이용해 등수 찾음
    public static Rank find(int matchCount, boolean bonusMatched) {
        return Arrays.stream(values()) // Rank에 정의된 모든 등수 확인
                .filter(rank -> rank.matches(matchCount, bonusMatched)) // 입력받은 조건과 일치하는 등수만 남김
                .findFirst() // 조건에 맞는 첫 번째 등수 가져옴
                .orElse(MISS); // 없을 시 낙첨 반환
    }

    private boolean matches(int matchCount, boolean bonusMatched) {
        if (this.matchCount != matchCount) { // 해당 등수의 번호 일치 개수와 실제 번호 일치 개수 다를시
            return false; // false반환(else 사용X)
        }

        return bonusRequired == bonusMatched || matchCount == 6; // 같을 시 보너스 번호 조건 검사
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}