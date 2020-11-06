package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int x1 = 0;

    private static int y1 = 0;

    private static int x2 = 0;

    private static int y2 = 0;

    private static String htmlComeco = "<!DOCTYPE html><html><body><svg height=\"1000\" width=\"1000\">";

    private static String htmlFim = "</svg></body></html>";

    private static String htmlMeio = "";


    public static void main(String[] args) {
        System.out.println("Bem vindo, Este projeto funciona baseado no alfabeto (A,B) sendo que a cada rodada  A->AB e B->A. A faz Circulo e B faz Quadrado.");
        System.out.println("Quantas rodadas serão realizadas?");

        Scanner scMenu = new Scanner(System.in);

        int total = scMenu.nextInt();
        String initial = "A";
        String st = null;

        for (int j = 0; j < total; j++) {
            System.out.println(initial);
            CriaSvg(initial);
            initial = Result(initial);
        }
        System.out.println(initial);

        SalvaSVG();
        System.out.println("");
        System.out.println("------------------------------");
        System.out.println("Arquivo gerado por favor verificar output. ");
    }

    private static void SalvaSVG(){
        Path path = Paths.get("Arquivo.html");
        String finalString = htmlComeco + htmlMeio + htmlFim;
        byte[] bytes = finalString.getBytes();

        try {
            Files.write(path,bytes);
        } catch (IOException ex) {
            // Handle exception
        }
    }

    private static String Result(String st){
        String lastString = "";
        for (char i : st.toCharArray()){
            if(i == 'A'){
                lastString += "AB";
            }
            else{
                lastString += "A";
            }
        }

        return lastString;
    }

    private static void CriaSvg(String st){

        for (char i : st.toCharArray()){
            if(i == 'A'){
                x1 = x2;
                y1 = y2;
                x2 += 5;
                y2 += 5;
                CriaCirculo();
            }
            else{
                x1 = x2;
                y1 = y2;
                x2 += 5;
                y2 += 5;
                CriaRetangulo();
            }
        }
    }

    private static void CriaCirculo()
    {
        String result = "<Circle ";
        result += "cx=\"" + x1 +"\" ";
        result += "cy=\"" + x2 +"\" ";
        result += "r=\"" + y1 +"\" ";
        result += "style=\"stroke:rgb(255,0,0);stroke-width:2\" fill=\"none\" />\"";
        htmlMeio += result;
    }

    private static void CriaRetangulo()
    {
        String result = "<rect ";
        result += "width=\"" + x1 +"\" ";
        result += "height=\"" + x2 +"\" ";
        result += "r=\"" + y1 +"\" ";
        result += "style=\"stroke:rgb(255,0,0);stroke-width:2\" fill=\"none\" />\"";
        htmlMeio += result;
    }


}
