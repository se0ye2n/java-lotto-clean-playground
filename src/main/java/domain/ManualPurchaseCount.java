package lotto.domain;

public class ManualPurchaseCount {

    private final int value;

    public ManualPurchaseCount(int value, int totalCount) {
        validatePositive(value);
        validateMaximum(value, totalCount);
        this.value = value;
    }

    private void validatePositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(
                    "[ERROR] 수동 구매 개수는 0개 이상이어야 합니다."
            );
        }
    }

    private void validateMaximum(int value, int totalCount) {
        if (value > totalCount) {
            throw new IllegalArgumentException(
                    "[ERROR] 수동 구매 개수는 전체 구매 개수를 넘을 수 없습니다."
            );
        }
    }

    public int calculateAutomaticCount(int totalCount) {
        return totalCount - value;
    }

    public int getValue() {
        return value;
    }
}