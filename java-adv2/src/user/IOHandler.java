package user;

import java.io.*;
import java.util.List;

public class IOHandler {

    private BufferedWriter writer;
    private BufferedReader reader;

    public IOHandler(BufferedWriter writer, BufferedReader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public Order receiveOrder() throws IOException {
        String input = receiveInput("1. 회원 등록 | 2. 회원 목록 조회 | 3. 종료\n선택: ");

        return switch (input) {
            case "1" ->  Order.REGISTER;
            case "2" -> Order.READ;
            case "3" -> Order.EXIT;
            default -> Order.UNKNOWN;
        };
    }

    public User receiveUser() throws IOException {
        String id = receiveInput("ID 입력: ");
        String name = receiveInput("Name 입력: ");
        String age = receiveInput("Age 입력: ");

        return new User(Long.parseLong(id), name, Integer.parseInt(age));
    }

    public void writeUserList(List<User> users) throws IOException {
        for (User user : users) {
            writer.write(user.toString() + "\n");
        }
        writer.flush();
    }

    private String receiveInput(String output) throws IOException {
        writer.write(output);
        writer.flush();
        return reader.readLine();
    }
}
