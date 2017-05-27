package net.jayanth.review

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.security.access.prepost.PreAuthorize

/**
 * Created by jmp on 5/5/2017.
 */
interface ReviewRepository : PagingAndSortingRepository<Review, Long>{

    @PreAuthorize("hasRole('ROLE_ADMIN') or #review.reviewer?.userName == authentication.name")
    override fun delete(@Param("review")entity: Review?) {
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or @reviewRepository.findOne(#id)?.reviewer?.userName == authentication.name")
    override fun delete(@Param("id")id: Long?) {
    }
}