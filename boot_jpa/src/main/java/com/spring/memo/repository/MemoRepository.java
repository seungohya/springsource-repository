package com.spring.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.memo.entity.Memo;

// T : Entity 명
// TD : Entity 클래스의 id 컬럼 타입
public interface MemoRepository extends JpaRepository<Memo, Long> {
	//JpaRepository : CRUD 작업을 해주는 인터페이스 
	//save() : 저장 및 수정
	//delete() : 삭제
	//count() : 개수 반환
	//fineAll() : 모든 entity 조회
	//findById() : 특정 entity 조회 
	//....

}
