package sample;

import sample.control.JanelaBase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;


import java.io.IOException;

public class Navegador{

    public static final String BASE    = "/sample/base.fxml";
    public static final String JANELA_INICIAL    = "/sample/janelaInicial.fxml";
    public static final String MENU_JOGO = "/sample/menuJogo.fxml";
    public static final String TELA_JOGO = "/sample/Telajogo.fxml";

    private static JanelaBase controlador;

    public static void setControlador(JanelaBase controlador) {
        Navegador.controlador = controlador;
    }

    public static void loadJanela(String fxml) {
        try {
            controlador.setJanela((Node) FXMLLoader.load(
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