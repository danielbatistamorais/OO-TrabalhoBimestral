package sample.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.Navegador;
import sample.model.Jogador;
import sample.model.Jogo;

import java.io.IOException;

public class MenuJogo {

    @FXML
    private void acaoDeslogar() throws IOException{
        Jogo.getInstance().salvarJogadores();
        Navegador.loadJanela(Navegador.JANELA_INICIAL);
    }

    @FXML
    public void acaoJogar(ActionEvent actionEvent) {
    }
}