package kr.ac.kaist.ethics.db.core.school

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "answer")
data class Answer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0L,

    @Column(name = "ref_question_id")
    val refQuestionId: Long,

    @Column(name = "client_id")
    val clientId: String?,

    @Column(name = "selection")
    val selection: Int
)
