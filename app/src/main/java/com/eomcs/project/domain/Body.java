package com.eomcs.project.domain;

import java.sql.Date;

public class Body {
  private int nos;
  private int status;
  private double heights;
  private double weights;
  private String names;
  private Date registeredDates;
  private static double bmis;

  public static double bmi(double w, double h) {

    return bmis = h / w / w;
  }

  public int getNos() {
    return nos;
  }

  public void setNos(int nos) {
    this.nos = nos;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public double getHeights() {
    return heights;
  }

  public void setHeights(double heights) {
    this.heights = heights;
  }

  public double getWeights() {
    return weights;
  }

  public void setWeights(double weights) {
    this.weights = weights;
  }

  public double getBmis() {
    return bmis;
  }

  public void setBmis(double bmis) {
    this.bmis = bmis;
  }

  public String getNames() {
    return names;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public Date getRegisteredDates() {
    return registeredDates;
  }

  public void setRegisteredDates(Date registeredDates) {
    this.registeredDates = registeredDates;
  }


}


