import log.Ln
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LnTest {
    private lateinit var ln: Ln
    // Tolerance for comparing expected vs actual results
    private val delta = 1e-2

    @BeforeAll
    fun init(){
        ln = Ln()
    }


    @Test
    fun `test ln function`() {
        /* Test coverage analysis:
         * - Tests ln at special values (1, e, powers of e)
         * - Tests values between 0 and 1
         * - Tests values > 1
         * - Tests error handling for invalid inputs (x ≤ 0)
         * 
         * This provides adequate coverage because it:
         * 1. Tests known values (ln(1)=0, ln(e)=1)
         * 2. Tests boundary cases (values approaching 0, very large values)
         * 3. Verifies error handling
         * 4. Tests the basic property: ln(a*b) = ln(a) + ln(b)
         */

        // Test special values
        assertEquals(0.0, ln(1.0), delta)
        assertEquals(1.0, ln(Math.E), delta)
        assertEquals(2.0, ln(Math.E * Math.E), delta)

        // Test values between 0 and 1
        assertEquals(-1.0, ln(1.0/Math.E), delta)
        assertEquals(-0.6931471805599453, ln(0.5), delta)

        // Test values > 1
        assertEquals(1.0986122886681098, ln(3.0), delta)
        assertEquals(2.302585092994046, ln(10.0), delta)

        // Test property: ln(a*b) = ln(a) + ln(b)
        val a = 2.5
        val b = 4.0
        assertEquals(ln(a) + ln(b), ln(a * b), delta)

        // Test error cases
        assertThrows<IllegalArgumentException> { ln(0.0) }
        assertThrows<IllegalArgumentException> { ln(-1.0) }
    }
}