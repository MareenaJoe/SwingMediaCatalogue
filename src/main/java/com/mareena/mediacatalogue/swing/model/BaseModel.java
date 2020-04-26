package com.mareena.mediacatalogue.swing.model;

import com.mareena.mediacatalogue.controller.VideoCatalogueController;

public class BaseModel {

  final VideoCatalogueController videoCatalogueController;

  public BaseModel(VideoCatalogueController videoCatalogueController) {
    this.videoCatalogueController = videoCatalogueController;
  }

  public VideoCatalogueController getVideoCatalogueController() {
    return videoCatalogueController;
  }
}
