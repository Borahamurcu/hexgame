package edu.erciyes.hexgame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class HelloController {


    @FXML
    private void handleButton1Action() throws IOException {
        loadFXML("HEX11.fxml");
    }

    @FXML
    private void handleButton2Action() throws IOException {
        loadFXML("HEX7.fxml");
    }

    @FXML
    public void handleButton3Action() throws IOException {
        loadFXML("HEX5.fxml");
    }

    @FXML
    public void handleBackAction() throws IOException {
        loadFXML("hello-view.fxml");


    }
    @FXML
    public void isstartButton()throws IOException
    {
        loadFXML("choosegametype.fxml");

    }

    @FXML
    public void isquit() throws IOException
    {

        closefxml("hello-view.fxml");


    }


    private void closefxml(String fxmlFile) throws IOException
    {

        Stage currentStage = (Stage) Stage.getWindows().filtered(Window::isShowing).get(0);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setFullScreen(true);
        stage.show();
        currentStage.close();
        stage.close();


    }


    private void loadFXML(String fxmlFile) throws IOException {
        Stage currentStage = (Stage) Stage.getWindows().filtered(Window::isShowing).get(0);

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setFullScreen(true);
        stage.show();
        currentStage.close();

    }


    @FXML
    private Pane myPane;

    private Map<Polygon, Boolean> polygonStatusMap = new HashMap<>();

    @FXML

    private boolean isPlayerOneTurn = true; // İlk başta birinci oyuncunun sırası

    public void handleMouseClick(MouseEvent event) {
        if (event.getTarget() instanceof Polygon) {
            Polygon clickedPolygon = (Polygon) event.getTarget();
            Boolean isClicked = polygonStatusMap.get(clickedPolygon);

            // Eğer poligon daha önce tıklanmadıysa
            if (isClicked == null || !isClicked) {
                if (isPlayerOneTurn) {
                    clickedPolygon.setFill(Color.BLUE); // Birinci oyuncu mavi yapar
                } else {
                    clickedPolygon.setFill(Color.RED); // İkinci oyuncu kırmızı yapar
                }
                polygonStatusMap.put(clickedPolygon, true); // Poligonun tıklanma durumunu güncelle
                clickedPolygon.setDisable(true); // Poligonu tekrar tıklanamaz hale getir
                isPlayerOneTurn = !isPlayerOneTurn; // Sıra diğer oyuncuya geçer

            }
        }
    }
}