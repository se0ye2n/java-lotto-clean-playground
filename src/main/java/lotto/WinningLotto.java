package lotto;

public class WinningLotto {

    private final Lotto winningNumbers; // 당첨 번호
    private final LottoNumber bonusNumber; // 2등 판정에 사용할 보너스 번호

    public WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        validateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    // 보너스 번호가 기존 당첨 번호와 중복 여부 검사
    private void validateBonusNumber(
            Lotto winningNumbers,
            LottoNumber bonusNumber
    ) {
        if (winningNumbers.contains(bonusNumber)) { // 당첨 번호 6개 중 보너스 번호가 포함돼있는지 확인
            throw new IllegalArgumentException(
                    "보너스 번호는 당첨 번호와 중복될 수 없습니다."
            );
        }
    }

    // 구매한 로또 한 장이 몊 등인지 계산
    public Rank findRank(Lotto lotto) {
        int matchCount = lotto.countMatchingNumbers(winningNumbers); // 구매한 로또와 당첨 번호가 몇 개 일치하는지 계산
        boolean bonusMatched = lotto.contains(bonusNumber); // 구매한 로또가 보너스 번호 가지고 있는지
        return Rank.find(matchCount, bonusMatched); // 일치 개수와 보너스 번호 일치 여부를 Rank에 전달해 최종 등수 찾음
    }
}