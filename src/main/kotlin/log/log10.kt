package log

class Log10(
    private val ln: (Double) -> Double = Ln(),
) : (Double) -> Double {
    override operator fun invoke(x: Double): Double = ln(x) / ln(10.0)
}