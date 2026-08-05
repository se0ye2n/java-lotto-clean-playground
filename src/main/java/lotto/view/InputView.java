package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return parseNumber(SCANNER.nextLine());
    }

    public int readManualCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return parseNumber(SCANNER.nextLine());
    }

    public List<Lotto> readManualLottos(int count) {
        List<Lotto> manualLottos = new ArrayList<>();
        printManualLottoMessage(count);
        readManualLottos(count, manualLottos);

        return manualLottos;
    }

    private void printManualLottoMessage(int count) {
        if (count > 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
    }

    private void readManualLottos(
            int count,
            List<Lotto> manualLottos
    ) {
        for (int index = 0; index < count; index++) {
            manualLottos.add(new Lotto(readNumbers()));
        }
    }

    public Lotto readWinningLotto() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Lotto(readNumbers());
    }

    public int readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return parseNumber(SCANNER.nextLine());
    }

    private List<Integer> readNumbers() {
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(String::trim)
                .map(this::parseNumber)
                .collect(Collectors.toList());
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "[ERROR] 숫자를 입력해야 합니다."
            );
        }
    }
}
