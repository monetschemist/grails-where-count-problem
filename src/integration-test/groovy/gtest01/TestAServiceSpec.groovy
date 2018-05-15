package gtest01

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TestAServiceSpec extends Specification {

    TestAService testAService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TestA(...).save(flush: true, failOnError: true)
        //new TestA(...).save(flush: true, failOnError: true)
        //TestA testA = new TestA(...).save(flush: true, failOnError: true)
        //new TestA(...).save(flush: true, failOnError: true)
        //new TestA(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //testA.id
    }

    void "test get"() {
        setupData()

        expect:
        testAService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TestA> testAList = testAService.list(max: 2, offset: 2)

        then:
        testAList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        testAService.count() == 5
    }

    void "test delete"() {
        Long testAId = setupData()

        expect:
        testAService.count() == 5

        when:
        testAService.delete(testAId)
        sessionFactory.currentSession.flush()

        then:
        testAService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TestA testA = new TestA()
        testAService.save(testA)

        then:
        testA.id != null
    }
}
