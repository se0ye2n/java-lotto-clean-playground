package lotto;

public class PurchaseAmount {

    private  static final int LOTTO_PRICE = 1000; // 로또 한 장 상수로 선언

    private final int amount; // 구입 금액 변수

    // 생성자
    public PurchaseAmount(int amount) {
        vaildateMinimumAmount(amount);
        vaildateUnit(amount);
        this.amount = amount; // 검증 끝난 금액 객체의 amount에 저장
    }

    // 구입 금액 1000원 이상인지 확인
    private void vaildateMinimumAmount(int amount) {
        if (amount < LOTTO_PRICE) { // 입력 금액이 로또 한 장 가격보다 작을 시 오류
            throw  new IllegalArgumentException("구입 금액 1000원 이상이여야함");
        }
    }

    // 구입 금액 1000원 단위인지 확인
    private void vaildateUnit(int amount) {
        if (amount % LOTTO_PRICE != 0) { // 나눈 나머지가 0인지 확인
            throw new IllegalArgumentException("구입 금액 1000원 단위여야함");
        }
    }

    // 로또 개수 반환
    public int lottoCount() {
        return amount / LOTTO_PRICE; // 구입 금액 / 로또 가격
    }

    // 총당첨금 전달받아 수익률 계산
    public double profitRate(long totalPrize) {
        return (double) totalPrize / amount; // 총당청금 / 구입 금액(형변환)
    }
}
