package net.jayanth.review

import net.jayanth.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.rest.core.annotation.HandleBeforeCreate
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

/**
 * Created by jmp on 5/18/2017.
 */

@Component
@RepositoryEventHandler
class ReviewEventHandler(@Autowired val users: UserRepository)
{
    @HandleBeforeCreate
    fun addReviewerBasedOnLoggedInUser(review: Review){
        val username = SecurityContextHolder.getContext().authentication.name
        val user = users.findByUserName(username)
        review.reviewer = user
    }
}