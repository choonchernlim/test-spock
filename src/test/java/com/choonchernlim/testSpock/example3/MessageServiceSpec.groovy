package com.choonchernlim.testSpock.example3

import com.choonchernlim.testSpock.service.MessageService
import spock.lang.Specification

/**
 * Multiple assertions with `where` using table and left shift operator.
 */
class MessageServiceSpec extends Specification {
    def messageService = new MessageService()

    def "where block with data table"() {
        expect:
        result == messageService.getIntro(name, age)

        where:
        name    | age | result
        'Mike'  | 10  | "Hello, my name is Mike. I'm 10 years old."
        'Kurt'  | 20  | "Hello, my name is Kurt. I'm 20 years old."
        'Jason' | 30  | "Hello, my name is Jason. I'm 30 years old."
    }

    def "where block with left shift operator"() {
        expect:
        "Hello, my name is $name. I'm $age years old." == messageService.getIntro(name, age)

        where:
        name << ['Mike', 'Kurt', 'Jason']
        age << [10, 20, 30]
    }


}
