package net.jayanth.course

import net.jayanth.core.BaseEntity
import net.jayanth.review.Review
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by jmp on 5/5/2017.
 */

@Entity
class Course
constructor(
    @Size(min=2, max=140)
    var title: String,
    var url: String
) : BaseEntity()
{
    @OneToMany(mappedBy = "course", cascade = arrayOf(CascadeType.ALL))
    var reviews: MutableList<Review> = mutableListOf()

    fun addReview(review : Review){
        review.course = this
        reviews.add(review)
    }

}