package com.example.demo.tripbookingapi.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Geom {

  public final int SRID = 4326;

  public final String POINT = "geometry(Point," + Geom.SRID + ")";
  public final String POLYGON = "geometry(Geometry," + Geom.SRID + ")";
}
