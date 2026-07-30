package lotto;

import java.util.Scanner; // 키보드 입력 받기 위해 Scanner클래스 가져옴

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in); // Scanner객체 만듬

    // 구입 금액 입력 받기
    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt(); // 입력한 정수 읽고 반환
    }
}
