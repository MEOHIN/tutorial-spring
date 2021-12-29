package org.example.repository;

import org.example.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//  jpa repository 인터페이스 상속받고 제네릭으로 앞에는 데이터베이스와 연결될객체, 뒤에는 해당 객체의 id에 해당하는 필드타입
//  데이터베이스에는 todoEntity 만 저장하면 됨. todoRequest 와 todoResponse 는 저장할 필요성 없음
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
}
