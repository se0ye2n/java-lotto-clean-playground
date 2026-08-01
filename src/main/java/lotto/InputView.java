package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in); // 키보드 입력 받는 Scanner객체 생성

    private InputView() {
    }

    public static PurchaseAmount readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = SCANNER.nextLine(); // 사용자가 입력한 한 줄 문자열로 받음
        return new PurchaseAmount(parseNumber(input)); // 입력 문자열 숫자로 변환 후 PurchaseAmount객체로 만들어 반환
    }

    public static Lotto readWinningLotto() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = SCANNER.nextLine();
        return new Lotto(parseLottoNumbers(input));
    }

    private static List<LottoNumber> parseLottoNumbers(String input) {
        return Arrays.stream(input.split(",")) // 입력값 쉼표 기준으로 나눔
                .map(String::trim) // 문자열 앞뒤 공백 제거
                .map(InputView::parseNumber) // 문자열 정수로 변환
                .map(LottoNumber::new)
                .toList();
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) { // 숫자가 아닌 값 입력 시 오류
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}