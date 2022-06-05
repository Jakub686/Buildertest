public class Main {
    public static void main(String[] args) {
        Student student= Student.builder()
                .name("Google.com")
                .age(30)
                .school("AlphaBet")
                .build();
        System.out.println(student.toString());

        People people = People.builder()
                .name("facebook.com")
                .age(20)
                .build();
        System.out.println(people.toString());
    }
}

class People {

    private String name;

    private int age;

    protected People(Builder<?> builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        return "name: " + this.name + ", age: " + this.age;
    }

    public static Builder builder() {
        return new Builder() {
            @Override
            public Builder getThis() {
                return this;
            }
        };
    }

    public abstract static class Builder<T extends Builder<T>> {

        private String name;

        private int age;

        public abstract T getThis();

        public T name(String name) {
            this.name = name;
            return this.getThis();
        }

        public T age(int age) {
            this.age = age;
            return this.getThis();
        }

        public People build() {
            return new People(this);
        }
    }
}

class Student extends People {

    private String school;

    public Student(Builder builder) {
        super(builder);
        this.school = builder.school;
    }

    @Override
    public String toString() {
        return super.toString() + ", school: " + this.school;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends People.Builder<Builder> {

        private String school;

        @Override
        public Builder getThis() {
            return this;
        }

        public Builder school(String school) {
            this.school = school;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }

}



