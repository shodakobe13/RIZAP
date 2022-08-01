package jp.kobe_u.cs.daikibo.RakuLack.dto;

import jp.kobe_u.cs.daikibo.RakuLack.entity.Bookshelf;
import lombok.Data;

@Data
public class BookshelfForm {
    String name;
    double width;
    double height;
    double length;
    int nStage;

    public Bookshelf toEntity(){
        Bookshelf bs = new Bookshelf();
        bs.setName(name);
        bs.setWidth(width);
        bs.setHeight(height);
        bs.setLength(length);
        bs.setNStage(nStage);

        return bs;
    }
    
}
