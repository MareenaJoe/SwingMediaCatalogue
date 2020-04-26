package com.mareena.mediacatalogue.model.json;

// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "tid",scope
// = People.class)
public class TVSeries extends Media {

  protected int creator;
  private int tid;

  public TVSeries() {}

  public int getTid() {
    return tid;
  }

  public void setTid(int tid) {
    this.tid = tid;
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
