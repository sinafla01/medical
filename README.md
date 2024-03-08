### 프로젝트 소개

환자등록, 방문등록 등 API 기능을 구현한 프로젝트입니다.

### 개발 구성

- JDK : 17
- Language : Java
- IDE : IntelliJ
- H2 database

### 사용 플러그인

```groovy
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.testng:testng:7.7.0'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.h2database:h2'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'

	// swagger
	implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0'
	// validation
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	// queryDSL
	implementation 'com.querydsl:querydsl-jpa:5.0.0:jakarta'
	annotationProcessor "com.querydsl:querydsl-apt:5.0.0:jakarta"
	annotationProcessor "jakarta.annotation:jakarta.annotation-api"
	annotationProcessor "jakarta.persistence:jakarta.persistence-api"
```

### 프로젝트 구조

```html
src
├── main
│   ├── generated
│   │   └── com
│   │       └── backend
│   │           └── medical
│   │               └── entity
│   │                   ├── QCode.java
│   │                   ├── QCodeGroup.java
│   │                   ├── QHospital.java
│   │                   ├── QPatient.java
│   │                   └── QVisit.java
│   ├── java
│   │   └── com
│   │       └── backend
│   │           └── medical
│   │               ├── MedicalApplication.java
│   │               ├── api
│   │               │   ├── controller
│   │               │   │   ├── PatientController.java
│   │               │   │   └── VisitController.java
│   │               │   ├── dto
│   │               │   │   ├── PatientDto.java
│   │               │   │   ├── PatientInfoDto.java
│   │               │   │   ├── PatientSaveDto.java
│   │               │   │   ├── PatientTermsDto.java
│   │               │   │   └── VisitDto.java
│   │               │   ├── repository
│   │               │   │   ├── CodeGroupRepository.java
│   │               │   │   ├── CodeRepository.java
│   │               │   │   ├── HospitalRepository.java
│   │               │   │   ├── PatientCustom.java
│   │               │   │   ├── PatientRepository.java
│   │               │   │   ├── VisitRepository.java
│   │               │   │   └── impl
│   │               │   │       └── PatientRepositoryImpl.java
│   │               │   └── service
│   │               │       ├── PatientService.java
│   │               │       ├── PatientServiceImpl.java
│   │               │       ├── VisitService.java
│   │               │       └── VisitServiceImpl.java
│   │               ├── common
│   │               │   ├── ApiExceptionHandler.java
│   │               │   ├── Numbers.java
│   │               │   ├── ResultMsg.java
│   │               │   ├── Util.java
│   │               │   ├── config
│   │               │   │   ├── QueryDSLConfig.java
│   │               │   │   └── SwaggerConfig.java
│   │               │   ├── exception
│   │               │   │   ├── ExistValidException.java
│   │               │   │   └── NotFoundValidException.java
│   │               │   └── response
│   │               │       └── BaseResponse.java
│   │               └── entity
│   │                   ├── Code.java
│   │                   ├── CodeGroup.java
│   │                   ├── Hospital.java
│   │                   ├── Patient.java
│   │                   └── Visit.java
│   └── resources
│       ├── application.yaml
│       ├── static
│       └── templates
└── test
    └── java
        └── com
            └── backend
                └── medical
                    └── MedicalApplicationTests.java
```

### 기능

- 환자
    - 등록
    - 수정
    - 삭제
    - 1건 조회
    - 목록 조회
    - 환자이름, 생년월일, 환자등록코드로 조회
- 방문
    - 등록
    - 수정
    - 삭제

### 프로젝트 설치 및 사용 방법

1. 먼저 repository 를 clone 합니다.

```bash
git clone https://github.com/sinafla01/medical.git
```

1. h2 database 를 실행합니다.
2. clone 받은 프로젝트를 IDE 툴로 실행합니다.
3. 사용되는 플러그인이 설치가 완료되기를 기다립니다.
4. 오른쪽 상단에 Run 버튼을 클릭하여 실행합니다.
5. 사이트 주소창에 http://localhost:8080/swagger/index.html 주소를 입력해 swagger 를 이용하면 됩니다.
