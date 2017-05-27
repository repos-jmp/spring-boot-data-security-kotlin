package net.jayanth.core

import org.springframework.data.annotation.Version
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * Created by jmp on 5/5/2017.
 */

@MappedSuperclass
abstract class BaseEntity protected constructor() {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private var id:Long? = null
    @javax.persistence.Version
    private var version:Long? = null
}