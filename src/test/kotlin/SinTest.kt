import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import trigonometry.Sin
import kotlin.math.PI

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SinTest {
    // Tolerance for comparing expected vs actual results
    private val delta = 1e-3

    private lateinit var sin: Sin

    @BeforeAll
    fun init(){
        sin = Sin()
    }

    @Test
    fun `test sin function`() {
        /* Test coverage analysis:
         * - Tests sin at special values (0, π/6, π/4, π/3, π/2, π, etc.)
         * - Tests negative inputs
         * - Tests large inputs
         * - Verifies symmetry property: sin(-x) = -sin(x)
         * - Verifies sin values match expected standard values
         *
         * This provides adequate coverage because it:
         * 1. Tests common critical points (0, π/2, π)
         * 2. Tests edge cases like large values
         * 3. Verifies basic mathematical properties that must hold
         */

        // Test special angles
        assertEquals(0.0, sin(0.0), delta)
        assertEquals(0.5, sin(PI /6), delta)
        assertEquals(0.7071067811865475, sin(PI /4), delta)
        assertEquals(0.8660254037844386, sin(PI /3), delta)
        assertEquals(1.0, sin(PI /2), delta)
        assertEquals(0.0, sin(PI), delta)
        assertEquals(-1.0, sin(3* PI /2), delta)

        // Test negative inputs
        assertEquals(-0.5, sin(-PI /6), delta)
        assertEquals(-1.0, sin(-PI /2), delta)

        // Test property: sin(-x) = -sin(x)
        val testValues = listOf(0.1, 0.5, 1.0, 1.5, 2.0, 5.0)
        for (x in testValues) {
            assertEquals(-sin(x), sin(-x), delta)
        }

        // Test large inputs
        assertEquals(sin(PI /4), sin(PI /4 + 2* PI), delta)
        assertEquals(sin(PI /3), sin(PI /3 + 4* PI), delta)
    }
}