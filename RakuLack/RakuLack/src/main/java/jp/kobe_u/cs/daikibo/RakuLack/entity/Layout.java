package jp.kobe_u.cs.daikibo.RakuLack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Layout {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long lid;

  String uid;

  Long bid;

  Long bsid;
}
