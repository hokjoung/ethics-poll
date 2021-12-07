package kr.ac.kaist.ethics.db.core.school

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "question")
data class Question(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0L,

    @Column(name = "question")
    val question: String,

    @Column(name = "option1")
    val option1: String,

    @Column(name = "option2")
    val option2: String
)
