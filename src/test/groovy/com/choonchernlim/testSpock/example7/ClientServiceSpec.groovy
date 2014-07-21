package com.choonchernlim.testSpock.example7

import com.choonchernlim.testSpock.service.ClientService
import com.choonchernlim.testSpock.service.MessageService
import spock.lang.Specification

/**
 * Leveraging `_` wildcard in mocks. Using `interaction` block in `then` block.
 */
class ClientServiceSpec extends Specification {
    def messageService = Mock(MessageService)
    def clientService = new ClientService(messageService)

    def "no mocking"() {
        given:
        def actualMessageService = new MessageService()
        def actualClientService = new ClientService(actualMessageService)

        when:
        def message = actualClientService.introduceMe('Mike', 21)

        then:
        "Hello, my name is Mike. I'm 21 years old. I'm a rockstar." == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "any param values and types"() {
        when:
        def message = clientService.introduceMe('Mike', 21)

        then:
        1 * messageService.getIntro(_, _) >> "I'm Nickelback and"
        "I'm Nickelback and I'm a rockstar." == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "Using a closure"() {
        when:
        def actualMessage = clientService.introduceMe(name, age)

        then:
        1 * messageService.getIntro(_, _) >> { someName, someAge ->
            someAge <= 21 ? "Hello $someName." : "Yo $someName."
        }

        expectedMessage == actualMessage

        where:
        name   | age | expectedMessage
        'Mike' | 21  | "Hello Mike. I'm a rockstar."
        'Kurt' | 90  | "Yo Kurt. I'm a rockstar."
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "At most 1 time"() {
        when:
        def message = clientService.introduceMe('Mike', 21)

        then:
        (_..1) * messageService.getIntro('Mike', 21) >> "I'm Nickelback and"
        "I'm Nickelback and I'm a rockstar." == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "At least 1 time"() {
        when:
        def message = clientService.introduceMe('Mike', 21)

        then:
        (1.._) * messageService.getIntro('Mike', 21) >> "I'm Nickelback and"
        "I'm Nickelback and I'm a rockstar." == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "matching param by type"() {
        when:
        def message = clientService.introduceMe('Mike', 21)

        then:
        1 * messageService.getIntro(_ as String, _ as Integer) >> "I'm Nickelback and"
        "I'm Nickelback and I'm a rockstar." == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "Any person aged 21 that is not Joe"() {
        when:
        def message = clientService.introduceMe('Mike', 21)

        then:
        1 * messageService.getIntro(!"Joe", 21) >> "I'm Nickelback and"
        "I'm Nickelback and I'm a rockstar." == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "Any method from MessageService class is called"() {
        when:
        def message = clientService.introduceMe('Mike', 21)

        then:
        1 * messageService._ >> "I'm Nickelback and"
        "I'm Nickelback and I'm a rockstar." == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "Any class with getIntro() method is called"() {
        when:
        def message = clientService.introduceMe('Mike', 21)

        then:
        1 * _.getIntro('Mike', 21) >> "I'm Nickelback and"
        "I'm Nickelback and I'm a rockstar." == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "Ensure no more methods are being called"() {
        when:
        def message = clientService.introduceMe('Mike', 21)

        then:
        1 * messageService.getIntro('Mike', 21) >> "I'm Nickelback and"
        0 * _
        "I'm Nickelback and I'm a rockstar." == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "Wrapping multiple lines in then block using interaction block"() {
        when:
        def message = clientService.introduceMe('Mike', 21)

        then:
        interaction {
            def totalTimes = 1
            totalTimes * messageService.getIntro('Mike', 21) >> "I'm Nickelback and"
        }

        "I'm Nickelback and I'm a rockstar." == message
    }
}
