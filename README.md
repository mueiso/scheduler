# API 명세서

|     기능     | Method |    URL     | Path Variable | Request Parameter |                               Request Body                                |                                      Response                                      |     상태코드     |
|:----------:|:------:|:----------:|:-------------:|:-----------------:|:-------------------------------------------------------------------------:|:----------------------------------------------------------------------------------:|:------------:|
|   스케줄 생성   |  POST  | /schedules |       X       |         X         | {<br/>"title": "제목",<br/>"contents": "할 일 내용",<br/>"writer": "작성자명"<br/>} | {<br/>"id": 1,<br/>"title": 제목1,<br/>"contents": 할 일 내용1,<br/>"writer": 작성자명<br/>} |  200: 정상등록   |
| 스케줄 단건 조회  |  GET   |   /{id}    |   id (Long)   |         X         |                                     X                                     |    {<br/>"id": 1,<br/>"title": 제목1,<br/>"contents": 할 일 내용1,<br/>"writer": 작성자명    |  200: 정상조회   |
| 스케줄 수정(전체) |  PUT   |   /{id}    |   id (Long)   |         X         |             {<br/>"title": "수정된 제목",<br/>"contents": "수정된 내용"             | {<br/>"id": 1,<br/>"title": "수정된 제목",<br/>"contents": "수정된 내용",<br/>"writer": 작성자명 |  200: 정상수정   |
|   스케줄 삭제   | DELETE |   /{id}    |   id (Long)   |         X         |                                     X                                     |                                  "msg": "일정 삭제 완료"                                  |  200: 정상삭제   |

--------------

# ERD

![Image](https://github.com/user-attachments/assets/139433f7-022f-48ac-bfc1-9e3f08e9c062)


