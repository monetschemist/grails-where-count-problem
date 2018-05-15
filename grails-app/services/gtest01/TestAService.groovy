package gtest01

import grails.gorm.services.Service

@Service(TestA)
interface TestAService {

    TestA get(Serializable id)

    List<TestA> list(Map args)

    Long count()

    void delete(Serializable id)

    TestA save(TestA testA)

}