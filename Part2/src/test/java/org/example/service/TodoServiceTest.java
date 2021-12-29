package org.example.service;
/**
 * test 강의는 다음에 이어 듣기로 함
 */

import org.example.model.TodoEntity;
import org.example.model.TodoRequest;
import org.example.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TodoServiceTest {

//    Mock 사용하는 이유:
//    1. 외부 시스템에 의존하지 않고 자체 테스트를 실행할 수 있음
//      unit test 는 네트워크나 데이터베이스 연결과 무관하게 실행되어야 함
//    2. 데이터베이스와 연결하지 않았기 때문에, 테스트할 때마다 DB에 추가되거나 삭제되는 위험성이 없음
    @Mock
    private TodoRepository todoRepository;

//    Mock 을 주입받아서 사용할 서비스를 필드에 추가
    @InjectMocks
    private TodoService todoService;

    @Test
    void add() {

        when(this.todoRepository.save(any(TodoEntity.class))).then(AdditionalAnswers.returnsFirstArg());

        TodoRequest expected = new TodoRequest();
        expected.setTitle("Test Title");

        TodoEntity actual = this.todoService.add(expected);

        assertEquals(expected.getTitle(), actual.getTitle());
    }

    @Test
    void searchById() {
    }
}