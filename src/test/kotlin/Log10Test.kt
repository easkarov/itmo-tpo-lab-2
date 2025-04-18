import log.Log10
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Log10Test {
    private lateinit var log: Log10
    // Tolerance for comparing expected vs actual results
    private val delta = 1e-2

    @BeforeAll
    fun init(){
        log = Log10()
    }

    @Test
    fun `test log function`() {
        assertEquals(0.0, log(1.0), delta)
        assertEquals(-0.244, log(0.56961), delta)
        assertEquals(1.0, log(10.0), delta)
        assertEquals(0.077, log(1.194), delta)
        assertEquals(2.0, log(100.0), delta)
        assertEquals(0.903, log(8.0), delta)
    }
}