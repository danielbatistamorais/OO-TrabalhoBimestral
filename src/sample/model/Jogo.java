package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Jogo {

    private ObservableList<Jogador> jogadores;

    private static Jogo instance = new Jogo();

    private Jogo(){
        jogadores = FXCollections.observableArrayList();
    }

    public static Jogo getInstance(){
        return instance;
    }
}
