package com.choonchernlim.testSpock.example6

import com.choonchernlim.testSpock.service.ClientService
import com.choonchernlim.testSpock.service.MessageService
import spock.lang.Specification

/**
 * Creating mock object using `Mock()`. `cglib-nodep` is required when mocking concrete classes.
 */
class ClientServiceSpec extends Specification {

    def "no mocking"() {
        given:
        def messageService = new MessageService()
        def clientService = new ClientService(messageService)

        when:
        def message = clientService.greet('Mike')

        then:
        "Hello! What's up, Mike?" == message
    }

    def "mocking MessageService"() {
        given:
        def messageService = Mock(MessageService)
        def clientService = new ClientService(messageService)

        when:
        def message = clientService.greet('Mike')

        then:
        1 * messageService.getMessage() >> 'Yo'
        "Yo! What's up, Mike?" == message
    }

    def "mocking MessageService to return a different value on every call"() {
        given:
        def messageService = Mock(MessageService)
        def clientService = new ClientService(messageService)

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

    def "alternative approach - mocking MessageService to return a different value on every call"() {
        given:
        def messageService = Mock(MessageService)
        def clientService = new ClientService(messageService)

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
