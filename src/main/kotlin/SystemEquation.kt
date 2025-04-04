import log.Ln
import log.Log10
import log.Log3
import log.Log5
import org.apache.commons.csv.CSVFormat
import trigonometry.Csc
import trigonometry.Sec
import java.io.IOException
import java.io.Writer
import kotlin.math.PI
import kotlin.math.pow

class SystemEquation(
    private val ln: (Double) -> Double = Ln(),
    private val log3: (Double) -> Double = Log3(),
    private val log5: (Double) -> Double = Log5(),
    private val log10: (Double) -> Double = Log10(),
    private val sec: (Double) -> Double = Sec(),
    private val csc: (Double) -> Double = Csc(),
) : (Double) -> Double {
    override operator fun invoke(x: Double): Double {
        return if (x <= 0) {
            (csc(x) / sec(x)).pow(2)
        } else {
            (((ln(x) * log10(x)).pow(2) - log10(x)) / log5(x.pow(3))) +
                    ((log10(x) + log3(x)) - log5(x))
        }
    }

    fun toCsv(x: Double, out: Writer?): Double {
        val res = this(x)
        try {
            CSVFormat.DEFAULT.print(out).use { printer ->
                printer.printRecord(x, res)
            }
        } catch (e: IOException) {
            println("Wrong filename")
        }
        return res
    }
}
