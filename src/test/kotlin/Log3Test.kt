import log.Log3
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Log3Test {
    private lateinit var log: Log3
    // Tolerance for comparing expected vs actual results
    private val delta = 1e-2

    @BeforeAll
    fun init(){
        log = Log3()
    }

    @Test
    fun `test log function`() {
        assertEquals(0.0, log(1.0), delta)
        assertEquals(-0.512, log(0.56961), delta)
        assertEquals(1.0, log(3.0), delta)
        assertEquals(-0.609, log(0.512), delta)
        assertEquals(1.892, log(8.0), delta)
        assertEquals(2.0, log(9.0), delta)
    }
}