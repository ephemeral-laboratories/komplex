package garden.ephemeral.math.complex

import assertk.assertAll
import assertk.assertThat
import assertk.assertions.isCloseTo
import assertk.assertions.isEqualTo
import kotlin.math.E
import kotlin.math.PI
import kotlin.test.Test

class ComplexTest {
    @Test
    fun x() {

    }

    /*
    package garden.ephemeral.math.complex

import kotlin.math.atan2
import kotlin.math.pow
import kotlin.math.sqrt

class Complex(val real: Double, val imaginary: Double) {
    val norm get() = sqrt(squaredNorm)
    val squaredNorm get() = real.pow(2) + imaginary.pow(2)
    val argument get() = atan2(imaginary, real)


     */

    @Test
    fun norm() {
        val z = 2 + 1.i
        assertThat(z.norm).isCloseTo(2.23606797749979)
    }

    @Test
    fun argument() {
        val z = 2 + 1.i
        assertThat(z.argument).isCloseTo(0.4636476090008061)
    }

    @Test
    fun conjugate() {
        val z = 2 + 1.i
        assertThat(z.conjugate).isCloseTo(2 - 1.i)
    }

    @Test
    fun plus() {
        val z = 2 + 1.i
        assertAll {
            assertThat(z + 2).isCloseTo(4 + 1.i)
            assertThat(z + 2.0).isCloseTo(4 + 1.i)
            assertThat(2 + z).isCloseTo(4 + 1.i)
            assertThat(2.0 + z).isCloseTo(4 + 1.i)
            assertThat(z + (1 + 1.i)).isCloseTo(3 + 2.i)
        }
    }

    @Test
    fun minus() {
        val z = 2 + 1.i
        assertAll {
            assertThat(z - 2).isCloseTo(1.i)
            assertThat(z - 2.0).isCloseTo(1.i)
            assertThat(2 - z).isCloseTo((-1).i)
            assertThat(2.0 - z).isCloseTo((-1).i)
            assertThat(z - (1 + 1.i)).isCloseTo(1)
            assertThat((1 + 1.i) - z).isCloseTo(-1)
        }
    }

    @Test
    fun times() {
        val z = 2 + 1.i
        assertAll {
            assertThat(z * 2).isCloseTo(4 + 2.i)
            assertThat(z * 2.0).isCloseTo(4 + 2.i)
            assertThat(z * z).isCloseTo(3 + 4.i)
            assertThat(2 * z).isCloseTo(4 + 2.i)
            assertThat(2.0 * z).isCloseTo(4 + 2.i)
        }
    }

    @Test
    fun div() {
        val z = 4 + 2.i
        val z2 = 2 + 1.i
        assertAll {
            assertThat(z / 2).isCloseTo(z2)
            assertThat(z / 2.0).isCloseTo(z2)
            assertThat(z / z2).isCloseTo(2)
            assertThat(z2 / z).isCloseTo(0.5)
            assertThat(2 / z2).isCloseTo(0.8 - 0.4.i)
            assertThat(2.0 / z2).isCloseTo(0.8 - 0.4.i)
        }
    }

    @Test
    fun unaryMinus() {
        val z = 4 + 2.i
        assertThat(-z).isCloseTo(-4 - 2.i)
    }

    @Test
    fun pow() {
        val z = 2 + 1.i
        assertAll {
            assertThat(z.pow(0)).isCloseTo(1)
            assertThat(z.pow(1)).isCloseTo(z)
            assertThat(z.pow(2)).isCloseTo(3 + 4.i)
            assertThat(z.pow(3)).isCloseTo(2 + 11.i)
            assertThat(z.pow(0.0)).isCloseTo(1)
            assertThat(z.pow(1.0)).isCloseTo(z)
            assertThat(z.pow(2.0)).isCloseTo(3 + 4.i)
            assertThat(z.pow(3.0)).isCloseTo(2 + 11.i)
            assertThat(z.pow(z)).isCloseTo(-0.504824688978318 + 3.1041440769955284.i)
            assertThat(E.pow(PI.i)).isCloseTo(-1)
        }
    }

    @Test
    fun fromPolar() {
        assertThat(Complex.fromPolar(2.23606797749979, 0.4636476090008061)).isCloseTo(2 + 1.i)
    }
}