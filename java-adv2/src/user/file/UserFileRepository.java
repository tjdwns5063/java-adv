package user.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import user.User;
import user.UserRepository;

public class UserFileRepository implements UserRepository {

    private static final String FILE_NAME = "./temp/user.dat";

    private final BufferedWriter writer;

    public UserFileRepository() throws IOException {
        writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
    }

    @Override
    public void register(User user) {
        try {
            writer.write(user.toString());
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            throw new IllegalStateException("저장 실패");
        }
    }

    @Override
    public List<User> read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            List<User> results = new ArrayList<>();
            while (reader.ready()) {
                String userStr = reader.readLine();

                results.add(User.from(userStr));
            }
            return results;
        } catch (Exception e) {
            throw new IllegalStateException("조회 실패");
        }
    }
}
