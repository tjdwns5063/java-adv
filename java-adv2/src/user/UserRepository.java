package user;

import java.util.List;

public interface UserRepository {

    void register(User user);

    List<User> read();

}
