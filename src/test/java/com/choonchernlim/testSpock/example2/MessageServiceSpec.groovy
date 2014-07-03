package com.choonchernlim.testSpock.example2

import com.choonchernlim.testSpock.example0.MessageService
import spock.lang.FailsWith
import spock.lang.Specification

/**
 * Exception handling with `thrown(...)`, `@FailsWith` and `notThrown(...)`.
 */
class MessageServiceSpec extends Specification {
    def messageService = new MessageService()

    def "throw exception using thrown(...) because name is blank"() {
        when:
        messageService.getMessage(null)

        then:
        thrown(IllegalArgumentException)
    }

    def "throw exception using thrown() to check message because name is blank"() {
        when:
        messageService.getMessage(null)

        then:
        IllegalArgumentException e = thrown()
        e.message == 'name cannot be blank'
    }

    // Another way to throw exception. However, this approach is NOT recommended. `thrown(...)` is the way preferred approach.
    @FailsWith(IllegalArgumentException)
    def "throw exception using @FailsWith because name is blank"() {
        expect:
        messageService.getMessage(null)
    }

    def "no exception thrown because name is not blank"() {
        when:
        def msg = messageService.getMessage('Mike')

        then:
        notThrown(IllegalArgumentException)
        msg == 'hello, Mike'
    }
}
