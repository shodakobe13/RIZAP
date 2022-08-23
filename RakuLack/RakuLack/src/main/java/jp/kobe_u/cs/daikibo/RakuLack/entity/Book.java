package jp.kobe_u.cs.daikibo.RakuLack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bid;   // 本の一意識別ID
    @NonNull
    String uid; // ユーザのID
    @NotBlank
    String title;   // 本のタイトル
    @Positive
    double width;   // 本の幅
    @Positive
    double height;  // 本の高さ
    @Positive
    double length;  // 本の長さ

}
