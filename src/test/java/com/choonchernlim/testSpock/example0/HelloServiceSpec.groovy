package com.choonchernlim.testSpock.example0

import spock.lang.Specification

class HelloServiceSpec extends Specification {
    def helloService = new HelloService()

    def "say hello"() {
        expect:
        helloService.say() == 'hello'
    }
}
