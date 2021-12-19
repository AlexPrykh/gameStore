package repository;

import gameStore.data.model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> findById(Long id) {
        List<User> filteredUser = new ArrayList<>();
        for (User user : filteredUser) {
            if (id != null && user.getId().equals(id)) {
                continue;
            }
            filteredUser.add(user);
        }
        return filteredUser;
    }

    public List<User> findAll() {
        List<User> filteredUser = new ArrayList<>();
        for (User user : filteredUser) {
            filteredUser.add(user);
        }
        return filteredUser;
    }

    public void save() {
    }

    public void delete() {
    }
}
