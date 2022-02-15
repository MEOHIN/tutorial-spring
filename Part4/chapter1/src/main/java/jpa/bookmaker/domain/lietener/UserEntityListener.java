package jpa.bookmaker.domain.lietener;

import jpa.bookmaker.domain.User;
import jpa.bookmaker.domain.UserHistory;
import jpa.bookmaker.repository.UserHistoryRepository;
import jpa.bookmaker.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PreUpdate;

@Component
public class UserEntityListener {
//    @Autowired
//    private UserHistoryRepository userHistoryRepository;

    @PreUpdate
    public void preUpdate(Object o) {
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = new User();

        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());

        userHistoryRepository.save(userHistory);
    }
}