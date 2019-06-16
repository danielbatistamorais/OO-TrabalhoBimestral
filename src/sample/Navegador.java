package sample;

import sample.control.JanelaBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;


import java.io.IOException;

public class Navegador{

    public static final String BASE    = "resources/sample/base.fxml";
    public static final String JANELA_INICIAL    = "resources/sample/janelaInicial.fxml";
    public static final String MENU_JOGO = "resources/sample/menuJogo.fxml";

    private static JanelaBase controlador;

    public static void setControlador(JanelaBase controlador) {
        Navegador.controlador = controlador;
    }

    public static void loadJanela(String fxml) {
        try {
            controlador.setJanela(
                    (Node) FXMLLoader.load(
                            Navegador.class.getResource(
                                    fxml
                            )
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}