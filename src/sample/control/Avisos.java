package sample.control;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Avisos {

    protected void ErroDificuldade(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION,"É necessario escolher uma didiculdade");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void avisoAcerto(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"RESPOSTA CORRETA :)");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void avisoErro(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"RESPOSTA INCORRETA :(");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void alertaFimDeJogo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"FIM DE JOGO");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }


    protected void avisoPulos(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"QUANTIDADE DE PULOS EXCEDIDA");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }

    protected void avisoSelecionarResposta(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"SELECIONE UMA OPÇÃO");

        Optional<ButtonType> resultado = alert.showAndWait();

        if(resultado.isPresent() && resultado.get() == ButtonType.OK){

        }
    }
}
