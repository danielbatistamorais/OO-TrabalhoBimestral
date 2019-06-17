package sample.control;

import javafx.fxml.FXML;
import sample.Navegador;

public class MenuJogo {

    @FXML
    private void acaoDeslogar(){

        Navegador.loadJanela(Navegador.JANELA_INICIAL);
    }
}
