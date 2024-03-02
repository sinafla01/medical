package com.backend.medical.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "환자 등록 및 수정, 조회")
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
}
