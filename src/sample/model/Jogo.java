package sample.model;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    private static String FILE="jogadores.bin";

    private ObservableSet<Jogador> jogadores;
    private ObservableList<Pergunta> perguntas;

    private static Jogo instance = new Jogo();

    private Jogo(){
        jogadores = FXCollections.observableSet();
        perguntas = FXCollections.observableArrayList();
    }

    public static Jogo getInstance(){
        return instance;
    }

    public void cadastrarJogador(Jogador j){
        jogadores.add(j);
        carregaPerguntas();
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
        }
        catch (IOException e){
            System.out.println(e);
        }
    }


    public void carregaJogadores() throws IOException, ClassNotFoundException{
        jogadores.clear();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(
                        new File(FILE)
                )
        );

        ArrayList<Jogador> temp = (ArrayList)ois.readObject();

        jogadores.addAll(temp);
        ois.close();
    }

    public void salvarJogadores() throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(
                        new File(FILE))
        );

        ArrayList<Jogador> temp = new ArrayList<>();
        temp.addAll(jogadores);

        oos.writeObject(temp);

        oos.close();
    }
}
