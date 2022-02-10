package garden.ephemeral.math.complex

val Double.i get() = Complex(0.0, this)
val Number.i get() = toDouble().i

fun Double.toComplex() = Complex(this, 0.0)
fun Number.toComplex() = toDouble().toComplex()

operator fun Double.plus(other: Complex) = Complex(this + other.real, other.imaginary)
operator fun Double.minus(other: Complex) = Complex(this - other.real, -other.imaginary)
operator fun Double.times(other: Complex) = other * this
operator fun Double.div(other: Complex) = toComplex() / other

operator fun Number.plus(other: Complex) = toDouble() + other
operator fun Number.minus(other: Complex) = toDouble() - other
operator fun Number.times(other: Complex) = toDouble() * other
operator fun Number.div(other: Complex) = toDouble() / other

fun Double.pow(other: Complex) = toComplex().pow(other)
