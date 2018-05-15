package gtest01

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TestAController {

    TestAService testAService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond testAService.list(params), model:[testACount: testAService.count()]
    }

    def show(Long id) {
        respond testAService.get(id)
    }

    def create() {
        respond new TestA(params)
    }

    def save(TestA testA) {
        if (testA == null) {
            notFound()
            return
        }

        try {
            testAService.save(testA)
        } catch (ValidationException e) {
            respond testA.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'testA.label', default: 'TestA'), testA.id])
                redirect testA
            }
            '*' { respond testA, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond testAService.get(id)
    }

    def update(TestA testA) {
        if (testA == null) {
            notFound()
            return
        }

        try {
            testAService.save(testA)
        } catch (ValidationException e) {
            respond testA.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'testA.label', default: 'TestA'), testA.id])
                redirect testA
            }
            '*'{ respond testA, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        testAService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'testA.label', default: 'TestA'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'testA.label', default: 'TestA'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
