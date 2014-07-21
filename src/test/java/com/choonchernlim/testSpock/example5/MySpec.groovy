package com.choonchernlim.testSpock.example5

import com.choonchernlim.testSpock.bean.PersonBean
import spock.lang.Specification

/**
 * Using `old(...)` to access the previous object state. An easy way to compare "before" and "after" object state.
 */
class MySpec extends Specification {

    def "adding a value to existing list"() {
        given:
        def list = ['Jane']

        when:
        list << 'Mike'

        then:
        // current state
        list.size() == 2
        list[0] == 'Jane'
        list[1] == 'Mike'

        // previous state
        old(list.size()) == 1
        old(list[0]) == 'Jane'
    }

    def "changing person from Mike to Kurt"() {
        given:
        def person = new PersonBean(name: 'Mike', age: 10)

        when:
        person.name = 'Kurt'
        person.age = 20

        then:
        // current state
        person.toString() == 'I am Kurt and I am 20 years old.'

        // previous state
        old(person.toString()) == 'I am Mike and I am 10 years old.'
    }
}
