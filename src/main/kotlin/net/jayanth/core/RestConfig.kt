package net.jayanth.core

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter
import org.springframework.validation.Validator


@Configuration
open class RestConfig : RepositoryRestConfigurerAdapter {

    //Does not work!, Don't know why


    @Qualifier("defaultValidator") @Autowired
    private var validator : Validator

    constructor(validator : Validator) : super(){
        this.validator = validator
    }

    override fun configureValidatingRepositoryEventListener(validatingListener: ValidatingRepositoryEventListener?) {
        validatingListener?.addValidator("beforeCreate", validator)
        validatingListener?.addValidator("beforeSave", validator)
    }
}
