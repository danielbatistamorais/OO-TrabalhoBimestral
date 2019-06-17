package sample.control;

import javafx.fxml.FXML;
import sample.Navegador;
import sample.model.Jogador;
import javafx.scene.control.TextField;
import sample.model.Jogo;

public class TelaInicial {
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfSenha;

    @FXML
    private void acaoCadastrar(){
        String nome = tfNome.getText();

        Jogador jogador = new Jogador(0, nome, 0, null);

        Jogo.getInstance().cadastrarJogador(jogador);
        System.out.println(Jogo.getInstance());

        Navegador.loadJanela(Navegador.MENU_JOGO);
    }
}
