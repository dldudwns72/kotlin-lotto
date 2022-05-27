package lotto.domain

class KoreanLottoNumberMaker : LottoMaker {
    private val lottoNumberCandidate = List(LOTTO_COUNT) { LottoNumber(it + LOTTO_START_OFFSET) }

    override fun makeLottoNumbers(): LottoNumbers {
        val shuffled = lottoNumberCandidate.shuffled()
        return LottoNumbers(shuffled.subList(LOTTO_START, LOTTO_END))
    }

    companion object {
        private const val LOTTO_START_OFFSET = 1
        private const val LOTTO_COUNT = 45
        private const val LOTTO_START = 0
        private const val LOTTO_END = 6
    }
}