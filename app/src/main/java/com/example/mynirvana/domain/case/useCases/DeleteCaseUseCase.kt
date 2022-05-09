package com.example.mynirvana.domain.case.useCases

import com.example.mynirvana.domain.case.model.Case
import com.example.mynirvana.domain.case.repository.CaseRepository

class DeleteCaseUseCase(private val caseRepository: CaseRepository) {
    suspend fun invoke(case: Case) {
        caseRepository.deleteCase(case)
    }
}