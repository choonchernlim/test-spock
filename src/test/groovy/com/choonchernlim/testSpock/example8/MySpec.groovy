package com.choonchernlim.testSpock.example8

import spock.lang.*

import java.util.concurrent.TimeUnit

/**
 * Annotating with `@Timeout`, `@Ignore`, `@IgnoreIf`, `@Requires`.
 *
 * Instead of doing `System.getProperty("os.name").contains("windows")`, the following properties are available inside the closure:-
 *
 * sys - A map of all system properties
 * env - A map of all environment variables
 * os - Information about the operating system (see spock.util.environment.OperatingSystem)
 * jvm - Information about the JVM (see spock.util.environment.Jvm)
 */
class MySpec extends Specification {

    @Timeout(2)
    def "Fail if running more than 2 seconds"() {
        expect:
        Thread.sleep(1000)
        1 == 1
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    def "Fail if running more than 500 miliseconds"() {
        expect:
        Thread.sleep(300)
        1 == 1
    }

    @Ignore
    def "Ignore this test"() {
        expect:
        1 == 1
    }

    @IgnoreIf({ !jvm.java8 })
    def "Run test if we are not using Java 8"() {
        expect:
        1 == 1
    }

    @Requires({ jvm.java6 })
    def "Run test if we are using Java 6"() {
        expect:
        1 == 1
    }

    @Requires({ os.macOs })
    def "Run test if we are using Mac"() {
        expect:
        1 == 1
    }

    @Requires({ jvm.java6 && os.macOs })
    def "Run test if we are using Java 6 and Mac"() {
        expect:
        1 == 1
    }

    @Requires({ sys."user.name" == 'limc' })
    def "Run test if System.getProperty(\"user.name\") is limc"() {
        expect:
        1 == 1
    }

    @Requires({ env."USER" == 'limc' })
    def "Run test if environment variable USER is limc"() {
        expect:
        1 == 1
    }

}
