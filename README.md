# 3조 삼삼오오(三三五五)
☁ 구름(goorm) 풀스택 개발자 성장 과정 1차 스터디 3️⃣조 삼삼오오를 소개합니다.

<br />

🖥 [**바로가기(Web)**](https://port-0-introduce3355-private-20zynm2mljnlngk9.sel4.cloudtype.app/) / 📱 [**바로가기(App)**](https://goorm-fullstack.github.io/Introduce3355-App/)

<br />

## 🔍 프로젝트 개요
- **개발 목적:** CRUD 실습, 소프트 스킬 향상을 위한 협업 경험 쌓기
- **개발 기간:** 2023.06.24~2023.06.30(총 7일)
- **최종 배포:** 2023.07.04

<br />

## 😎 조원 소개

| 김경규 | 문소희 | 배진환 | 이정원 |
| :-: | :-: | :-: | :-: |
| ![@WhiteKIM](https://github.com/goorm-fullstack/Introduce-3355/assets/121299334/24f71bb9-12bb-4b29-9e2b-73461af0635d) | ![@soheetech](https://github.com/goorm-fullstack/Introduce-3355/assets/121299334/24c6f23b-8952-4e02-9347-ba42f5b67bc8)|![@JinhwanB](https://github.com/goorm-fullstack/Introduce-3355/assets/121299334/c503b06b-188f-4041-abf8-4041093d80a0) |![@location132](https://avatars.githubusercontent.com/u/132702102?s=400&u=6f737d6488385275e81424b52b6bcdc96fa3ce6a&v=4)|
| [@WhiteKIM](https://github.com/WhiteKIM) | [@soheetech](https://github.com/soheetech) | [@JinhwanB](https://github.com/JinhwanB) | [@location132](https://github.com/location132) |
| 조원 | 조원 | 조장 | 조원 |
| 백엔드 개발자 | 풀스택 개발자 | 백엔드 개발자 | APP(iOS) 개발자 |
| 방명록, 로그인 구현 | 조원 피드백 구현 | 조원 정보 구현 | APP 제작 |

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

<table>
	<tr>
		<th>메인화면</th>
		<th>조원소개</th>
		<th>로그인</th>
	</tr>
	<tr>
		<td valign="top"><img src="https://github.com/goorm-fullstack/Introduce3355/assets/121299334/717a75b0-846b-40ff-85ed-582ee328cce9" alt="index"></td>
		<td valign="top"><img src="https://github.com/goorm-fullstack/Introduce3355/assets/121299334/f604ef20-d9d8-4fbc-a965-febbbd137d4b"></td>
		<td valign="top"><img src="https://github.com/goorm-fullstack/Introduce3355/assets/121299334/95f61ccd-b47b-4f0b-95e2-3368a8dc8005" alt="login"></td>
	</tr>
</table>

<br />

## ✨ 주요 기능
- **조원 정보 CRUD:** 관리자 로그인 시 `생성, 수정, 삭제` 가능, 누구나 `읽기` 가능
- **조원 피드백 CRUD:** 관리자 로그인 시 `생성, 수정, 삭제` 가능, 누구나 `읽기` 가능
- **방명록 CRUD:** 누구나 `생성, 읽기, 수정, 삭제` 가능, `수정, 삭제` 할 때 생성시 입력한 비밀번호 작성 필요
- **관리자 로그인:** 미리 DB에 생성한 계정 1개 공유, 조원 정보/피드백 `생성, 수정, 삭제` 용도

<br />

## 📁 아키텍쳐

```
INTRODUCE3355
├─gradle
│  └─wrapper
└─src
    ├─main
    │  ├─java
    │  │  └─Goorm
    │  │      └─Introduce
    │  │          ├─Domain
    │  │          │  ├─Comment
    │  │          │  ├─Config
    │  │          │  ├─FeedBack
    │  │          │  ├─FireBase
    │  │          │  │  ├─Comment
    │  │          │  │  ├─FeedBack
    │  │          │  │  ├─Member
    │  │          │  │  └─User
    │  │          │  ├─Member
    │  │          │  └─User
    │  │          └─Web
    │  │              ├─comment
    │  │              ├─FeedBack
    │  │              ├─Interceptor
    │  │              └─member
    │  └─resources
    │      ├─static
    │      │  └─assets
    │      │      ├─css
    │      │      ├─images
    │      │      └─js
    │      └─templates
    │          ├─includes
    │          └─pages
    └─test
        ├─java
        │  └─Goorm
        │      └─Introduce
        └─resources
            └─templates
                └─Member
```

<br />

## 📌 특이사항
- 변경/수정이 있는 경우 주석 또는 커밋 메시지, `README.md` 작성하기
- 그 외 프로젝트 관련 사항(기획서, 파일 공유 등)은 노션 페이지 프로젝트란에 기록하기
- 노션 페이지 정보 공유 시 확인이 필요한 내용은 슬랙으로 확인 요청하기

<br />

## 👩🏻‍💻👨🏻‍💻 작업 기록

- `2023.06.24` 환경 세팅: firebase 연동 확인, 로그인 기능 구현
- `2023.06.25` 방명록 구현, 파이어베이스 레퍼런스ID 등록, 기능 수정
- `2023.06.26` 프론트 통합 및 정리(확인용), 방명록 CRUD, 디자인 확정
- `2023.06.27` 프론트 역할 분담 및 구현: HTML, CSS, JS
- `2023.06.28` 프론트 통합 및 정리, 방명록 CRUD/로그인 기능 수정
- `2023.06.29` 조원 정보/피드백 CRUD
- `2023.06.30` 전체 통합 완료 및 오류 수정
- `2023.07.04` 배포 완료

<br />

## 🎉 에필로그: TOP5!
모두 고생 많으셨습니다! 원하는 회사 취업 성공하시길 바랍니다.🤗

![TOP5](https://github.com/goorm-fullstack/Introduce3355/assets/121299334/0730bdc3-df47-4fb4-8896-746c7a74cd07)
