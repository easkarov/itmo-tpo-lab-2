import log.Ln
import log.Log10
import log.Log3
import log.Log5
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.mockito.kotlin.mock
import org.mockito.Mockito.`when`
import trigonometry.Csc
import trigonometry.Sec
import trigonometry.Sin
import java.io.FileReader
import java.io.IOException

class SystemEquationTest {
    var eps: Double = 0.1

    @ParameterizedTest
    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
    fun `system with all mocks`(value: Double, expected: Double) {
        val function = SystemEquation(
            log10 = log10Mock,
            log3 = log3Mock,
            log5 = log5Mock,
            ln = lnMock,
            sec = secMock,
            csc = cscMock
        )
        assertEquals(expected, function(value), eps)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
    fun `system with sec and csc mocks`(value: Double, expected: Double) {
        val function = SystemEquation(
            sec = secMock,
            csc = cscMock,
        )
        assertEquals(expected, function(value), eps)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
    fun `system with logs mocks`(value: Double, expected: Double) {
        val function = SystemEquation(
            log10 = log10Mock,
            log3 = log3Mock,
            log5 = log5Mock,
            ln = lnMock,
        )
        assertEquals(expected, function(value), eps)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
    fun `system with ln mocks`(value: Double, expected: Double) {
        val function = SystemEquation(
            log10 = Log10(lnMock),
            log3 = Log3(lnMock),
            log5 = Log5(lnMock),
            ln = lnMock,
        )
        assertEquals(expected, function(value), eps)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
    fun `system with sin mocks`(value: Double, expected: Double) {
        val function = SystemEquation(
            sec = Sec(sinMock),
            csc = Csc(sinMock)
        )
        assertEquals(expected, function(value), eps)
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
    fun `system without mocks`(value: Double, expected: Double) {
        val function = SystemEquation()
        assertEquals(expected, function(value), eps)
    }

    companion object {
        var secMock: Sec = mock()
        val cscMock: Csc = mock()
        val sinMock: Sin = mock()

        val lnMock: Ln = mock()
        val log3Mock: Log3 = mock()
        val log5Mock: Log5 = mock()
        val log10Mock: Log10 = mock()

        @JvmStatic
        @BeforeAll
        fun init() {
            try {
                val secIn = FileReader("src/main/resources/csv/input/SecIn.csv")
                val cscIn = FileReader("src/main/resources/csv/input/CscIn.csv")
                val sinIn = FileReader("src/main/resources/csv/input/SinIn.csv")
                val lnIn = FileReader("src/main/resources/csv/input/LnIn.csv")
                val log3In = FileReader("src/main/resources/csv/input/Log3In.csv")
                val log5In = FileReader("src/main/resources/csv/input/Log5In.csv")
                val log10In = FileReader("src/main/resources/csv/input/Log10In.csv")

                var records: Iterable<CSVRecord> = CSVFormat.DEFAULT.parse(secIn)
                for (record in records) {
                    `when`(secMock.invoke(record[0].toDouble())).thenReturn(
                        record[1].toDouble()
                    )
                }
                records = CSVFormat.DEFAULT.parse(cscIn)
                for (record in records) {
                    `when`(cscMock.invoke(record[0].toDouble())).thenReturn(
                        record[1].toDouble()
                    )
                }
                records = CSVFormat.DEFAULT.parse(sinIn)
                for (record in records) {
                    `when`(sinMock.invoke(record[0].toDouble())).thenReturn(
                        record[1].toDouble()
                    )
                }
                records = CSVFormat.DEFAULT.parse(lnIn)
                for (record in records) {
                    `when`(lnMock.invoke(record[0].toDouble())).thenReturn(
                        record[1].toDouble()
                    )
                }
                records = CSVFormat.DEFAULT.parse(log3In)
                for (record in records) {
                    `when`(log3Mock.invoke(record[0].toDouble())).thenReturn(
                        record[1].toDouble()
                    )
                }
                records = CSVFormat.DEFAULT.parse(log5In)
                for (record in records) {
                    `when`(log5Mock.invoke(record[0].toDouble())).thenReturn(
                        record[1].toDouble()
                    )
                }
                records = CSVFormat.DEFAULT.parse(log10In)
                for (record in records) {
                    `when`(log10Mock.invoke(record[0].toDouble())).thenReturn(
                        record[1].toDouble()
                    )
                }
            } catch (ex: IOException) {
                System.err.println("Ты как в тесте IOE поймал?!")
            }
        }
    }
}