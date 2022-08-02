package jp.kobe_u.cs.daikibo.RakuLack.dto;

import lombok.Data;

@Data
public class BookForm {

    public String title;    // 本のタイトル
    public double width;    // 本の幅
    public double height;   // 本の高さ
    public double length;   // 本の長さ 
    
}
