<img width="896" height="406" alt="image" src="https://github.com/user-attachments/assets/58db27ec-6bf2-4e50-988d-63bc81259873" />

전체 조회로 id 1번 ~ 3번을 호출

<img width="896" height="406" alt="image" src="https://github.com/user-attachments/assets/d7253244-d831-48ea-b8ee-77c9a98c82c5" />

전체 조회로 id 3번 삭제 되었음 



### Lv 1. 일정 생성 `필수`


### Lv 2. 일정 조회 `필수`



### Lv 3. 일정 수정 `필수`



### Lv 4. 일정 삭제 `필수`

### LV 5. 댓글 생성 '도전'
1. 최대한 자료를 찾아 보면서 기능을 구현해보기 위해 노력 했지만 만든 기능까지가 정답인지 몰라 README.MD에 남깁니다.
2. 처음으로 도전과제를 쫓아 가보는거라 아직은 미숙하고 코드가 정말 흐름에 맞게 설계 되었는지 잘 모르겠습니다.
3. 다음에는 LV.6 ~ 단계를 하나씩 더 공부하면서 기능을 만들어보도록 노력 하겠습니다.
4. CRUD 중 C까지만 제작이 되었습니다 추후 계속 제작 될 예정입니다.
( 학습을 통해 스프링 학습 심화를 더욱 거쳐 업그레이드 하기 ) 

3 Layer Architecture(Controller, Service, Repository)를 적절히 적용했는지 확인해 보고, 왜 이러한 구조가 필요한지 작성해 주세요.

Controller > Service, > Repository 

클라이언트의 요청 (Request)을 받아, 응답 ( Response)을 반환 하는 역할을 합니다.

사용자의 요청을 받아 Service에 전달합니다.

3 Layer Architecture는 코드의 가독성, 유지보수성, 확장성을 극대화 하기 위한 구조로 사용하지 않을 이유가 전혀 없는 방식 입니다. 

제 코드는 전반적으로 위 흐름 설계 중점으로 만들어졌으며 적절히 사용 될수 있는 3 Layer Architecture 할 수 있겠습니다. 


@RequestParam, @PathVariable, @RequestBody가 각각 어떤 어노테이션인지, 어떤 특징을 갖고 있는지 작성해 주세요.

@RequestParam :  어노테이션을 사용하면 쿼리 매개변수 또는 폼데이터를 컨트롤러의 메서드 인수에 바인딩 할 수 있습니다.

기본적으로 필수 값은 ( required = true ) 입니다.

여러 값을 리스트로 받을 수도 있습니다.

@PathVariable :  URL 경로의 일부를 메서드 매개변수에 바인딩할 때 사용합니다.

RESTful API 자원의 식별자를 URL 경로의 일부로 포함시킬때 주로 사용됩니다.

URL경로 일부를 변수로 받아올 때 유용합니다. 

@RequestBody : HTTP 요청에 담긴 JSON을 객체로 변환해 받을 때 사용 합니다.

POST, PUT, PATCH 요청에서 자주 사용됩니다.

( "key" : "value" )
