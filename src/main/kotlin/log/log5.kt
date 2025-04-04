package log

class Log5(
    private val ln: (Double) -> Double = Ln(),
) : (Double) -> Double {
    override operator fun invoke(x: Double): Double = ln(x) / ln(5.0)
}