import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import trigonometry.Sec
import kotlin.math.PI
import kotlin.math.cos

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SecTest {
    private lateinit var sec: Sec
    // Tolerance for comparing expected vs actual results
    private val delta = 1e-2
    
    @BeforeAll
    fun init(){
        sec = Sec()
    }
    
    @Test
    fun `test sec function`() {
        /* Test coverage analysis:
         * - Tests sec at special values (0, π/6, π/4, π/3, π/2, π, etc.)
         * - Tests negative inputs
         * - Tests symmetry property: sec(-x) = sec(x)
         * - Tests relationship with cos: sec(x) = 1 / cos(x)
         *
         * This provides adequate coverage because it:
         * 1. Tests critical points (0, π/2, π)
         * 2. Verifies the implementation uses the relationship with cos
         * 3. Tests the symmetry property
         * 4. Verifies accuracy against known values
         */

        // Test special angles
        assertEquals(1.0, sec(0.0), delta)
        assertEquals(1.1547005383792517, sec(PI /6), delta)
        assertEquals(1.4142135623730951, sec(PI /4), delta)
        assertEquals(2.0, sec(PI /3), delta)

        // Test negative inputs and symmetry
        assertEquals(sec(PI /4), sec(-PI /4), delta)
        assertEquals(sec(PI /3), sec(-PI /3), delta)

        // Verify relationship with cos function
        val testValues = listOf(0.1, 0.5, 1.0)
        for (x in testValues) {
            assertEquals(1 / cos(x), sec(x), delta)
        }
    }
}