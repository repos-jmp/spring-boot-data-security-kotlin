package net.jayanth.review

import net.jayanth.core.BaseEntity
import net.jayanth.course.Course
import javax.persistence.*
import net.jayanth.user.User

/**
 * Created by jmp on 5/5/2017.
 */


@Entity
class Review
constructor(
    var rating: Int,
    var description: String,
    @ManyToOne
    var reviewer : User

) : BaseEntity()
{
    @ManyToOne
    var course: Course? = null
}