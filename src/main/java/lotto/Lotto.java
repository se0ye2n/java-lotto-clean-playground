package lotto;

import java.util.ArrayList;
import java.util.List;

// 로또 한 장 표현하는 클래스
public class Lotto {

    private final List<Integer> numbers; // 로또 번호 저장

    public Lotto(List<Integer> numbers) { // 생성자
        this.numbers = new ArrayList<>(numbers); // 새로운 ArrayList에 복사해 저장
    }

    // 로또 번호 반환
    public  List<Integer> getNumbers() {
        return new ArrayList<>(numbers); // 복사한 리스트 반환> Lotto 내부 번호 보호
    }
}
