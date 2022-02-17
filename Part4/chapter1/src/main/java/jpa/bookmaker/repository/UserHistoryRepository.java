package jpa.bookmaker.repository;

import jpa.bookmaker.domain.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
    /*
    UserHistory 가 아주 많이 쌓였다면 findAll() 로 가져오기 어렵고 findById 로 가져와야 한다.
     */
    List<UserHistory> findByUserId(Long userId);
}
