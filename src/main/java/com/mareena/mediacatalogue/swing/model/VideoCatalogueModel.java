package com.mareena.mediacatalogue.swing.model;

import com.mareena.mediacatalogue.controller.VideoCatalogueController;
import com.mareena.mediacatalogue.model.json.Media;
import com.mareena.mediacatalogue.model.json.MediaCatalogue;
import com.mareena.mediacatalogue.model.json.Profile;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public final class VideoCatalogueModel extends AbstractListModel {

  final VideoCatalogueController videoCatalogueController;
  final MediaCatalogue mediaCatalogue;
  Profile currentUser;
  List<Media> mediaTreeSet = new ArrayList<>();
  private int listCount = 4;

  public VideoCatalogueModel(
      MediaCatalogue mediaCatalogue, VideoCatalogueController videoCatalogueController) {
    this.mediaCatalogue = mediaCatalogue;
    this.videoCatalogueController = videoCatalogueController;
    // Setting a default user to the first user in the list
    this.currentUser = mediaCatalogue.getProfiles().get(0);
    updateCurrentUser(currentUser, mediaCatalogue);
  }

  public VideoCatalogueController getVideoCatalogueController() {
    return videoCatalogueController;
  }

  public void updateCurrentUser(Profile currentUser, MediaCatalogue mediaCatalogue) {
    this.currentUser = currentUser;
    setUsersMediaList();
  }

  public Profile getCurrentUser() {
    return currentUser;
  }

  public void setCurrentUser(Profile selectedUser) {
    this.currentUser = selectedUser;
    mediaTreeSet.clear();
    setUsersMediaList();
  }

  synchronized void setUsersMediaList() {
    mediaCatalogue.getFilms().stream()
        .filter(film -> film.getGenre().contains(currentUser.getPreferredGenre()))
        .forEach(item -> mediaTreeSet.add(item));
    mediaCatalogue.getTvseries().stream()
        .filter(tvSeries -> tvSeries.getGenre().contains(currentUser.getPreferredGenre()))
        .forEach(item -> mediaTreeSet.add(item));
    System.out.println("Media List ");
    mediaTreeSet.forEach(System.out::println);
    listCount = mediaTreeSet.size();
    System.out.println("Current count: " + listCount);
  }

  @Override
  public int getSize() {
    return listCount;
  }

  @Override
  public Object getElementAt(int index) {
    if (index > listCount) {
      return "";
    }
    System.out.println("Getting current index item: " + index + "item: " + mediaTreeSet.get(index));
    return mediaTreeSet.get(index);
  }
}
