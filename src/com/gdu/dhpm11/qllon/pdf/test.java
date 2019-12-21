package com.gdu.dhpm11.qllon.pdf;

import com.qoppa.pdfViewerFX.PDFViewer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class test extends Application {
    private PDFViewer m_PDFViewer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        m_PDFViewer = new PDFViewer();
        BorderPane borderPane = new BorderPane(m_PDFViewer);
        Scene scene = new Scene(borderPane);
        stage.setTitle("JavaFX PDFViewer - Qoppa Software");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
