public class Main {
    public static void main(String[] args) {


        Person person = Person.builder()
                .number("555")
                .created("dadsa")
                .name("jaja")
                .surname("AHA")
                .birthDate("february")
                .gender("male")
                .build();
        System.out.println("Person " + person.toString() + person);
        System.out.println();


        Organization organization = Organization.builder()
                .number("444")
                .created("dadsa")
                .organizationName("pepsi")
                .address("Poland")
                .build();
        System.out.println("Organization " + organization.toString());
    }
}

class Contact {

    private String number;
    private String created;

    protected Contact(Builder<?> builder) {
        this.number = builder.number;
        this.created = builder.created;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "number='" + number + '\'' +
                ", created='" + created + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder() {
            @Override
            public Builder getThis() {
                return this;
            }
        };
    }

    public String getNumber() {
        return number;
    }

    public String getCreated() {
        return created;
    }

    public abstract static class Builder<T extends Builder<T>> {

        private String number;
        private String created;


        public abstract T getThis();

        public T number(String number) {
            this.number = number;

            return this.getThis();
        }

        public T created(String created) {
            this.created = created;
            return this.getThis();
        }

        public Contact build() {
            return new Contact(this);
        }


    }

}

class Person extends Contact {

    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public Person(Builder builder) {
        super(builder);
        this.name = builder.name;
        this.surname = builder.surname;
        this.birthDate = builder.birthDate;
        this.gender = builder.gender;
    }

    @Override
    public String toString() {
        return super.toString() + ", name: " + this.name+ ", surname: " + this.surname+ ", birthDate: " + this.birthDate+ ", gender: " + this.gender;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public static class Builder extends Contact.Builder<Builder> {

        private String name;
        private String surname;
        private String birthDate;
        private String gender;

        @Override
        public Builder getThis() {
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder surname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder birthDate(String birthDate) {
            this.birthDate = birthDate;
            return this;
        }
        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }

    }
}

class Organization extends Contact {

    private String organizationName;
    private String address;

    public Organization(Builder builder) {
        super(builder);
        this.organizationName = builder.organizationName;
        this.address = builder.address;
    }

    @Override
    public String toString() {
        return super.toString() + ", organizationName: " + this.organizationName+ ", address: " + this.address;
    }



    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Contact.Builder<Builder> {

        private String organizationName;
        private String address;

        @Override
        public Builder getThis() {
            return this;
        }

        public Builder organizationName(String organizationName) {
            this.organizationName = organizationName;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Organization build() {
            return new Organization(this);
        }

    }

}



