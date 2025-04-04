package log

class Log3(
    private val ln: (Double) -> Double = Ln(),
) : (Double) -> Double {
    override operator fun invoke(x: Double): Double = ln(x) / ln(3.0)
}