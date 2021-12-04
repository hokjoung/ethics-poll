package kr.ac.kaist.ethics.db.core.school

import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository : JpaRepository<Question, Long> {
}