package com.choonchernlim.testSpock.example8

import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * Using `@IgnoreRest` to run just one test and ignore the rest.
 */
class IgnoredRestSpec extends Specification {

    @IgnoreRest
    def "Test A"() {
        expect:
        1 == 1
    }

    def "Test B"() {
        expect:
        1 == 1
    }

    def "Test C"() {
        expect:
        1 == 1
    }

    def "Test D"() {
        expect:
        1 == 1
    }

}
