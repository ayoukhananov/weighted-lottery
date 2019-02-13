package com.wl

import com.wl.bingo.Bingo
import java.util.concurrent.ThreadLocalRandom

class BingoIntWeightedLotteryNoRepetitionsTest : WeightedLotteryNoRepetitionsTestBase() {
    override fun weightedLottery(weights: DoubleArray) = Bingo(weights, ThreadLocalRandom.current())
}
