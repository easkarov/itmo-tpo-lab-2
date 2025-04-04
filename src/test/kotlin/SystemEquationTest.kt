//import log.Ln
//import log.Log10
//import log.Log3
//import log.Log5
//import org.apache.commons.csv.CSVFormat
//import org.apache.commons.csv.CSVRecord
//import org.junit.jupiter.api.Assertions
//import org.junit.jupiter.api.BeforeAll
//import org.junit.jupiter.params.ParameterizedTest
//import org.junit.jupiter.params.provider.CsvFileSource
//import org.mockito.Mockito
//import org.mockito.Mockito.mock
//import org.mockito.Mockito.`when`
//import trigonometry.Csc
//import trigonometry.Sec
//import trigonometry.Sin
//import java.io.FileReader
//import java.io.IOException
//import java.io.Reader
//
//internal class FunctionTest {
//    var eps: Double = 0.1
//
//    @ParameterizedTest
//    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
//    fun testSystemWithMocks(value: Double, expected: Double) {
//        val function = Function(secMock, lnMock, logMock)
//        Assertions.assertEquals(expected, function.SystemSolve(value, functionEps), eps)
//
//        /*
//        try {
//            Assertions.assertEquals(expected, function.writeResultToCSV(value, functionEps,
//                    new FileWriter("C:\\Users\\egorm\\IdeaProjects\\TpoLab2\\src\\main\\resources\\CsvFiles\\Outputs\\SystemOut.csv", true)), eps);
//        } catch (IOException e) {
//            System.err.println("Да как ты это делаешь ");
//        }
//*/
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
//    fun testWithSec(value: Double, expected: Double) {
//        val function = Function(Sec(cosMock), lnMock, logMock)
//        Assertions.assertEquals(expected, function.SystemSolve(value, functionEps), eps)
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
//    fun testWithCos(value: Double, expected: Double) {
//        val function = Function(Sec(Cos(sinMock)), lnMock, logMock)
//        Assertions.assertEquals(expected, function.SystemSolve(value, functionEps), eps)
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
//    fun testWithSin(value: Double, expected: Double) {
//        val function = Function(Sec(Cos(Sin())), lnMock, logMock)
//        Assertions.assertEquals(expected, function.SystemSolve(value, functionEps), eps)
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
//    fun testWithLog(value: Double, expected: Double) {
//        val function = Function(secMock, lnMock, Log(lnMock))
//        Assertions.assertEquals(expected, function.SystemSolve(value, functionEps), eps)
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
//    fun testWithLn(value: Double, expected: Double) {
//        val function = Function(secMock, Ln(), Log())
//        Assertions.assertEquals(expected, function.SystemSolve(value, functionEps), eps * 20)
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = ["/csv/input/SystemIn.csv"])
//    fun testWithSinAndLn(value: Double, expected: Double) {
//        val function = Function()
//        Assertions.assertEquals(expected, function.SystemSolve(value, functionEps), eps * 20)
//    }
//
//    companion object {
//        lateinit var secMock: Sec
//        lateinit var cscMock: Csc
//        lateinit var sinMock: Sin
//
//        lateinit var lnMock: Ln
//        lateinit var log3Mock: Log3
//        lateinit var log5Mock: Log5
//        lateinit var log10Mock: Log10
//
//        @JvmStatic
//        @BeforeAll
//        fun init() {
//            try {
//                val secIn = FileReader("src/main/resources/csv/input/SecIn.csv")
//                val cscIn = FileReader("src/main/resources/csv/input/CscIn.csv")
//                val sinIn = FileReader("src/main/resources/csv/input/SinIn.csv")
//                val lnIn = FileReader("src/main/resources/csv/input/LnIn.csv")
//                val log3In = FileReader("src/main/resources/csv/input/Log3In.csv")
//                val log5In = FileReader("src/main/resources/csv/input/Log5In.csv")
//                val log10In = FileReader("src/main/resources/csv/input/Log10In.csv")
//
//                var records: Iterable<CSVRecord> = CSVFormat.DEFAULT.parse(secIn)
//                for (record in records) {
//                    `when`(secMock.invoke(record[0].toDouble())).thenReturn(
//                        record[1].toDouble()
//                    )
//                }
//                records = CSVFormat.DEFAULT.parse(cscIn)
//                for (record in records) {
//                    `when`(cscMock.invoke(record[0].toDouble())).thenReturn(
//                        record[1].toDouble()
//                    )
//                }
//                records = CSVFormat.DEFAULT.parse(sinIn)
//                for (record in records) {
//                    `when`(sinMock.invoke(record[0].toDouble())).thenReturn(
//                        record[1].toDouble()
//                    )
//                }
//                records = CSVFormat.DEFAULT.parse(lnIn)
//                for (record in records) {
//                    `when`(lnMock.invoke(record[0].toDouble())).thenReturn(
//                        record[1].toDouble()
//                    )
//                }
//                records = CSVFormat.DEFAULT.parse(log3In)
//                for (record in records) {
//                    `when`(log3Mock.invoke(record[0].toDouble())).thenReturn(
//                        record[1].toDouble()
//                    )
//                }
//                records = CSVFormat.DEFAULT.parse(log5In)
//                for (record in records) {
//                    `when`(log5Mock.invoke(record[0].toDouble())).thenReturn(
//                        record[1].toDouble()
//                    )
//                }
//                records = CSVFormat.DEFAULT.parse(log10In)
//                for (record in records) {
//                    `when`(log10Mock.invoke(record[0].toDouble())).thenReturn(
//                        record[1].toDouble()
//                    )
//                }
//            } catch (ex: IOException) {
//                System.err.println("Ты как в тесте IOE поймал?!")
//            }
//        }
//    }
//}