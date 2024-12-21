package user.memory;

import java.util.ArrayList;
import java.util.List;
import user.User;
import user.UserRepository;

public class UserMemoryRepository implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public void register(User user) {
        users.add(user);
    }

    @Override
    public List<User> read() {
        return users;
    }

}
