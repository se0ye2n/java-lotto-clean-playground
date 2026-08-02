package lotto;

import java.util.Objects;

// 로또 번호 하나를 나타내는 클래스> Comparable구현> LottoNumber객체끼리 크기 비교
public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MINIMUM_NUMBER = 1; // 로또 번호의 최소값
    private static final int MAXIMUM_NUMBER = 45; // 최대값

    private final int value;

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    // LottoNumber가 생성될 때 1부터 45 사이의 숫자인지 확인
    private void validate(int value) {
        if (value < MINIMUM_NUMBER || value > MAXIMUM_NUMBER) { // 1보다 작거나 45보다 크면 잘못된 번호
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    // 현재 번호와 다른 번호의 크기 비교
    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(value, other.value);
    }

    // 두 LottoNumber객체의 값이 같은지 판단
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof LottoNumber)) {
            return false;
        }

        LottoNumber other = (LottoNumber) object;
        return value == other.value;
    }

    // 같은 객체인지 판단할 때 사용
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    // LottoNumber출력할때 실제 숫자 나오도록
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}