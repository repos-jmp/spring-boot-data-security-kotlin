package net.jayanth.user

import com.fasterxml.jackson.annotation.JsonIgnore
import net.jayanth.core.BaseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.persistence.Entity

@Entity
class User : BaseEntity {

    //val passwordEncoder : PasswordEncoder
    var userName:String
    var firstName:String
    var lastName:String
    @JsonIgnore
    var password:String /*set(value) { field = passwordEncoder.encode(password)}*/
    @JsonIgnore
    var roles = arrayOf<String>()

    init {
        //passwordEncoder = BCryptPasswordEncoder()
    }

    constructor(userName:String, firstName:String, lastName:String, password:String, roles:Array<String>) : super()
    {
        this.userName = userName
        this.firstName = firstName
        this.lastName = lastName
        //this.password = passwordEncoder.encode(password)
        this.password = password
        this.roles = roles
    }

}
