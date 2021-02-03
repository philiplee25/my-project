package com.eomcs.project.domain;

import java.sql.Date;

public class Diet {
  public int no;
  public int status;
  public String name;
  public Date registerDate;


  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getRegisterDate() {
    return registerDate;
  }

  public void setRegisterDate(Date registerDate) {
    this.registerDate = registerDate;
  }


}
