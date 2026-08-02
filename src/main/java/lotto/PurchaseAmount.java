package lotto;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;

    private final int value; // 구입 금액

    public PurchaseAmount(int value) {
        validate(value);
        this.value = value;
    }

    // 구입 금액이 올바른지 검사
    private void validate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("구입 금액은 0원보다 커야 합니다.");
        }

        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 구매할 수 있는 로또 개수 계산
    public int calculateLottoCount() {
        return value / LOTTO_PRICE;
    }

    public int getValue() {
        return value;
    }
}