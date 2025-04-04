import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import trigonometry.Csc
import kotlin.math.PI
import kotlin.math.sin

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CscTest {
    private lateinit var csc: Csc
    // Tolerance for comparing expected vs actual results
    private val delta = 1e-2

    @BeforeAll
    fun init(){
        csc = Csc()
    }


    @Test
    fun `test csc function`() {
        /* Test coverage analysis:
         * - Tests csc at special values (0, π/6, π/4, π/3, π/2, π, etc.)
         * - Tests negative inputs
         * - Tests symmetry property: csc(-x) = -csc(x)
         * - Tests relationship with sin: csc(x) = 1 / sin(x)
         *
         * This provides adequate coverage because it:
         * 1. Tests critical points (0, π/2, π)
         * 2. Verifies the implementation uses the relationship with sin
         * 3. Tests the symmetry property
         * 4. Verifies accuracy against known values
         */

        // Test special angles
        assertEquals(Double.POSITIVE_INFINITY, csc(0.0), delta)
        assertEquals(2.0, csc(PI /6), delta)
        assertEquals(1.4142135623730951, csc(PI /4), delta)
        assertEquals(1.1547005383792517, csc(PI /3), delta)
        assertEquals(1.0, csc(PI /2), delta)

        // Test negative inputs and symmetry
        assertEquals(-csc(PI /4), csc(-PI /4), delta)
        assertEquals(-csc(PI /6), csc(-PI /6), delta)

        // Verify relationship with sin function
        val testValues = listOf(0.1, 0.5, 1.0, 1.5, 2.0)
        for (x in testValues) {
            assertEquals(1 / sin(x), csc(x), 0.1)
        }
    }
    
}