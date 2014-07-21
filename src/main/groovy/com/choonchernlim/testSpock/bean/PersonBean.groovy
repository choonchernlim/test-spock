package com.choonchernlim.testSpock.bean

class PersonBean {
    String name
    String age

    @Override
    String toString() {
        "I am $name and I am $age years old."
    }
}
