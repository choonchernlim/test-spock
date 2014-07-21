package com.choonchernlim.testSpock.example0

import org.apache.log4j.Logger
import spock.lang.Specification

/**
 * Understanding different phases of Spock.
 */
class MySpec extends Specification {
    static final def LOGGER = Logger.getLogger(MySpec.class)

    def setupSpec() {
        LOGGER.info('spec - setup')
    }

    def cleanupSpec() {
        LOGGER.info('spec - cleanup')
    }

    def setup() {
        LOGGER.info('global feature - setup')
    }

    def cleanup() {
        LOGGER.info('global feature - cleanup')
    }

    def "feature 1"() {
        given:
        LOGGER.info('feature 1 - given')

        expect:
        LOGGER.info('feature 1 - expect')

        cleanup:
        LOGGER.info('feature 1 - cleanup')
    }

    def "feature 2"() {
        given:
        LOGGER.info('feature 2 - given')

        when:
        LOGGER.info('feature 2 - when')

        then:
        LOGGER.info('feature 2 - then')

        cleanup:
        LOGGER.info('feature 2 - cleanup')
    }
}
