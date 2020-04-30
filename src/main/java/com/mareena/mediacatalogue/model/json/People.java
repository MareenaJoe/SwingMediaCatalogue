package com.mareena.mediacatalogue.model.json;

// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pid",scope
// = People.class)
public class People {
  public static int MAX_ID;
  private int pid;
  private String name;

  public People() {}

  public People(String director) {
    this.name = director;
    this.pid = getNextID();
  }

  public int getPid() {
    return pid;
  }

  public void setPid(int pid) {
    this.pid = pid;
    if (pid > MAX_ID) {
      MAX_ID = pid;
    }
  }

  int getNextID() {
    MAX_ID += 1;
    return MAX_ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name + "\n";
  }
}
