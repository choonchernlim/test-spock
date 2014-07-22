package com.choonchernlim.testSpock.example3

import com.choonchernlim.testSpock.bean.PersonBean
import com.choonchernlim.testSpock.service.MessageService
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Multiple assertions with `where` using table and left shift operator. Using `@Unroll` to separate assertions into isolated test case.
 */
class MessageServiceSpec extends Specification {
    def messageService = new MessageService()

    def "where block with left shift operator"() {
        expect:
        "Hello, my name is $name. I'm $age years old." == messageService.getIntro(name, age)

        where:
        name << ['Mike', 'Kurt', 'Jason']
        age << [10, 20, 30]
    }

    def "where block with data table"() {
        expect:
        result == messageService.getIntro(name, age)

        where:
        name    | age | result
        'Mike'  | 10  | "Hello, my name is Mike. I'm 10 years old."
        'Kurt'  | 20  | "Hello, my name is Kurt. I'm 20 years old."
        'Jason' | 30  | "Hello, my name is Jason. I'm 30 years old."
    }

    @Unroll
    def "using @Unroll with where block with data table"() {
        expect:
        result == messageService.getIntro(name, age)

        where:
        name    | age | result
        'Mike'  | 10  | "Hello, my name is Mike. I'm 10 years old."
        'Kurt'  | 20  | "Hello, my name is Kurt. I'm 20 years old."
        'Jason' | 30  | "Hello, my name is Jason. I'm 30 years old."
    }

    @Unroll("where block with name #name and age #age")
    def "using custom label @Unroll with where block with data table"() {
        expect:
        result == messageService.getIntro(name, age)

        where:
        name    | age | result
        'Mike'  | 10  | "Hello, my name is Mike. I'm 10 years old."
        'Kurt'  | 20  | "Hello, my name is Kurt. I'm 20 years old."
        'Jason' | 30  | "Hello, my name is Jason. I'm 30 years old."
    }

    @Unroll
    def "Name is #name aged #age years old"() {
        expect:
        result == messageService.getIntro(name, age)

        where:
        name    | age | result
        'Mike'  | 10  | "Hello, my name is Mike. I'm 10 years old."
        'Kurt'  | 20  | "Hello, my name is Kurt. I'm 20 years old."
        'Jason' | 30  | "Hello, my name is Jason. I'm 30 years old."
    }

    @Unroll
    def "Name is #person.name aged #person.age years old"() {
        expect:
        person.toString() == expectedToString

        where:
        person                                | expectedToString
        new PersonBean(name: 'Mike', age: 10) | 'I am Mike and I am 10 years old.'
        new PersonBean(name: 'Kurt', age: 20) | 'I am Kurt and I am 20 years old.'
    }
}
