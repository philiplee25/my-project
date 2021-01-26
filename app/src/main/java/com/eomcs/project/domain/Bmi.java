package com.eomcs.project.domain;

public class Bmi {
  Bmi(double height, double weight) {
    double bmis;

    bmis = height / weight / weight;
  }
}
