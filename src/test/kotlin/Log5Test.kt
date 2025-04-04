import log.Log5
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Log5Test {
    private lateinit var log: Log5
    // Tolerance for comparing expected vs actual results
    private val delta = 1e-2

    @BeforeAll
    fun init(){
        log = Log5()
    }

    @Test
    fun `test log function`() {
        assertEquals(0.0, log(1.0), delta)
        assertEquals(1.0, log(5.0), delta)
        assertEquals(2.0, log(25.0), delta)
    }
}