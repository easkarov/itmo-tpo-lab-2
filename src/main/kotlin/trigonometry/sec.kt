package trigonometry

import kotlin.math.pow
import kotlin.math.sqrt

class Sec(
    private val sin: (Double) -> Double = Sin(),
) : (Double) -> Double {
    override operator fun invoke(x: Double): Double = 1 / sqrt(1 - sin(x).pow(2))
}
