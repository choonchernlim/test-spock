package com.choonchernlim.testSpock.example4

import spock.lang.Shared
import spock.lang.Specification

/**
 * Shared and non-shared instance fields. Pay attention to the memory addresses to notice the difference.
 */
class MySpec extends Specification {
    class TakesForeverToRunClass {
        String message;

        TakesForeverToRunClass(String message) {
            Thread.sleep(2000)
            this.message = message
        }
    }

    def nonSharedClass = new TakesForeverToRunClass('NO Sharing')

    @Shared
    def sharedClass = new TakesForeverToRunClass('WITH Sharing')

    def "using non shared class - 1"() {
        expect:
        'NO Sharing' == nonSharedClass.getMessage()
        println "using non shared class - 1 " + nonSharedClass
    }

    def "using non shared class - 2"() {
        expect:
        'NO Sharing' == nonSharedClass.getMessage()
        println "using non shared class - 2 " + nonSharedClass
    }

    def "using shared class - 1"() {
        expect:
        'WITH Sharing' == sharedClass.getMessage()
        println "using shared class - 1 " + sharedClass
    }

    def "using shared class - 2"() {
        expect:
        'WITH Sharing' == sharedClass.getMessage()
        println "using shared class - 2 " + sharedClass
    }

}
