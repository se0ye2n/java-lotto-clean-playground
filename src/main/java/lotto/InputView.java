package lotto;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static PurchaseAmount readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(SCANNER.nextLine());
        return new PurchaseAmount(amount);
    }

    public static Lotto readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = SCANNER.nextLine();
        return new Lotto(parseNumbers(input));
    }

    private static List<LottoNumber> parseNumbers(String input) {
        return Stream.of(input.split(NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static LottoNumber readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int number = Integer.parseInt(SCANNER.nextLine());
        return new LottoNumber(number);
    }
}