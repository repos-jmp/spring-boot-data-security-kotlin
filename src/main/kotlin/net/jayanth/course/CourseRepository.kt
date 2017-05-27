package net.jayanth.course

import org.springframework.data.domain.Page
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RestResource
import java.awt.print.Pageable

/**
 * Created by jmp on 5/5/2017.
 */
interface CourseRepository : PagingAndSortingRepository<Course, Long> {
    @RestResource(rel = "title-contains", path ="containsTitle")
    fun findByTitleContaining(@Param("title") title : String, pageable: org.springframework.data.domain.Pageable) : Page<Course>
}