package net.jayanth.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class DetailsService(@Autowired var users: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(userName:String): UserDetails {
        val user = users.findByUserName(userName)
        return org.springframework.security.core.userdetails.User(user.userName, user.password, AuthorityUtils.createAuthorityList(*user.roles))
    }
}
