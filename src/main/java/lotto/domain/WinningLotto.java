package lotto.domain;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(
            Lotto winningNumbers,
            LottoNumber bonusNumber
    ) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."
            );
        }
    }

    public Rank findRank(Lotto lotto) {
        int matchingCount = lotto.countMatchingNumbers(winningNumbers);
        boolean bonusMatched = lotto.contains(bonusNumber);
        return Rank.find(matchingCount, bonusMatched);
    }
}