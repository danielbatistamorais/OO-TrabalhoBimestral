package sample.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import sample.Navegador;
import sample.model.Jogo;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuJogo extends Avisos {

    @FXML
    private ComboBox cbDificuldade;

    @FXML
    private Label lbUltimaJogada;

    public void initialize(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date ultimaJogada = Jogo.getInstance().getJogadorLogado().getUltimaJogada();

        if(ultimaJogada == null){
            lbUltimaJogada.setText("00/00/0000");
        }
        else{
            lbUltimaJogada.setText(String.valueOf(ultimaJogada));
        }
    }

    @FXML
    private void acaoDeslogar() throws IOException{
        Jogo.getInstance().salvarJogadores();
        Navegador.loadJanela(Navegador.JANELA_INICIAL);
    }

    @FXML
    public void acaoJogar(ActionEvent actionEvent) {

        String dificuldade = String.valueOf(cbDificuldade.getSelectionModel().getSelectedItem());

        if(dificuldade.equals(" ")){
            ErroDificuldade();
        }
        else{
            Jogo.getInstance().setDificuldade(dificuldade);
            Navegador.loadJanela(Navegador.TELA_JOGO);
        }
    }
}