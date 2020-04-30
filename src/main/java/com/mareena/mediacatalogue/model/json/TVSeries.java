package com.mareena.mediacatalogue.model.json;

import java.util.Set;

// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "tid",scope
// = People.class)
public class TVSeries extends Media {

  public static int MAX_ID;
  protected int creator;
  private int tid;

  public TVSeries() {}

  public TVSeries(
      String title,
      Integer yearInt,
      String description,
      People directorObj,
      Set<Genre> genreSet,
      Set<People> castSet) {
    this.title = title;
    this.year = yearInt;
    this.description = description;
    this.mediaCreator = directorObj;
    this.genres = genreSet;
    this.actors = castSet;
  }

  public int getTid() {
    return tid;
  }

  public void setTid(int tid) {
    this.tid = tid;
    if (tid > MAX_ID) {
      MAX_ID = tid;
    }
  }

  int getNextID() {
    MAX_ID += 1;
    return MAX_ID;
  }

  public int getCreator() {
    return creator;
  }

  public void setCreator(int creator) {
    this.creator = creator;
  }

  @Override
  public void setMediaCreator(MediaCatalogue mediaCatalogue) {
    this.mediaCreator =
        mediaCatalogue.getPeople().stream().filter(p -> p.getPid() == creator).findFirst().get();
  }
}
