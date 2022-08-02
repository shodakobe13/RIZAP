package jp.kobe_u.cs.daikibo.RakuLack.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UidForm {
  @NotBlank
  String uid;
}
