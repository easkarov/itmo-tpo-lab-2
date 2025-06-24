import java.io.FileWriter

fun main(args: Array<String>){
    val func = SystemEquation()
    func.toCsv(8.0, FileWriter("src/main/resources/csv/output/SystemOut.csv"))
}