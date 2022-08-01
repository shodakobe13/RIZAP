package jp.kobe_u.cs.daikibo.RakuLack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bookshelf {
    @Id
    Long bsid; //本棚のID
    String uid; //所持するユーザID
    String name; //本棚の名前
    double width; //本棚の奥行き
    double height; //本棚の一段あたりの高さ
    double length; //本棚の横幅
    int nStage; //本棚の段数
}
