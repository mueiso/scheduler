# ▶ Scheduler 프로젝트 ◀

JDK version 17

## ✅ 목적

**간단한 일정 관리 앱 만들기**

일정을 생성, 조회, 수정, 삭제 가능한 Scheduler 앱을 만드는 것이 목표이다.

-----

## ✅ 주요기능

✔️ **일정 추가 (`POST`)** :

\- 일정의 제목, 내용, 작성자명을 기입하여 일정을 생성할 수 있다.

\- 추후의 수정과 삭제 기능에 권한이 있는 사람을 구분하기 위해 비밀번호를 함께 기입하여야 한다.

\- 생성 시 현재 날짜와 시간이 함께 자동으로 저장된다.

✔️ **일정 단일 조회 (`GET`)** :

\- 일정의 id(식별자)를 통해 일정 검색이 가능하다.

\- 일정의 id, title, contents, editedAt 을 보여준다.

✔️ **일정 목록 조회 (`GET`)** : 생성된 모든 일정 목록을 볼 수 있다.

✔️ **일정 수정 (`PUT`)** : 일정을 생성할 때 함께 기입한 비밀번호와 일치하는 비밀번호를 기입 시 일정의 제목 및 내용을 수정할 수 있다.

✔️ **일정 삭제 (`DELETE`)** : 일치하는 비밀번호 기입 시 일정을 삭제할 수 있다.

-----

-----

## ✅ API 명세서

|     기능     | Method |    URL     | Path Variable | Request Parameter |                               Request Body                                |                                      Response                                      |     상태코드     |
|:----------:|:------:|:----------:|:-------------:|:-----------------:|:-------------------------------------------------------------------------:|:----------------------------------------------------------------------------------:|:------------:|
|   스케줄 생성   |  POST  | /schedules |       X       |         X         | {<br/>"title": "제목",<br/>"contents": "할 일 내용",<br/>"writer": "작성자명"<br/>} | {<br/>"id": 1,<br/>"title": 제목1,<br/>"contents": 할 일 내용1,<br/>"writer": 작성자명<br/>} |  200: 정상등록   |
| 스케줄 단건 조회  |  GET   |   /{id}    |   id (Long)   |         X         |                                     X                                     |    {<br/>"id": 1,<br/>"title": 제목1,<br/>"contents": 할 일 내용1,<br/>"writer": 작성자명    |  200: 정상조회   |
| 스케줄 수정(전체) |  PUT   |   /{id}    |   id (Long)   |         X         |             {<br/>"title": "수정된 제목",<br/>"contents": "수정된 내용"             | {<br/>"id": 1,<br/>"title": "수정된 제목",<br/>"contents": "수정된 내용",<br/>"writer": 작성자명 |  200: 정상수정   |
|   스케줄 삭제   | DELETE |   /{id}    |   id (Long)   |         X         |                                     X                                     |                                  "msg": "일정 삭제 완료"                                  |  200: 정상삭제   |

-----

-----

## ✅ ERD

![Image](https://github.com/user-attachments/assets/139433f7-022f-48ac-bfc1-9e3f08e9c062)

-----

-----

## ✅ 개선 사항

✔️ 데이터베이스에 연결했다면 앱 종료 시마다 생성됐던 일정이 모두 사라지지 않고 저장되어 있을 것이다.

✔️ API 명세서와 ERD를 더 세부적으로 나누어 작성해야 한다.

✔️ 일정의 작성일과 수정일이 따로 적용된다면 더 좋을 것이다.

✔️ 전체적으로 꼼꼼한 예외 처리가 많이 부족하다.

✔️ 기입되는 값들에 대한 유효성 검사가 필요하다.

-----

-----

## ✅ 코드의 동작 흐름 맛보기

**► `일정 생성` ◄**

![Image](https://github.com/user-attachments/assets/61dd6597-7a7c-4b7f-8277-1b26ca469b54)

-----

**► `일정 단건 조회` ◄**

![Image](https://github.com/user-attachments/assets/eb2b358a-d6f8-4eed-b656-c79954a1393c)

-----

**► `일정 목록 조회` ◄**

![Image](https://github.com/user-attachments/assets/be1c2f1b-b835-4f57-9ed4-d3c0573a1694)

-----

**► `비밀번호 불일치 시 일정 수정` ◄**

![Image](https://github.com/user-attachments/assets/f16449fe-a8f7-44bd-824f-25593a63d467)

-----

**► `비밀번호 일치 시 일정 수정` ◄**

![Image](https://github.com/user-attachments/assets/7721f65f-0def-4f92-8eee-44d500032231)

-----

**► `비밀번호 불일치 시 일정 삭제` ◄**

![Image](https://github.com/user-attachments/assets/e027855e-d032-49f7-a02d-9ec35ac07708)

-----

**► `비밀번호 일치 시 일정 삭제` ◄**

![Image](https://github.com/user-attachments/assets/4fc3c4b6-0036-44c5-8f20-fa5335102c53)
