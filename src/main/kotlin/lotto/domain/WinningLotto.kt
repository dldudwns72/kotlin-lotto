package lotto.domain

import lotto.domain.numbers.LottoNumber
import lotto.domain.numbers.LottoNumbers
import lotto.domain.prize.LottoPrize

class WinningLotto(winningNumbers: List<Int>, bonusNumber: Int) {
    val winningNumbers = LottoNumbers(winningNumbers)
    val bonusNumber = LottoNumber(bonusNumber)

    init {
        require(!winningNumbers.contains(bonusNumber)) { "당첨번호와 보너스번호는 겹칠 수 없습니다." }
    }

    fun getLottoPrizeOf(lotto: Lotto): LottoPrize = LottoPrize.of(getNumberOfMatchingNumbers(lotto), matchesBonus(lotto))

    fun getNumberOfMatchingNumbers(lotto: Lotto): Int = winningNumbers.list.intersect(lotto.numbers.list.toSet()).size

    fun matchesBonus(lotto: Lotto): Boolean = lotto.numbers.list.contains(bonusNumber)
}