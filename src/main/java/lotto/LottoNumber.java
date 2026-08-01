package lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    // LottoNumber끼리 크기 비교> 로또 번호 오름차순 정렬

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private final int value; // 단순한 int번호 LottoNumber객체 안에 포장

    public LottoNumber(int value) {
        validateRange(value); // 로또 번호 1부터 45사이인지 확인
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < MINIMUM_NUMBER || value > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(value, other.value); // 현재 번호와 다른 번호 크기 비교(작 음, 같 0, 크 양)
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) { // 비교하는 두 객체 같을 시
            return true; // true 반환
        }
        if (!(object instanceof LottoNumber lottoNumber)) { // 비교 대상이  LottoNumber가 아닐 시
            return false; // false 반환
        }
        return value == lottoNumber.value; // 두 LottoNumber객체가 가진 실제 숫자가 같은지 비교
    }

    @Override
    public int hashCode() { // HashSet 같은 컬렉션에서 같은 번호를 같은 값으로 판단
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value); // LottoNumber객체 출력시 실제 숫자 나오도록
    }
}