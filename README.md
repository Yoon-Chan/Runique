
# Runique

### :question: 프로젝트 설명

구글 맵을 이용한 달리기 기록 앱
---

## 🛠 기술 스택 및 도구

## <img src="https://img.shields.io/badge/android-34A853?style=for-the-badge&logo=android&logoColor=white"><img src="https://img.shields.io/badge/androidstudio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">

| 기술 스택             |                                                              |
| --------------------- | ------------------------------------------------------------ |
| UI              | Compose Ui                                                         |
| 라이브러리 | Flow, Room, google maps, serialization, coil, timber  |
| API              | Ktor                                                         |
| DI              | Koin                                                         |
| 아키텍처              | MVI                                                         |
| CI/CD                 | Github Actions                                               |

## 🌲 프로젝트 구조
```
project
├── app
├── analytics
│   └── analytics_feature
│   └── data
│   └── domain
│   └── presentation
├── auth
│   └── data
│   └── domain
│   └──presentation
├── build-logic
│   └── convention
├── core
│   └── data
│   └── database
│   └── domain
│   └── presentation
    │   └── designsystem
    │   └── ui
├── run
│   └── data
│   └── domain
│   └── location
│   └── network
│   └── presentation
```


## 📗 프로젝트를 통해 얻은 경험 - [프로젝트 기술 기록](https://www.notion.so/6c2e6c9f15014288ae9cac7e3c7888a3?p=1ee0977f1521800cabfed0084431240e&pm=c)
#### 1. Ktor를 활용한 네트워크 통신 경험
+ 기존에 주로 사용하던 Retrofit 대신 Ktor 클라이언트를 사용해 API 통신을 구현
+ 다양한 방식의 HTTP 통신 구조를 직접 구성하며 네트워크 계층에 대한 이해도 향상
+ 기술 선택의 유연성을 확보하고, 클린 아키텍처와 결합하여 모듈화된 네트워크 구성 경험

### 2. Google Maps 기반 경로 저장 및 스냅샷 기능 구현
+ Google Maps API를 활용해 사용자의 이동 경로를 시각화
+ Google Map Snapshot 기능을 통해 경로의 이미지를 저장하고 UI에 표시
+ 위치 기반 기능과 지도 API의 실전 활용 경험 확보

### 3. 의존성 주입 라이브러리 다양화 (Hilt → Koin)
+ 기존에는 Hilt를 사용했지만, 이번 프로젝트에서는 Koin을 사용해 의존성 주입 구성
+ DI 구성 방식을 비교하고, Koin의 DSL 기반 구성 방식을 직접 적용
+ 상황에 따라 DI 도구를 선택할 수 있는 실전 경험 확보

### 4. 직접 설계한 멀티 모듈 아키텍처
+ 예전엔 DroidKnights 프로젝트를 참고하였지만, 프로젝트에 스스로 멀티모듈을 설계하고 Convention Plugin 구현
+ 모듈 간 의존성 분리, 공통 코드 분리, 기능 단위 모듈화 설계 진행
+ 실 서비스에 적용 가능한 멀티 모듈 구성 경험과 빌드 속도 개선 효과 체감

### 5. Jetpack Compose와 MVI 패턴 기반의 기능 구현
+ Jetpack Compose를 기반으로 UI 구현
+ MVI 패턴을 적용하여 상태(State)와 이벤트(Effect)를 명확히 분리
+ SOLID 원칙을 바탕으로 역할 분리와 유지보수 가능한 구조로 설계
+ UI와 로직의 결합도를 낮추고 테스트 가능한 구조로 구성

## :pushpin: 구현 내용

## 1. 로그인 화면

| 로그인 메인 화면 | Sign in 화면 | sign up 화면 |
| --------- | --------- | --------- |
| <img src="https://github.com/user-attachments/assets/7bfdadc1-744b-4b7b-ab28-4c8ae98c1ea4" width=300 height=600/> | <img src="https://github.com/user-attachments/assets/ff8caf24-d14a-41b8-bfe1-7cbb2c1a3052" width=300 height=600/>  | <img src="https://github.com/user-attachments/assets/0f848ffc-6a51-4313-a293-972eca8f3a7b" width=300 height=600/>  |


## 2. 달리기 화면

| 메인화면 | 권한요청 받기(위치 권한) | 달리기 화면 |
| ----------- | ----------------------- | ---------------- |
| <img src="https://github.com/user-attachments/assets/94c9f409-c6dc-47b4-9758-5e494d969a95" width=300 height=600/> |  <img src="https://github.com/user-attachments/assets/d948084f-0903-4d8c-8f9c-804e2cd3285f" width=300 height=600/>  |   <img src="https://github.com/user-attachments/assets/0d037acc-5410-45d7-8bbd-0510f2fd79b6" width=300 height=600/>  |

---

| 백그라운드 달리기 | 권한요청 받기(위치 권한) | 네트워크 동기화 작업(기록 저장) |
| ----------- | ----------------------- | ---------------- |
| <img src="https://github.com/user-attachments/assets/e76b1fa9-02aa-4391-96e2-cf0326aec558" width=300 height=600/> |  <img src="https://github.com/user-attachments/assets/6204973e-d791-4beb-84f0-f74452e4ab70" width=300 height=600/>  | <img src="https://github.com/user-attachments/assets/7faf0063-5254-44e1-b2f9-316a24c08e57" width=300 height=600/>   |

---

| 분석화면 | 로그아웃 | 기록 삭제(네트워크 연결 x시에도 적용) |
| ----------- | ----------------------- |  ----------------------- |
| <img src="https://github.com/user-attachments/assets/7ce77521-c30e-47d5-8918-76eb75cebea1" width=300 height=600/> |  <img src="https://github.com/user-attachments/assets/55943055-d78b-4c2d-950c-e452ee706492" width=300 height=600/>  | <img src="https://github.com/user-attachments/assets/8d72937a-a40d-4124-953b-22af8ef415d5" width=300 height=600/>  |
