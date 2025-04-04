package log

import kotlin.math.abs
import kotlin.math.pow

private const val ACCURACY = 1e-3

class Ln: (Double) -> Double {
    override operator fun invoke(x: Double): Double {
        var curRes = 0.0
        val expectedRes = kotlin.math.ln(x)
        val i = 1
        while (abs(curRes - expectedRes) > ACCURACY) {
            curRes += (-1.0).pow(i - 1) * (x - 1).pow(i) / i
        }
        return curRes
    }
}
