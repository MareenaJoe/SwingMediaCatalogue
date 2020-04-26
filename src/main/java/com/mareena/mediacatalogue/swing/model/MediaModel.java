package com.mareena.mediacatalogue.swing.model;

import com.mareena.mediacatalogue.controller.VideoCatalogueController;
import com.mareena.mediacatalogue.model.json.Genre;
import com.mareena.mediacatalogue.model.json.Media;
import com.mareena.mediacatalogue.model.json.People;

import java.util.stream.Collectors;

public class MediaModel {
  final VideoCatalogueController videoCatalogueController;
  Media media;

  public MediaModel(Media media, VideoCatalogueController videoCatalogueController) {
    this.videoCatalogueController = videoCatalogueController;
    this.media = media;
  }

  public VideoCatalogueController getVideoCatalogueController() {
    return videoCatalogueController;
  }

  public Media getMedia() {
    return media;
  }

  public void setMedia(Media media) {
    this.media = media;
  }

  public String getGenresText() {
    return media.getGenres().stream().map(Genre::toString).collect(Collectors.joining(""));
  }

  public String getCastText() {
    return media.getActors().stream().map(People::toString).collect(Collectors.joining(""));
  }
}
