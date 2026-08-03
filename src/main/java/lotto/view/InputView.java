package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Pattern DELIMITER = Pattern.compile(",");

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readInteger();
    }

    public int readManualPurchaseCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return readInteger();
    }

    public List<Lotto> readManualLottos(int count) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return createManualLottos(count);
    }

    private List<Lotto> createManualLottos(int count) {
        return java.util.stream.IntStream.range(0, count)
                .mapToObj(index -> readLotto())
                .collect(Collectors.toList());
    }

    public Lotto readWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return readLotto();
    }

    public LottoNumber readBonusNumber() {
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNumber.from(readInteger());
    }

    private Lotto readLotto() {
        String input = SCANNER.nextLine();
        return new Lotto(parseNumbers(input));
    }

    private List<LottoNumber> parseNumbers(String input) {
        return DELIMITER.splitAsStream(input)
                .map(String::trim)
                .map(this::parseInteger)
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }

    private int readInteger() {
        String input = SCANNER.nextLine();
        return parseInteger(input);
    }

    private int parseInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "[ERROR] 숫자를 입력해 주세요."
            );
        }
    }
}