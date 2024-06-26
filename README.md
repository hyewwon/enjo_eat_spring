# Enjo-eat
메뉴 및 음식점 추천 사이트


## 프로젝트 소개
### 프로젝트 개요
지역 혹은 특정 목적별로 음식점들을 모아 놓은 테마를 만들고 사용자들끼리 음식점 정보를 공유 가능

원하는 지역이나 종류를 지정해 쉽고 재밌게 음식점을 선택할 수 있는 사이트.

### 개발 기간
- 2024.01.05 ~ 2024.02.10

### 개발 환경
- FrontEnd : HTML5, CSS3, Vanilla JS, Fetch, Bootstrap
- BackEnd : Java 17, Spring Boot 3
- ORM : Maria DB
- IDE : Intellij
- API : REST, Kakao map 

### 주요 기능  
#### 0. 전채 프로젝트 구조 
WEB과 API로 분리 : 페이지 띄우기 (WEB) / 데이터 처리는 Fetch와 REST를 사용한 비동기 처리 (API)

#### 1. 사용자 인증
Spring Security를 통한 사용자 인증과 페이지 권한 설정

#### 2. 테마 및 음식점 게시판
- 이미지 업로드를 포함한 CRUD 구현
- Kakao 지도 API를 사용하여 음식점의 위치를 검색 후 선택해서 입력하도록 적용
- 테마 공개 여부에 따라서 다른 사용자의 게시물 등록 제한
- 댓글 등록, 삭제 기능
#### 3. 음식점 선택
- 등록된 음식점 목록을 랜덤으로 배열
  
