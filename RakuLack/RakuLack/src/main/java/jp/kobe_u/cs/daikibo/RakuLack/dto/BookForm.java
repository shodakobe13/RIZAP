package jp.kobe_u.cs.daikibo.RakuLack.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
@Valid
public class BookForm {

    @NotBlank
    public String title;    // 本のタイトル
    @Positive
    public double width;    // 本の幅
    @Positive
    public double height;   // 本の高さ
    @Positive
    public double length;   // 本の長さ 
    
}
