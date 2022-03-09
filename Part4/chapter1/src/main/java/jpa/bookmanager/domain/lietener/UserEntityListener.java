package jpa.bookmanager.domain.lietener;

import jpa.bookmanager.domain.User;
import jpa.bookmanager.domain.UserHistory;
import jpa.bookmanager.repository.UserHistoryRepository;
import jpa.bookmanager.support.BeanUtils;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
public class UserEntityListener {

    @PostPersist
    @PostUpdate
    public void preUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = new User();

        UserHistory userHistory = new UserHistory();
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setUser(user);  // User 에서 getUserHistory 를 사용할 수 있음

        userHistoryRepository.save(userHistory);
    }
}
