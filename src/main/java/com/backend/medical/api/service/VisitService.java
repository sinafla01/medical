package com.backend.medical.api.service;

import com.backend.medical.api.dto.VisitDto;
import com.backend.medical.entity.Visit;
import org.springframework.stereotype.Service;

@Service
public interface VisitService {
    // 방문 등록
    Visit save(VisitDto visitDto);

    // 방문정보 수정
    Visit update(VisitDto visitDto);

    // 방문정보 삭제
    void delete(long visitId);
}
