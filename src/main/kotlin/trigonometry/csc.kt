package trigonometry

class Csc(
    private val sin: (Double) -> Double = Sin(),
) : (Double) -> Double {
    override operator fun invoke(x: Double): Double = 1 / sin(x)
}
