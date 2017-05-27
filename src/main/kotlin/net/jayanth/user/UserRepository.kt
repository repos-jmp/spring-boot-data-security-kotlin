package net.jayanth.user

import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * Created by jmp on 5/6/2017.
 */

@RepositoryRestResource(exported = false)
interface UserRepository : CrudRepository<User, Long>{
    fun findByUserName(userName:String) : User
}