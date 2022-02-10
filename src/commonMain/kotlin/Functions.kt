package garden.ephemeral.math.complex

import kotlin.math.*

/**
 * Computes the complex exponential of `z`.
 *
 * @param z the input value.
 * @return the complex exponential of `z`.
 */
fun exp(z: Complex): Complex {
    val r = exp(z.real)
    return Complex(r * cos(z.imaginary), r * sin(z.imaginary))
}

/**
 * Computes the complex logarithm of `z`.
 *
 * @param z the input value.
 * @return the complex logarithm of `z`.
 */
fun ln(z: Complex) = Complex(0.5 * ln(z.squaredNorm), z.argument)

/**
 * Computes the complex square root of `z`.
 *
 * @param z the input value.
 * @return the complex square root of `z`.
 */
fun sqrt(z: Complex): Complex {
    val halfArg = z.argument * 0.5
    val s = sin(halfArg)
    val c = cos(halfArg)
    val r = sqrt(z.norm)
    return Complex(c * r, s * r)
}

/**
 * Computes the complex square root of real-valued `x`
 * (which may be negative). This is faster than `sqrt(z)`.
 *
 * @param x the input value.
 * @return the complex square root of `z`.
 */
fun complexSqrt(x: Double): Complex {
    val r = sqrt(abs(x))
    return if (x >= 0) Complex(r, 0.0) else Complex(0.0, r)
}

/**
 * Computes the complex sine of `z`.
 *
 * @param z the input value.
 * @return the complex sine of `z`.
 */
fun sin(z: Complex) = Complex(sin(z.real) * cosh(z.imaginary), cos(z.real) * sinh(z.imaginary))

/**
 * Computes the complex cosine of `z`.
 *
 * @param z the input value.
 * @return the complex cosine of `z`.
 */
fun cos(z: Complex) = Complex(cos(z.real) * cosh(z.imaginary), -sin(z.real) * sinh(z.imaginary))

/**
 * Computes the complex tangent of `z`.
 *
 * @param z the input value.
 * @return the complex tangent of `z`.
 */
fun tan(z: Complex) = sin(z) / cos(z)

/**
 * Computes the complex secant of `z`.
 *
 * @param z the input value.
 * @return the complex secant of `z`.
 */
fun sec(z: Complex) = 1.0 / cos(z)

/**
 * Computes the complex cosecant of `z`.
 *
 * @param z the input value.
 * @return the complex cosecant of `z`.
 */
fun csc(z: Complex) = 1.0 / sin(z)

/**
 * Computes the complex cotangent of `z`.
 *
 * @param z the input value.
 * @return the complex cotangent of `z`.
 */
fun cot(z: Complex) = 1.0 / tan(z)

/**
 * Computes the complex hyperbolic sine of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic sine of `z`.
 */
fun sinh(z: Complex): Complex = Complex(sinh(z.real) * cos(z.imaginary), cosh(z.real) * sin(z.imaginary))

/**
 * Computes the complex hyperbolic cosine of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic cosine of `z`.
 */
fun cosh(z: Complex): Complex {
    val s = sin(z.imaginary)
    val c = cos(z.imaginary)
    val sh = sinh(z.real)
    val ch = cosh(z.real)
    return Complex(ch * c, sh * s)
}

/**
 * Computes the complex hyperbolic tangent of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic tangent of `z`.
 */
fun tanh(z: Complex) = sinh(z) / cosh(z)

/**
 * Computes the complex hyperbolic secant of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic secant of `z`.
 */
fun sech(z: Complex) = 1.0 / cosh(z)

/**
 * Computes the complex hyperbolic cosecant of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic cosecant of `z`.
 */
fun csch(z: Complex) = 1.0 / sinh(z)

/**
 * Computes the complex hyperbolic cotangent of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic cotangent of `z`.
 */
fun coth(z: Complex) = 1.0 / tanh(z)

/**
 * Computes the complex arc sine of `z`.
 *
 * @param z the input value.
 * @return the complex arc sine of `z`.
 */
fun asin(z: Complex): Complex {
    val tmp = ln(Complex(-z.imaginary, z.real) + sqrt(1.0 - z * z))
    return Complex(tmp.imaginary, -tmp.real)
}

/**
 * Computes the complex arc cosine of `z`.
 *
 * @param z the input value.
 * @return the complex arc cosine of `z`.
 */
fun acos(z: Complex): Complex {
    var tmp = sqrt(1.0 - z * z)
    tmp = ln(z + Complex(-tmp.imaginary, tmp.real))
    return Complex(tmp.imaginary, -tmp.real)
}

/**
 * Computes the complex arc tangent of `z`.
 *
 * @param z the input value.
 * @return the complex arc tangent of `z`.
 */
fun atan(z: Complex): Complex {
    val tmp = ln((Complex.I - z) / (Complex.I + z));
    return Complex(tmp.imaginary * 0.5, -tmp.real * 0.5);
}

/**
 * Computes the complex arc secant of `z`.
 *
 * @param z the input value.
 * @return the complex arc secant of `z`.
 */
fun asec(z: Complex) = acos(1.0 / z)

/**
 * Computes the complex arc cosecant of `z`.
 *
 * @param z the input value.
 * @return the complex arc cosecant of `z`.
 */
fun acsc(z: Complex) = asin(1.0 / z)

/**
 * Computes the complex arc cotangent of `z`.
 *
 * @param z the input value.
 * @return the complex arc cotangent of `z`.
 */
fun acot(z: Complex) = atan(1.0 / z)

/**
 * Computes the complex hyperbolic arc sine of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic arc sine of `z`.
 */
fun asinh(z: Complex) = ln(z + sqrt(z * z + 1.0))

/**
 * Computes the complex hyperbolic arc cosine of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic arc cosine of `z`.
 */
fun acosh(z: Complex) = ln(z + sqrt(z * z + 1.0))

/**
 * Computes the complex hyperbolic arc tangent of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic arc tangent of `z`.
 */
fun atanh(z: Complex) = ln((1.0 + z) / (1.0 - z)) * 0.5

/**
 * Computes the complex hyperbolic arc secant of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic arc secant of `z`.
 */
fun asech(z: Complex) = acosh(1.0 / z)

/**
 * Computes the complex hyperbolic arc cosecant of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic arc cosecant of `z`.
 */
fun acsch(z: Complex) = asinh(1.0 / z)

/**
 * Computes the complex hyperbolic arc cotangent of `z`.
 *
 * @param z the input value.
 * @return the complex hyperbolic arc cotangent of `z`.
 */
fun acoth(z: Complex) = atanh(1.0 / z)
