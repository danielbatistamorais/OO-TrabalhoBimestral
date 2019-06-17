package sample.model;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    private ObservableList<Jogador> jogadores;
    private ObservableList<Pergunta> perguntas;

    private static Jogo instance = new Jogo();

    private Jogo(){
        jogadores = FXCollections.observableArrayList();
        perguntas = FXCollections.observableArrayList();
    }

    public static Jogo getInstance(){
        return instance;
    }

    public void cadastrarJogador(Jogador j){
        jogadores.add(j);
    }

    public void carregaPerguntas(){
        File f = new File("perguntas.txt");

        ArrayList<Pergunta> aux = new ArrayList<>();

        String enunciado;
        ArrayList<String> opcoes = new ArrayList<>();
        int correta;

        int numPerguntas, rand1 = 1, numOpcoes;
        ////ADICIONAR RAND DE 8 NÚMEROS QUE CORRESPONDEM AS PERGUNTAS

        try(Scanner scan = new Scanner (f);){

            numPerguntas = Integer.valueOf(scan.nextLine());
            numOpcoes= Integer.valueOf(scan.nextLine());

            for(int i =0; i<numPerguntas;i++){
                opcoes.clear();

                enunciado = scan.nextLine();
                for(int j = 0; j<numOpcoes; j++){
                    opcoes.add(scan.nextLine());
                }
                correta = Integer.valueOf(scan.nextLine());

                Pergunta p = new Pergunta(enunciado, opcoes,correta);

                aux.add(p);
            }

            do{
                for(int j=0; j<numPerguntas; j++){

                    if(j == rand1){
                        perguntas.add(aux.get(j));
                    }
                }

            }while(perguntas.size()<1);

            System.out.println(perguntas);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
