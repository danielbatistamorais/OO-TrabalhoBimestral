package sample.control;


import javafx.fxml.FXML;
import sample.Navegador;
import sample.model.Jogador;
import javafx.scene.control.TextField;
import sample.model.Jogo;

import java.io.IOException;

public class TelaInicial {
    @FXML
    private TextField tfNome;

    @FXML
    private void acaoCadastrar() throws IOException{
        String nome = tfNome.getText();

        if(nome.length() > 0 ){

            if(!Jogo.getInstance().verificaJogadores(nome)){

                Jogador jogador = new Jogador(0, nome, 0, null);
                Jogo.getInstance().cadastrarJogador(jogador);
                Jogo.getInstance().salvarJogadores();

                Navegador.loadJanela(Navegador.MENU_JOGO);
            }
            else{
                Navegador.loadJanela(Navegador.MENU_JOGO);
            }

        }
        else{
            Jogo.getInstance().salvarJogadores();
            Navegador.loadJanela(Navegador.JANELA_INICIAL);
        }
    }
}
