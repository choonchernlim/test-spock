package com.choonchernlim.testSpock.example9

import spock.lang.Specification

import static org.hamcrest.Matchers.*
import static spock.util.matcher.HamcrestSupport.expect
import static spock.util.matcher.HamcrestSupport.that

/**
 * Leveraging Hamcrest matchers.
 */
class MySpec extends Specification {

    def "closeTo(...)"() {
        given:
        def number = 1.123456

        expect:
        that number, closeTo(1.12999, 2)
    }

    def "using `expect` instead of `that` to improve readability"() {
        when:
        def number = 1.123456

        then:
        expect number, closeTo(1.12999, 2)
    }

    def "hasKey(...) and not(hasKey(...))"() {
        given:
        def map = [name: 'Mike']

        expect:
        that map, hasKey('name')
        that map, not(hasKey('age'))
    }
}
