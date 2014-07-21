package com.choonchernlim.testSpock.example6

import com.choonchernlim.testSpock.service.ClientService
import com.choonchernlim.testSpock.service.MessageService
import spock.lang.Specification

/**
 * Creating mock object using `Mock()`. `cglib-nodep` is required when mocking concrete classes.
 */
class ClientServiceSpec extends Specification {

    def messageService = Mock(MessageService)
    def clientService = new ClientService(messageService)

    def "no mocking"() {
        given:
        def actualMessageService = new MessageService()
        def actualClientService = new ClientService(actualMessageService)

        when:
        def message = actualClientService.greet('Mike')

        then:
        "Hello! What's up, Mike?" == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "simple mock"() {
        when:
        def message = clientService.greet('Mike')

        then:
        1 * messageService.getMessage() >> 'Yo'
        "Yo! What's up, Mike?" == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "Using closure for multi-line computations"() {
        when:
        def message = clientService.greet('Mike')

        then:
        1 * messageService.getMessage() >> {
            def val = ''

            3.times {
                val += 'Boink ';
            }

            val.trim()
        }

        "Boink Boink Boink! What's up, Mike?" == message
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "A different value on every call"() {
        when:
        def mikeMessage = clientService.greet('Mike')
        def kurtMessage = clientService.greet('Kurt')
        def coryMessage = clientService.greet('Cory')

        then:
        3 * messageService.getMessage() >>> ['Yo', 'Dude', 'Hey']
        "Yo! What's up, Mike?" == mikeMessage
        "Dude! What's up, Kurt?" == kurtMessage
        "Hey! What's up, Cory?" == coryMessage
    }

    @SuppressWarnings("GroovyAssignabilityCheck")
    def "alternative approach - A different value on every call"() {
        when:
        def message = clientService.greet(name)

        then:
        1 * messageService.getMessage() >> salutation
        "$salutation! What's up, $name?" == message

        where:
        salutation | name
        'Yo'       | 'Mike'
        'Dude'     | 'Kurt'
        'Hey'      | 'Cory'
    }
}
