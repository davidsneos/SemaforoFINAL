package semaforo


import grails.test.mixin.*
import spock.lang.*

@TestFor(OperarioController)
@Mock(Operario)
class OperarioControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.operarioInstanceList
        model.operarioInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.operarioInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def operario = new Operario()
        operario.validate()
        controller.save(operario)

        then: "The create view is rendered again with the correct model"
        model.operarioInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        operario = new Operario(params)

        controller.save(operario)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/operario/show/1'
        controller.flash.message != null
        Operario.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def operario = new Operario(params)
        controller.show(operario)

        then: "A model is populated containing the domain instance"
        model.operarioInstance == operario
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def operario = new Operario(params)
        controller.edit(operario)

        then: "A model is populated containing the domain instance"
        model.operarioInstance == operario
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/operario/index'
        flash.message != null


        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def operario = new Operario()
        operario.validate()
        controller.update(operario)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.operarioInstance == operario

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        operario = new Operario(params).save(flush: true)
        controller.update(operario)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/operario/show/$operario.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/operario/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def operario = new Operario(params).save(flush: true)

        then: "It exists"
        Operario.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(operario)

        then: "The instance is deleted"
        Operario.count() == 0
        response.redirectedUrl == '/operario/index'
        flash.message != null
    }
}
