package com.choonchernlim.testSpock.example1

import spock.lang.Specification

/**
 * Using "when, then" construct and "expect" construct. Use "expect" if "when, then" doesn't make sense.
 */
class MySpec extends Specification {

    def "using given, when and then"() {
        given:
        def stack = new Stack()

        when:
        stack.push('Mike')

        then:
        stack.size() == 1
        stack.peek() == 'Mike'
    }

    def "using given, when and then with readable labels"() {
        given: "New stack"
        def stack = new Stack()

        when: "Add Mike into the stack"
        stack.push('Mike')

        then: "Stack should have 1 item called Mike"
        stack.size() == 1
        stack.peek() == 'Mike'
    }

    def "using expect"() {
        expect:
        2 == Math.abs(-2)
    }
}
