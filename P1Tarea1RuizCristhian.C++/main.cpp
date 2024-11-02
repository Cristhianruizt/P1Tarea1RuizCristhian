#include <iostream>
#include <stdlib.h>
#include <string>
#include <fstream>
using namespace std;

void Ruiz_Menu();
void Ruiz_IngresoNotas();
void Ruiz_Promedio();
void Ruiz_Guardar();

float Ruiz_n1,Ruiz_n2,Ruiz_n3,Ruiz_pro;

int main()
{
    Ruiz_Menu();
    return 0;
}
void Ruiz_Menu(){
    int Ruiz_op;
    cout<<" SISTEMA DE NOTAS"<<endl;
    cout<<"1. Ingrese notas"<<endl;
    cout<<"2. Promedio"<<endl;
    cout<<"3. Guardar en TXT"<<endl;
    cout<<"4. Salir"<<endl;
    cout<<"Ingrese una opcion"<<endl;
    cin>>Ruiz_op;
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
        Ruiz_Guardar();
        Ruiz_Menu();
        break;
    case 4:
        cout<<"Saliendo del sistema..."<<endl;
        break;
    default:
        cout<<"Vuelva a ingresar"<<endl;
        Ruiz_Menu();

    }
}
void Ruiz_IngresoNotas(){
    cout<<"Ingrese Nota 1 (0-20)"<<endl;
    cin>>Ruiz_n1;
    while(Ruiz_n1<0||Ruiz_n1>20){
        cout<<"Vuelve a ingresar nota valida (0-20)"<<endl;
        cin>>Ruiz_n1;
    }
     cout<<"Ingrese Nota 2 (0-20)"<<endl;
    cin>>Ruiz_n2;
    while(Ruiz_n2<0||Ruiz_n2>20){
        cout<<"Vuelve a ingresar nota valida (0-20)"<<endl;
        cin>>Ruiz_n2;
    }
     cout<<"Ingrese Nota 3 (0-20)"<<endl;
    cin>>Ruiz_n3;
    while(Ruiz_n3<0||Ruiz_n3>20){
        cout<<"Vuelve a ingresar nota valida (0-20)"<<endl;
        cin>>Ruiz_n3;
    }
}

void Ruiz_Promedio(){
    int Ruiz_n=3,Ruiz_base=14;
    Ruiz_pro=(Ruiz_n1+Ruiz_n2+Ruiz_n3)/Ruiz_n;
    if(Ruiz_pro>=Ruiz_base){
        cout<<"APROBADO"<<endl;
    }else{
        cout<<"REPROBADO"<<endl;
    }
}

void Ruiz_Guardar (){

    ofstream archivo;
    string Ruiz_nombreArchivo;

    cin.ignore();
    cout<<"INGRESE NOMBRE DEL ARCHIVO: "<<endl;
    getline(cin,Ruiz_nombreArchivo);

    Ruiz_nombreArchivo+=".txt";

    archivo.open(Ruiz_nombreArchivo.c_str(),ios::out);

    if(archivo.fail()){
        cout<<"no existe"<<endl;
        exit(1);
    }
       for(int i=0;i<1;i++){
        archivo<<" Nota 1: "<<Ruiz_n1;
        archivo<<" Nota 2: "<<Ruiz_n2;
        archivo<<" Nota 3: "<<Ruiz_n3;
        archivo<<" PROMEDIO: "<<Ruiz_pro;
        archivo<<""<<endl;
}
    archivo.close();
}
