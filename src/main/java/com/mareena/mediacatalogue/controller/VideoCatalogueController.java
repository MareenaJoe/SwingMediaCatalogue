package com.mareena.mediacatalogue.controller;

import com.mareena.mediacatalogue.MediaCatalogueStateModel;
import com.mareena.mediacatalogue.model.json.Media;
import com.mareena.mediacatalogue.model.json.MediaCatalogue;
import com.mareena.mediacatalogue.model.json.Profile;
import com.mareena.mediacatalogue.swing.model.BaseModel;
import com.mareena.mediacatalogue.swing.model.ListByYearAndGenreModel;
import com.mareena.mediacatalogue.swing.model.MediaModel;
import com.mareena.mediacatalogue.swing.model.VideoCatalogueModel;
import com.mareena.mediacatalogue.swing.view.*;

import java.awt.*;

public final class VideoCatalogueController {

  MediaCatalogueStateModel mediaCatalogueStateModel;

  VideoCatalogueModel videoCatalogueModel;
  VideoCatalogue videoCatalogueView;

  ItemMediaView viewMediaView;
  AddItemView addItemView;
  SelectUserView selectUserView;
  ListByYear listByYear;
  ListByGenre listByGenre;

  // ListByYearView
  // ListByGenreView

  public VideoCatalogueController() {
    mediaCatalogueStateModel = MediaCatalogueStateModel.getInstance();
    initVideoCatalogue();
    initOtherViews(mediaCatalogueStateModel.getCatalogue());
  }

  private void initVideoCatalogue() {
    this.videoCatalogueModel =
        new VideoCatalogueModel(mediaCatalogueStateModel.getCatalogue(), this);
    this.videoCatalogueView = new VideoCatalogue(videoCatalogueModel);
    videoCatalogueView.setVisible(true);
  }

  public void initOtherViews(MediaCatalogue mediaCatalogue) {
    this.viewMediaView = new ItemMediaView();
    // set the jframe size and location, and make it visible
    viewMediaView.setPreferredSize(new Dimension(450, 550));
    viewMediaView.setTitle("Media Details");
    viewMediaView.pack();
    viewMediaView.setLocationRelativeTo(null);
    viewMediaView.setVisible(false);

    this.selectUserView = new SelectUserView(new BaseModel(this));
    // set the jframe size and location, and make it visible
    selectUserView.setPreferredSize(new Dimension(250, 350));
    selectUserView.setTitle("Select User Profile");
    selectUserView.pack();
    selectUserView.setLocationRelativeTo(null);
    selectUserView.setVisible(false);

    this.listByYear = new ListByYear(new ListByYearAndGenreModel(mediaCatalogue, this));
    listByYear.setPreferredSize(new Dimension(500, 600));
    listByYear.setTitle("List by Year");
    listByYear.pack();
    listByYear.setLocationRelativeTo(null);
    listByYear.setVisible(false);

    this.listByGenre = new ListByGenre(new ListByYearAndGenreModel(mediaCatalogue, this));
    listByGenre.setPreferredSize(new Dimension(500, 600));
    listByGenre.setTitle("List by Genre");
    listByGenre.pack();
    listByGenre.setLocationRelativeTo(null);
    listByGenre.setVisible(false);
  }

  /**
   * A model is asking the controller to perform an action. Here a media object is passed and asking
   * controller to set the media model in the media view
   *
   * @param media
   */
  public void actionSelectTitle(Media media) {
    viewMediaView.setMedia(new MediaModel(media, this));
    viewMediaView.setVisible(true);
    viewMediaView.pack();
  }

  /**
   * A model is asking the controller to perform an action. Here controller is being asked to
   * disable the ItemMediaView window
   */
  public void actionDisableTitleView() {
    viewMediaView.setVisible(false);
  }

  public void actionEnableSelectUsers() {
    selectUserView.setVisible(true);
  }

  public void actionSelectUser(String text) {
    Profile selectedUser =
        mediaCatalogueStateModel.getCatalogue().getProfiles().stream()
            .filter(profile -> profile.getName().equalsIgnoreCase(text))
            .findFirst()
            .get();
    if (selectedUser != null) {
      System.out.println("Going to update new selected user: " + selectedUser);
      videoCatalogueModel.setCurrentUser(selectedUser);
      videoCatalogueView.reload();
    }
  }

  public void actionSelectUserDisable() {
    selectUserView.setVisible(false);
  }

  public void actionEnableLIstByYear() {
    listByYear.setVisible(true);
  }

  public void actionEnableLIstByGenre() {
    listByGenre.setVisible(true);
  }
}
