package DesignPatterns.Creational.Builder;

public class BuilderPattern{

    static class User {
        private String name;
        private int age;
        private String city;
        private String email;

        private User(UserBuilder builder) {
            this.name = builder.name;
            this.age = builder.age;
            this.city = builder.city;
            this.email = builder.email;
        }

        public void display() {
            System.out.println("Name  : " + name);
            System.out.println("Age   : " + age);
            System.out.println("City  : " + city);
            System.out.println("Email : " + email);
        }
    }

    static class UserBuilder {

        private String name;
        private int age;
        private String city;
        private String email;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder setCity(String city) {
            this.city = city;
            return this;
        }
        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {

        User user = new UserBuilder()
                .setName("Aryan")
                .setAge(21)
                .setCity("Delhi")
                .setEmail("aryan@gmail.com")
                .build();
        user.display();
    }
}