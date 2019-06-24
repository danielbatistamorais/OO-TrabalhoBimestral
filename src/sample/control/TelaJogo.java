package sample.control;


import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import sample.Navegador;
import sample.model.Jogo;
import sample.model.Pergunta;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class TelaJogo  extends Avisos{

    private ObservableList<Pergunta> perguntas = Jogo.getInstance().getPerguntas();

    private int cont = 0;
    private int questoesRespondidas =0;
    private int limitePulos;
    private int qtdPulos;

    @FXML
    private Label lbPergunta;

    @FXML
    private RadioButton rbOpcaoA;

    @FXML
    private RadioButton rbOpcaoB;

    @FXML
    private RadioButton rbOpcaoC;

    @FXML
    private RadioButton rbOpcaoD;


    public void initialize(){
        try{
            Jogo.getInstance().carregaPerguntas();

        }catch(Exception e){
            e.printStackTrace();
        }

        qtdPulos = Jogo.getInstance().getDificuldade();
        carregaTela(perguntas.get(cont));
    }

    private void carregaTela(Pergunta p) {

        lbPergunta.setText(p.getEnunciado());
        rbOpcaoA.setText(p.getOpcoes().get(0));
        rbOpcaoB.setText(p.getOpcoes().get(1));
        rbOpcaoC.setText(p.getOpcoes().get(2));
        rbOpcaoD.setText(p.getOpcoes().get(3));
    }

    private int selecionaResposta(){
        if(rbOpcaoA.isSelected()){
            return 1;
        }
        else if(rbOpcaoB.isSelected()){
            return 2;
        }
        else if(rbOpcaoC.isSelected()){
            return 3;
        }
        else {
            return 4;
        }
    }

    @FXML
    public void acaoDesistir(ActionEvent actionEvent){
        Navegador.loadJanela(Navegador.MENU_JOGO);
    }

    @FXML
    public void acaoPular(ActionEvent actionEvent) {

        if(qtdPulos > 0){
            cont++;
            qtdPulos--;
            carregaTela(perguntas.get(cont));
        }
        else{
            avisoPulos();
        }
    }

    @FXML
    public void acaoConfirmar(ActionEvent actionEvent) {
        if(selecionaResposta() == perguntas.get(cont).getCorreta()){
            Jogo.getInstance().marcaPontos(1);

        }
        else if(selecionaResposta() != perguntas.get(cont).getCorreta()){
            Jogo.getInstance().marcaPontos(2);
        }

        cont++;
        questoesRespondidas++;

        if(questoesRespondidas <5){
            carregaTela(perguntas.get(cont));
        }
        else{

            Jogo.getInstance().finalizaPartida();
            alertaFimDeJogo();
            Navegador.loadJanela(Navegador.MENU_JOGO);
        }
    }
}
