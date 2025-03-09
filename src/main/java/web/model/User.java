package web.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "surname")
        private String surname;

        @Column(name = "age")
        private byte age;

        @Column(name = "email")
        private String email;

        public User() {
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                User user = (User) o;
                return age == user.age && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, name, surname, age, email);
        }

        @Override
        public String toString() {
                return "User{" +
                        "  id=" + id +
                        ", name='" + name + '\'' +
                        ", surname='" + surname + '\'' +
                        ", age=" + age +
                        ", email='" + email + '\'' +
                        '}';
        }
}
