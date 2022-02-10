package garden.ephemeral.math.complex

import assertk.assertThat
import kotlin.test.Test

class FunctionsTest {

    @Test
    fun exp() {
        assertThat(exp(2 + 1.i)).isCloseTo(3.992324048441272 + 6.217676312367968.i)
    }

    @Test
    fun ln() {
        assertThat(ln(3.992324048441272 + 6.217676312367968.i)).isCloseTo(2 + 1.i)
    }

    @Test
    fun sqrt() {
        assertThat(sqrt(3 + 4.i)).isCloseTo(2 + 1.i)
    }

    @Test
    fun complexSqrt() {
        assertThat(complexSqrt(4.0)).isCloseTo(2)
        assertThat(complexSqrt(-4.0)).isCloseTo(2.i)
    }

    @Test
    fun sin() {
        assertThat(sin(1 + 2.i)).isCloseTo(3.165778513216168 + 1.9596010414216063.i)
    }

    @Test
    fun cos() {
        assertThat(cos(1 + 2.i)).isCloseTo(2.0327230070196656 - 3.0518977991518.i)
    }

    @Test
    fun tan() {
        assertThat(tan(1 + 2.i)).isCloseTo(0.0338128260798966 + 1.0147936161466335.i)
    }

    @Test
    fun sec() {
        assertThat(sec(1 + 2.i)).isCloseTo(0.15117629826557724 + 0.2269736753937216.i)
    }

    @Test
    fun csc() {
        assertThat(csc(1 + 2.i)).isCloseTo(0.22837506559968654 - 0.1413630216124078.i)
    }

    @Test
    fun cot() {
        assertThat(cot(1 + 2.i)).isCloseTo(0.032797755533752505 - 0.984329226458191.i)
    }

    @Test
    fun sinh() {
        assertThat(sinh(1 + 2.i)).isCloseTo(-0.4890562590412937 + 1.4031192506220407.i)
    }

    @Test
    fun cosh() {
        assertThat(cosh(1 + 2.i)).isCloseTo(-0.6421481247155201 + 1.0686074213827783.i)
    }

    @Test
    fun tanh() {
        assertThat(tanh(1 + 2.i)).isCloseTo(1.16673625724092 - 0.2434582011857254.i)
    }

    @Test
    fun sech() {
        assertThat(sech(1 + 2.i)).isCloseTo(-0.41314934426694006 - 0.6875274386554789.i)
    }

    @Test
    fun csch() {
        assertThat(csch(1 + 2.i)).isCloseTo(-0.22150093085050937 - 0.6354937992538999.i)
    }

    @Test
    fun coth() {
        assertThat(coth(1 + 2.i)).isCloseTo(0.8213297974938516 + 0.17138361290918508.i)
    }

    @Test
    fun asin() {
        assertThat(asin(1 + 2.i)).isCloseTo(0.4270785863924768 + 1.5285709194809993.i)
    }

    @Test
    fun acos() {
        assertThat(acos(1 + 2.i)).isCloseTo(1.1437177404024204 - 1.528570919480998.i)
    }

    @Test
    fun atan() {
        assertThat(atan(1 + 2.i)).isCloseTo(1.3389725222944935 + 0.40235947810852507.i)
    }

    @Test
    fun asec() {
        assertThat(asec(1 + 2.i)).isCloseTo(1.384478272687081 + 0.39656823011232883.i)
    }

    @Test
    fun acsc() {
        assertThat(acsc(1 + 2.i)).isCloseTo(0.18631805410781554 - 0.3965682301123291.i)
    }

    @Test
    fun acot() {
        assertThat(acot(1 + 2.i)).isCloseTo(0.23182380450040305 - 0.40235947810852507.i)
    }

    @Test
    fun asinh() {
        assertThat(asinh(1 + 2.i)).isCloseTo(1.4693517443681852 + 1.0634400235777521.i)
    }

    @Test
    fun acosh() {
        assertThat(acosh(1 + 2.i)).isCloseTo(1.4693517443681852 + 1.0634400235777521.i)
    }

    @Test
    fun atanh() {
        assertThat(atanh(1 + 2.i)).isCloseTo(0.17328679513998632 + 1.1780972450961724.i)
    }

    @Test
    fun asech() {
        assertThat(asech(1 + 2.i)).isCloseTo(0.21561241855582974 - 0.40158639166780613.i)
    }

    @Test
    fun acsch() {
        assertThat(acsch(1 + 2.i)).isCloseTo(0.21561241855582974 - 0.40158639166780613.i)
    }

    @Test
    fun acoth() {
        assertThat(acoth(1 + 2.i)).isCloseTo(0.17328679513998632 - 0.3926990816987242.i)
    }
}