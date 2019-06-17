package sample.control;

import com.sun.prism.null3d.NULL3DPipeline;
import javafx.fxml.FXML;
import sample.Navegador;
import sample.model.Jogador;
import javafx.scene.control.TextField;
import sample.model.Jogo;

public class TelaInicial {
    @FXML
    private TextField tfNome;

    @FXML
    private void acaoCadastrar(){
        String nome = tfNome.getText();

        if(nome.length() > 0 ){
            Jogador jogador = new Jogador(0, nome, 0, null);
            Jogo.getInstance().cadastrarJogador(jogador);

            Navegador.loadJanela(Navegador.MENU_JOGO);
        }
        else{
            Navegador.loadJanela(Navegador.JANELA_INICIAL);
        }
    }
}
