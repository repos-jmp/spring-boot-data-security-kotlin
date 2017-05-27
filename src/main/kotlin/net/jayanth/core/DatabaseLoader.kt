package net.jayanth.core

import net.jayanth.course.Course
import net.jayanth.course.CourseRepository
import net.jayanth.review.Review
import net.jayanth.user.User
import net.jayanth.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.util.stream.IntStream

/**
 * Created by jmp on 5/5/2017.
 */
@Component
class DatabaseLoader @Autowired constructor (val courses : CourseRepository, val users : UserRepository) : ApplicationRunner {

    override fun run(p0: ApplicationArguments?) {

        val templates = arrayOf(
                "Up and Running with %s",
                "%s Basics",
                "%s for Beginners",
                "%s for Neckbeards",
                "Under the hood: %s")
        val buzzwords = arrayOf(
                "Spring REST Data",
                "Java 9",
                "Scala",
                "Groovy",
                "Hibernate",
                "Spring HATEOAS")

        var students = arrayListOf(
                User("jacobproffer", "Jacob",  "Proffer", "password", arrayOf("ROLE_USER")),
                User("mlnorman", "Mike",  "Norman", "password", arrayOf("ROLE_USER")),
                User("k_freemansmith", "Karen",  "Freeman-Smith", "password", arrayOf("ROLE_USER")),
                User("seth_lk", "Seth",  "Kroger", "password", arrayOf("ROLE_USER")),
                User("mrstreetgrid", "Java",  "Vince", "password", arrayOf("ROLE_USER")),
                User("anthonymikhail", "Tony",  "Mikhail", "password", arrayOf("ROLE_USER")),
                User("boog690", "AJ",  "Teacher", "password", arrayOf("ROLE_USER")),
                User("faelor", "Erik",  "Faelor Shafer", "password", arrayOf("ROLE_USER")),
                User("christophernowack", "Christopher",  "Nowack", "password", arrayOf("ROLE_USER")),
                User("calebkleveter", "Caleb",  "Kleveter", "password", arrayOf("ROLE_USER")),
                User("richdonellan", "Rich",  "Donnellan", "password", arrayOf("ROLE_USER")),
                User("albertqerimi", "Albert",  "Qerimi", "password", arrayOf("ROLE_USER")),
                User("jayanth", "John",  "Doe", "password", arrayOf("ROLE_USER", "ROLE_ADMIN"))
        )
        users.save(students)

        var bunchOfCourses : MutableList<Course> = mutableListOf()
        IntStream.range(0, 100)
                .forEach({
                    value ->
                    val template = templates[value % templates.size]
                    val buzzword = buzzwords[value % buzzwords.size]
                    val title = String.format(template, buzzword)
                    val aCourse = Course(title, "http://www.jayanth.net/")
                    val review = Review((value % 5) + 1, String.format("Moar $buzzword please!!!", buzzword), students.get(value % students.size))
                    aCourse.addReview(review)
                    bunchOfCourses.add(aCourse)
        })
        courses.save(bunchOfCourses)
    }
}