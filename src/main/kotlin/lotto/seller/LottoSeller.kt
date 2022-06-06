package lotto.seller

import lotto.agency.LottoTicket
import lotto.agency.number.LottoNumberStrategy
import lotto.exception.MinimumPurchaseMoneyException

class LottoSeller {

    fun calculateAutoLottoPurchaseAmount(money: Int, manualAmount: Int): Int {
        validatePurchaseMoney(money)

        val moneyForAutoLotto = money - (manualAmount * LOTTO_PURCHASE_PRICE_PER_PIECE)
        return moneyForAutoLotto / LOTTO_PURCHASE_PRICE_PER_PIECE
    }

    fun buy(amount: Int, lottoNumbers: List<Set<Int>>, lottoNumberStrategy: LottoNumberStrategy): List<LottoTicket> {
        val manualLottoTickets = lottoNumbers.map {
            LottoTicket(it)
        }

        val autoLottoTickets = List(amount) {
            LottoTicket(lottoNumberStrategy.makeLottoNumbers())
        }

        return manualLottoTickets + autoLottoTickets
    }

    private fun validatePurchaseMoney(money: Int) {
        if (money < LOTTO_PURCHASE_PRICE_PER_PIECE) {
            throw MinimumPurchaseMoneyException("최소 ${LOTTO_PURCHASE_PRICE_PER_PIECE}원 이상 지불하셔야 로또 구매가 가능합니다.")
        }
    }

    companion object {
        const val LOTTO_PURCHASE_PRICE_PER_PIECE = 1_000
    }
}