package com.mareena.mediacatalogue.swing.model;

import com.mareena.mediacatalogue.controller.VideoCatalogueController;
import com.mareena.mediacatalogue.model.json.Media;
import com.mareena.mediacatalogue.model.json.MediaCatalogue;
import com.mareena.mediacatalogue.model.json.Profile;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class VideoCatalogueModel extends AbstractListModel {

  final VideoCatalogueController videoCatalogueController;
  final MediaCatalogue mediaCatalogue;
  Profile currentUser;
  List<Media> mediaList = new ArrayList<>();
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
    mediaList.clear();
    setUsersMediaList();
  }

  /**
   * Used to create the model list. This method is called when ever model needs to be updated. (eg
   * added a new media title in state model)
   */
  public synchronized void setUsersMediaList() {
    mediaList.addAll(
        mediaCatalogue.getFilms().stream()
            .filter(film -> film.getGenre().contains(currentUser.getPreferredGenre()))
            .collect(Collectors.toList()));
    mediaList.addAll(
        mediaCatalogue.getTvseries().stream()
            .filter(tvSeries -> tvSeries.getGenre().contains(currentUser.getPreferredGenre()))
            .collect(Collectors.toList()));
    System.out.println("Media List ");
    mediaList.forEach(System.out::println);
    listCount = mediaList.size();
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
    System.out.println("Getting current index item: " + index + "item: " + mediaList.get(index));
    return mediaList.get(index);
  }
}
