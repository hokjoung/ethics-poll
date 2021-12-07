package kr.ac.kaist.ethics.db.core.school

import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository : JpaRepository<Answer, Long> {
    fun findFirstByRefQuestionIdAndClientId(refQuestionId: Long, clientId: String): Answer?
}