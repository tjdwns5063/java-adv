package user;

public class User {

    private Long id;

    private String name;

    private Integer age;

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public static User from(String userStr) {
        String[] split = userStr.split(",");

        String id = split[0].split(":")[1].trim();
        String name = split[1].split(":")[1].trim();
        String age = split[2].split(":")[1].trim();

        return new User(Long.parseLong(id), name, Integer.parseInt(age.substring(0, age.length() - 1)));
    }

    @Override
    public String toString() {
        return String.format("[ID: %d, Name: %s, Age: %d]", id, name, age);
    }
}
