package user;

import java.io.*;
import java.util.List;
import user.file.UserFileRepository;
import user.memory.UserMemoryRepository;

public class UserMain {

    static IOHandler ioHandler = new IOHandler(
            new BufferedWriter(new OutputStreamWriter(System.out)),
            new BufferedReader(new InputStreamReader(System.in))
    );

    static UserRepository userRepository;

    static {
        try {
            userRepository = new UserFileRepository();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            Order order = ioHandler.receiveOrder();

            switch (order) {
                case REGISTER -> register();
                case READ -> read();
                case EXIT -> exit();
                case UNKNOWN -> System.out.println("처리할 수 없는 명령입니다.");
            }
        }
    }

    private static void read() {
        try {
            List<User> users = userRepository.read();

            ioHandler.writeUserList(users);
        } catch (Exception exception) {
            System.out.println("에러 발생!");
        }
    }

    private static void register() {
        try {
            User user = ioHandler.receiveUser();
            userRepository.register(user);
        } catch (Exception e) {
            System.out.println("에러 발생!");
        }
    }

    private static void exit() {
        System.out.println("프로그램 종료.");
        System.exit(0);
    }

}
