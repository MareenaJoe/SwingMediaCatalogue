package com.mareena.mediacatalogue.model.json;

public class Profile {
  private String name;
  private int preferredGenre;

  public Profile() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPreferredGenre() {
    return preferredGenre;
  }

  public void setPreferredGenre(int preferredGenre) {
    this.preferredGenre = preferredGenre;
  }

  @Override
  public String toString() {
    return "Profile{" + "name='" + name + '\'' + ", preferredGenre=" + preferredGenre + '}';
  }
}
