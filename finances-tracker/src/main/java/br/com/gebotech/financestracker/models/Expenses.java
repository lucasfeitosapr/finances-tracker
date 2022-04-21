package br.com.gebotech.financestracker.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@Entity
@Table(name = "expenses", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private Long value;

    @NotBlank
    private Boolean recurrent = false;

    @NotBlank
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", shape = JsonFormat.Shape.STRING)
    private LocalDateTime expireAt;

    @NotBlank
    private Boolean payed = false;

    @Column
    private int installments = 0;

    public Expenses() {

    }

    public Expenses(String name, Long value, Boolean recurrent, LocalDateTime createdAt, LocalDateTime expireAt, Boolean payed, int installments) {
        this.name = name;
        this.value = value;
        this.recurrent = recurrent;
        this.createdAt = createdAt;
        this.expireAt = expireAt;
        this.payed = payed;
        this.installments = installments;
    }

}
