package lotto

class LottoResult(private val result: Map<Rank, Int>) {
    fun countByRank(rank: Rank): Int {
        return result.getValue(rank)
    }

    fun calculateTotalPrize(): Int {
        return result.keys.map { it.prizeByCount(result.getValue(it)) }.sum()
    }
}