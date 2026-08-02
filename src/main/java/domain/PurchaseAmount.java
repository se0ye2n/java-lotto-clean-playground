package lotto.domain;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1_000;

    private final int value;

    public PurchaseAmount(int value) {
        validateMinimum(value);
        validateUnit(value);
        this.value = value;
    }

    private void validateMinimum(int value) {
        if (value < LOTTO_PRICE) {
            throw new IllegalArgumentException(
                    "[ERROR] 구입 금액은 1,000원 이상이어야 합니다."
            );
        }
    }

    private void validateUnit(int value) {
        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(
                    "[ERROR] 구입 금액은 1,000원 단위여야 합니다."
            );
        }
    }

    public int calculateLottoCount() {
        return value / LOTTO_PRICE;
    }

    public int getValue() {
        return value;
    }
}