package trigonometry

import kotlin.math.abs
import kotlin.math.pow

private const val ACCURACY = 1e-3

fun factorial(n: Int): Long {
    require(n >= 0) { "Факториал определен только для неотрицательных чисел" }

    return if (n == 0 || n == 1) {
        1
    } else {
        var result = 1L
        for (i in 2..n) {
            result *= i
        }
        result
    }
}

class Sin: (Double) -> Double {
    override operator fun invoke(x: Double): Double {
        var sinSum = 0.0
        var i = 0

        while (abs(sinSum - kotlin.math.sin(x)) > ACCURACY) {
            sinSum += ((-1.0).pow(i) * x.pow(2 * i + 1)) / factorial(2 * i + 1)
            i++
        }
        return sinSum
    }
}
