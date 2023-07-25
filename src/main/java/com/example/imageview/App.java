package com.example.imageview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    CQueue cQueue = new CQueue();
    Queue queue = new Queue();
    Node t = null;
    float i = 1;
    String temp;

    @Override
    public void start(Stage stage) throws IOException {

        queue.front = queue.rear = null;
        t = queue.front;

        CQueue.enQueue(queue,
                "file:/Users/ahmedsherif/Desktop/Incognito/Java/phone book DS project/image_viewer/target/classes/com/example/Images/image1.jpg");
        CQueue.enQueue(queue,
                "file:/Users/ahmedsherif/Desktop/Incognito/Java/phone book DS project/image_viewer/target/classes/com/example/Images/image2.jpeg");
        CQueue.enQueue(queue,
                "file:/Users/ahmedsherif/Desktop/Incognito/Java/phone book DS project/image_viewer/target/classes/com/example/Images/image3.jpg");
        CQueue.enQueue(queue,
                "file:/Users/ahmedsherif/Desktop/Incognito/Java/phone book DS project/image_viewer/target/classes/com/example/Images/image4.jpg");
        CQueue.enQueue(queue,
                "file:/Users/ahmedsherif/Desktop/Incognito/Java/phone book DS project/image_viewer/target/classes/com/example/Images/image5.jpg");

        Label title = new Label("Image View");
        title.setAlignment(Pos.CENTER);
        title.setPrefHeight(49);
        title.setPrefWidth(688);
        title.setStyle("-fx-background-color: #e8e7da#e8e7da;");
        title.setFont(new Font("Arial Bold", 30));

        ImageView imageView = new ImageView(new Image(queue.front.data));
        imageView.setFitHeight(334);
        imageView.setFitWidth(478);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);

        TextField imagetTextField = new TextField();
        imagetTextField.setPromptText("Image path :");

        Button next = new Button("Next");
        next.setAlignment(Pos.CENTER);
        next.setMnemonicParsing(false);
        next.setPrefHeight(29);
        next.setPrefWidth(80);
        next.setStyle("-fx-background-color: black;");
        next.setTextAlignment(TextAlignment.CENTER);
        next.setTextFill(Color.WHITE);
        next.setOnAction(e -> {

            temp = queue.front.data;
            CQueue.deQueue(queue);
            imageView.setImage(new Image(queue.front.data));
            CQueue.enQueue(queue, temp);

        });

        Button back = new Button("Back");
        back.setAlignment(Pos.CENTER);
        back.setMnemonicParsing(false);
        back.setPrefHeight(29);
        back.setPrefWidth(80);
        back.setStyle("-fx-background-color: black;");
        back.setTextAlignment(TextAlignment.CENTER);
        back.setTextFill(Color.WHITE);
        back.setOnAction(e -> {
            for (int i = 0; i < CQueue.size(queue); i++) {
                temp = queue.front.data;
                CQueue.deQueue(queue);
                CQueue.enQueue(queue, temp);
            }
            imageView.setImage(new Image(queue.front.data));
        });

        Button zoomin = new Button("Zoom In");
        zoomin.setAlignment(Pos.CENTER);
        zoomin.setMnemonicParsing(false);
        zoomin.setPrefHeight(29);
        zoomin.setPrefWidth(80);
        zoomin.setStyle("-fx-background-color: black;");
        zoomin.setTextAlignment(TextAlignment.CENTER);
        zoomin.setTextFill(Color.WHITE);
        zoomin.setOnAction(e -> {

            if (i >= 2.5) {

            } else {
                i += 0.2;
                imageView.setScaleX(i);
                imageView.setScaleY(i);
                imageView.setScaleZ(i);
            }

        });

        Button zoomout = new Button("Zoom Out");
        zoomout.setAlignment(Pos.CENTER);
        zoomout.setMnemonicParsing(false);
        zoomout.setPrefHeight(29);
        zoomout.setPrefWidth(80);
        zoomout.setStyle("-fx-background-color: black;");
        zoomout.setTextAlignment(TextAlignment.CENTER);
        zoomout.setTextFill(Color.WHITE);
        zoomout.setOnAction(e -> {

            if (i <= 0.2) {

            } else {
                i -= 0.2;
                imageView.setScaleX(i);
                imageView.setScaleY(i);
                imageView.setScaleZ(i);
            }

        });



        TextField link = new TextField();
        link.setPrefHeight(26);
        link.setPrefWidth(228);
        link.setPromptText("Image path :");

        Button insert = new Button("Insert");
        insert.setMnemonicParsing(false);
        insert.setPrefHeight(29);
        insert.setPrefWidth(80);
        insert.setStyle("-fx-background-color: black;");
        insert.setTextFill(Color.WHITE);
        insert.setOnAction(e -> {

            CQueue.enQueue(queue, "File:"+link.getText());
            link.setText("");
        });

        Button delete = new Button("Delete");
        delete.setMnemonicParsing(false);
        delete.setPrefHeight(29);
        delete.setPrefWidth(80);
        delete.setStyle("-fx-background-color: black;");
        delete.setTextFill(Color.WHITE);
        delete.setOnAction(e -> {

            CQueue.deQueue(queue);
            imageView.setImage(new Image(queue.front.data));
        });







        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        VBox.setMargin(insert, new Insets(0, 0, 20, 0));
        vBox.getChildren().addAll(insert,link);




        HBox hBox = new HBox();
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setMaxHeight(1.7976931348623157E308);
        hBox.setMaxWidth(1.7976931348623157E308);
        hBox.prefHeight(100);
        hBox.prefWidth(200);
        hBox.getChildren().add(back);
        HBox.setMargin(back, new Insets(53, 0, 0, 0));
        hBox.getChildren().add(next);
        HBox.setMargin(next, new Insets(53, 0, 0, 53));
        hBox.getChildren().add(zoomout);
        HBox.setMargin(zoomout, new Insets(53, 0, 0, 53));
        hBox.getChildren().add(zoomin);
        HBox.setMargin(zoomin, new Insets(53, 0, 0, 53));
        hBox.getChildren().add(delete);
        HBox.setMargin(delete, new Insets(53, 0, 0, 53));
        hBox.getChildren().add(vBox);
        HBox.setMargin(vBox, new Insets(53, 0, 50, 53));



        BorderPane borderPane = new BorderPane();
        borderPane.setPrefHeight(700);
        borderPane.setPrefWidth(900);
        borderPane.setStyle("-fx-background-color: #e8e7da#e8e7da;");

        borderPane.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);

        borderPane.setCenter(imageView);
        BorderPane.setAlignment(imageView, Pos.CENTER);

        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        scene = new Scene(borderPane);

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setTitle("Image Viewer");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}