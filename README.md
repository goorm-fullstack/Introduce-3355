
# 3조 삼삼오오(三三五五)
☁ 구름(goorm) 풀스택 개발자 성장 과정 1차 스터디 3️⃣조 삼삼오오를 소개합니다.

<br />

🖥 [**바로가기(Web)**](https://goorm-fullstack.github.io/Introduce3355/) / 📱 [**바로가기(App)**](https://goorm-fullstack.github.io/Introduce3355-App/)

<br />

## 🔍 프로젝트 개요
- **개발 목적:** CRUD 실습, 협업 경험 쌓기
- **개발 기간:** 2023.06.24~2023.06.30(총 7일)

<br />

## 😎 조원 소개

| 김경규 | 문소희 | 배진환 | 이정원 |
| :-: | :-: | :-: | :-: |
| ![@WhiteKIM](https://github.com/goorm-fullstack/Introduce-3355/assets/121299334/24f71bb9-12bb-4b29-9e2b-73461af0635d) | ![@soheetech](https://github.com/goorm-fullstack/Introduce-3355/assets/121299334/24c6f23b-8952-4e02-9347-ba42f5b67bc8)|![@JinhwanB](https://github.com/goorm-fullstack/Introduce-3355/assets/121299334/c503b06b-188f-4041-abf8-4041093d80a0) |![@location132](https://avatars.githubusercontent.com/u/132702102?s=400&u=6f737d6488385275e81424b52b6bcdc96fa3ce6a&v=4)|
| [@WhiteKIM](https://github.com/WhiteKIM) | [@soheetech](https://github.com/soheetech) | [@JinhwanB](https://github.com/JinhwanB) | [@location132](https://github.com/location132) |
| 조원 | 조원 | 조장 | 조원 |
| 백엔드 개발자 | 풀스택 개발자 | 백엔드 개발자 | APP(iOS) 개발자 |
| 방명록, 로그인 구현 | 조원 평가 구현 | 조원 정보 구현 | APP 제작 |

<br />

## 💻 개발 환경


### Front-End
<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">


### Back-End
<img src="https://img.shields.io/badge/java 17-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/spring 3.1.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white">


### APP
<img src="https://img.shields.io/badge/Dart-0175C2?style=for-the-badge&logo=Dart&logoColor=white"> <img src="https://img.shields.io/badge/flutter-02569B?style=for-the-badge&logo=flutter&logoColor=white">


### DB
<img src="https://img.shields.io/badge/firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black">


### Collaboration
<img src="https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white"> <img src="https://img.shields.io/badge/Discord-5865F2?style=for-the-badge&logo=Discord&logoColor=white"> <img src="https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=Slack&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">

<br />

## 📝 화면 구성
추가 예정

<br />

## ✨ 주요 기능
- **조원 정보 CRUD:** 관리자 로그인 시 `생성, 수정, 삭제` 가능, 누구나 `읽기` 가능
- **조원 평가 CRUD:** 관리자 로그인 시 `생성, 수정, 삭제` 가능, 누구나 `읽기` 가능
- **방명록 CRUD:** 누구나 `생성, 읽기, 수정, 삭제` 가능, `수정, 삭제` 할 때 생성시 입력한 비밀번호 작성 필요
- **관리자 로그인:** 미리 DB에 생성한 계정 1개 공유, 조원 정보/평가 `생성, 수정, 삭제` 용도

<br />

## 📁 아키텍쳐

```
디렉토리 구조 추가 예정
```

<br />

## 📌 특이사항
- 변경/수정이 있는 경우 주석 또는 커밋 메시지, `README.md` 작성하기
- 그 외 프로젝트 관련 사항(기획서, 파일 공유 등)은 노션 페이지 프로젝트란에 기록하기
- 노션 페이지 정보 공유 시 확인이 필요한 내용은 슬랙으로 확인 요청하기

<br />

## 👩🏻‍💻👨🏻‍💻 작업 기록

- `2023.06.24 김경규` firebase 연동 확인
  + `crud` 기능 구현 예정
  + `로그인` 기능 확인, 로그인 사용자와 아닌 사용자 헤더 분리 확인, 로그인 기능 구현✅
- `2023.06.25 김경규`(삭제된 기능은 내용 수정 부탁드려요.)
  + `조원평가` 등록 기능 구현✅, 페이지 등록 ID를 파이어베이스 레퍼런스 아이디로 사용✅
  + `조원평가` 코멘트 등록 기능 구현✅, 등록된 코멘트가 내가 등록한 페이지에서만 보여지는지 확인✅
  + `관리자` 권한없는 사용자가 admin페이지로 들어가지 않도록 인터셉터 구현✅
  + `DB` 파이어베이스 일부 기능 변경 및 추가
  + `Board` 모든 게시글 가져오기 기능 추가됨
  + `Comment` findByBoardIdComment 함수 추가: 게시글에 달린 모든 코멘트를 가져옴

- `2023.6.26 김경규`
  + `HTML` : 통합 완료 -> 공통 내용 분리✅
  + `Comment` : 비밀번호 대조를 제외한 CRUD 완료 ✅
- `2023.06.28 김경규`
  + `HTML` : 통합 완료 -> 방명록 CRUD 기능, 로그인 기능 확인 완료✅
- `2023.06.30 김경규`
  + 전체적인 통합 완료✅
