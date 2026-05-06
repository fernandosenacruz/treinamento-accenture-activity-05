package acc.br.student.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Student {

        @Id
        @Column
        private int id;

        @Column
        private String name;

        @Column
        private int age;

        @Column
        private String email;
}