package log

import kotlin.math.abs

private const val ACCURACY = 1e-3

class Ln: (Double) -> Double {
    override operator fun invoke(x: Double): Double {
        if (x <= 0) throw IllegalArgumentException("ln(x) is undefined for x <= 0")
        if (x == 1.0) return 0.0

        val y = (x - 1) / (x + 1)
        var term = y
        var sum = term
        var n = 1

        while (abs(term) > ACCURACY) {
            term *= y * y
            sum += term / (2 * n + 1)
            n++
        }

        return 2 * sum
    }
}
