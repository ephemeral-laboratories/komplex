package garden.ephemeral.math.complex

import assertk.Assert
import assertk.all
import assertk.assertions.isCloseTo
import assertk.assertions.prop

fun Assert<Complex>.isCloseTo(expected: Double) = isCloseTo(expected.toComplex())
fun Assert<Complex>.isCloseTo(expected: Number) = isCloseTo(expected.toComplex())
fun Assert<Complex>.isCloseTo(expected: Complex) = isCloseTo(expected, epsilon)

fun Assert<Complex>.isCloseTo(expected: Complex, epsilon: Double) {
    this.all {
        prop(Complex::real).isCloseTo(expected.real, epsilon)
        prop(Complex::imaginary).isCloseTo(expected.imaginary, epsilon)
    }
}
