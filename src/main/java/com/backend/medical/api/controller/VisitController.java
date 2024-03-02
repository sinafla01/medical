package com.backend.medical.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "환자방문")
@RestController
@RequestMapping("/api/v1/visit")
public class VisitController {
}
