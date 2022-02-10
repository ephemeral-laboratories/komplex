package garden.ephemeral.math.complex

import assertk.Assert
import assertk.all
import assertk.assertions.isCloseTo
import assertk.assertions.prop

// Default epsilon is about as close as double precision allows me to get
const val epsilon = 0.00000000000001

fun Assert<Double>.isCloseTo(expected: Double) = isCloseTo(expected, epsilon)
fun Assert<Double>.isCloseTo(expected: Number) = isCloseTo(expected.toDouble())
