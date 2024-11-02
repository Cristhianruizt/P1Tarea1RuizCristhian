
package com.mycompany.p1tarea1ruizcristhian;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.JSONObject;

public class P1Tarea1RuizCristhian {
    int Ruiz_op;
    float Ruiz_n1,Ruiz_n2,Ruiz_n3,Ruiz_pro;
     int Ruiz_n=3,Ruiz_base=14;
     Scanner scan =new Scanner(System.in);

    public static void main(String[] args) {
       P1Tarea1RuizCristhian menu = new P1Tarea1RuizCristhian();
       menu.Ruiz_Menu();
        
    }
     public void Ruiz_Menu(){
       
        System.out.println("SISTEMAS DE NOTAS ");
        System.out.println("1. Ingrese notas");
        System.out.println("2. Promedio");
        System.out.println("3. Guardar ");
        System.out.println("4. Salir");
        System.out.println("Ingrese opcion:");
        Ruiz_op=scan.nextInt();
        switch(Ruiz_op){
            case 1:
                Ruiz_IngresoNotas();
                Ruiz_Menu();
                break;
            case 2:
                Ruiz_Promedio();
                Ruiz_Menu();
                break;
            case 3:
                guardarEnJSON();
                guardarEnCSV();
                Ruiz_Menu();
                break;
            case 4:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Vuelva a ingresar");
                Ruiz_Menu();
        }
    }
      public void Ruiz_IngresoNotas(){
        
        System.out.println("Ingrese Nota 1 (0-20)");
        Ruiz_n1=scan.nextFloat();
         while(Ruiz_n1<0||Ruiz_n1>20){
             System.out.println("Vuelve a ingresar nota valida (0-20)");
            Ruiz_n1=scan.nextFloat();
    }
         System.out.println("Ingrese Nota 2 (0-20)");
         Ruiz_n2=scan.nextFloat();
        while(Ruiz_n2<0||Ruiz_n2>20){
            System.out.println("Vuelve a ingresar nota valida (0-20)");
            Ruiz_n2=scan.nextFloat();
    }
        System.out.println("Ingrese Nota 3 (0-20)");
        Ruiz_n3=scan.nextFloat();
        while(Ruiz_n3<0||Ruiz_n3>20){
            System.out.println("Vuelve a ingresar nota valida (0-20)");
            Ruiz_n3=scan.nextFloat();
    }       
    }
    public void Ruiz_Promedio(){
    Ruiz_pro=(Ruiz_n1+Ruiz_n2+Ruiz_n3)/Ruiz_n;
    if(Ruiz_pro>=Ruiz_base){
        System.out.println("APROBADO");
    }else{
        System.out.println("REPROBADO");
    }
    }
      // Método para guardar el promedio en un archivo JSON
    public void guardarEnJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Nota1", Ruiz_n1);
        jsonObject.put("Nota2", Ruiz_n2);
        jsonObject.put("Nota3", Ruiz_n3);
        jsonObject.put("Promedio", Ruiz_pro);
        jsonObject.put("Estado", Ruiz_pro >= Ruiz_base ? "APROBADO" : "REPROBADO");

        try (FileWriter file = new FileWriter("promedios.json")) {
            file.write(jsonObject.toString(4));  // Indentación de 4 espacios
            System.out.println("Archivo JSON guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo JSON: " + e.getMessage());
        }
    }

    // Método para guardar el promedio en un archivo CSV
    public void guardarEnCSV() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("promedios.csv"))) {
            pw.println("Nota1,Nota2,Nota3,Promedio,Estado");
            pw.println(Ruiz_n1 + "," + Ruiz_n2 + "," + Ruiz_n3 + "," + Ruiz_pro + "," + (Ruiz_pro >= Ruiz_base ? "APROBADO" : "REPROBADO"));
            System.out.println("Archivo CSV guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo CSV: " + e.getMessage());
        }
    }
    
}
