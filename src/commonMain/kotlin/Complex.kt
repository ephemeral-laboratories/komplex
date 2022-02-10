package garden.ephemeral.math.complex

import kotlin.math.*

/**
 * A complex numeric value.
 *
 * Complex values are immutable.
 *
 * @property real The real part.
 * @property imaginary The imaginary part.
 */
data class Complex(val real: Double, val imaginary: Double) {

    /** The norm, i.e. the magnitude. */
    val norm get() = sqrt(squaredNorm)

    /**
     * The square of the norm.
     *
     * Because calculating the norm requires computing a square root, using
     * `squaredNorm` will be faster than getting `norm` and squaring it.
     */
    val squaredNorm get() = real.pow(2) + imaginary.pow(2)

    /** The argument, i.e. the counterclockwise angle from the real axis. */
    val argument get() = atan2(imaginary, real)

    /**
     * The complex conjugate.
     *
     * For `a + bi`, the conjugate is `a - bi`.
     */
    val conjugate get() = Complex(real, -imaginary)

    operator fun plus(other: Complex): Complex {
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    operator fun minus(other: Complex): Complex {
        return Complex(real - other.real, imaginary - other.imaginary)
    }

    operator fun times(other: Complex): Complex {
        return Complex(
            real * other.real - imaginary * other.imaginary,
            real * other.imaginary + imaginary * other.real
        )
    }

    operator fun div(other: Complex): Complex {
        if (other.imaginary == 0.0) {
            return Complex(real / other.real, imaginary / other.real)
        }

        val otherConjugate = other.conjugate
        return (this * otherConjugate) / (other * otherConjugate)
    }

    operator fun unaryMinus() = Complex(-real, -imaginary)

    operator fun plus(other: Double) = Complex(real + other, imaginary)
    operator fun minus(other: Double) = Complex(real - other, imaginary)
    operator fun times(other: Double) = Complex(real * other, imaginary * other)
    operator fun div(other: Double) = times(1.0 / other)

    operator fun plus(other: Number) = this + other.toDouble()
    operator fun minus(other: Number) = this - other.toDouble()
    operator fun times(other: Number) = this * other.toDouble()
    operator fun div(other: Number) = this / other.toDouble()

    /**
     * Computes the complex power of this number raised to `exponent`.
     * This contains some common shortcuts for small powers.
     *
     * @param exponent the exponent.
     * @return the complex power of this number raised to `exponent`.
     */
    fun pow(exponent: Int): Complex {
        return when(exponent) {
            0 -> ONE
            1 -> this
            2 -> this * this
            else -> exp(ln(this) * exponent)
        }
    }

    /**
     * Computes the complex power of this number raised to `exponent`.
     * This contains some common shortcuts for small powers.
     *
     * @param exponent the exponent.
     * @return the complex power of this number raised to `exponent`.
     */
    fun pow(exponent: Double): Complex {
        return when(exponent) {
            0.0 -> ONE
            1.0 -> this
            2.0 -> this * this
            else -> exp(ln(this) * exponent)
        }
    }

    /**
     * Computes the complex power of this number raised to `exponent`.
     *
     * @param exponent the exponent.
     * @return the complex power of this number raised to `exponent`.
     */
    fun pow(exponent: Complex) = exp(ln(this) * exponent)

    companion object {

        /**
         * Constant for 0.
         */
        val ZERO = Complex(0.0, 0.0)

        /**
         * Constant for 1.
         */
        val ONE = Complex(1.0, 0.0)

        /**
         * Constant for -1.
         */
        val MINUS_ONE = Complex(-1.0, 0.0)

        /**
         * Constant for i.
         */
        val I = Complex(0.0, 1.0)

        /**
         * Constant for -i.
         */
        val MINUS_I = Complex(0.0, -1.0)

        /**
         * Creates a new complex number from its polar form.
         *
         * @param norm the norm, i.e. the magnitude.
         * @param argument the argument, i.e. the counterclockwise angle
         *        from the real axis.
         * @return the complex number.
         */
        fun fromPolar(norm: Double, argument: Double): Complex {
            val s = sin(argument)
            val c = cos(argument)
            return Complex(norm * c, norm * s)
        }
    }
}
