package gtest01

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TestASpec extends Specification implements DomainUnitTest<TestA> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
