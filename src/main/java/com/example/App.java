package com.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App 
{
    public static void main( String[] args ) throws Exception
    {     
        Alunno a = new Alunno("Pippo", "Rossi", new Date(2006,07,12));
        Alunno b = new Alunno("Gioele", "Febbre", new Date(2005,12,03));
        Alunno c = new Alunno("DJ", "Yang", new Date(2003,06,12));
        Alunno d = new Alunno("Gabriele", "Lodde", new Date(2005,06,16));

        ArrayList <Alunno> arrayAlunni = new ArrayList<Alunno>();
        arrayAlunni.add(a);
        arrayAlunni.add(b);
        arrayAlunni.add(c);
        arrayAlunni.add(d);

        Classe c1 = new Classe(5, "BIA", "18-TW", arrayAlunni);

        System.out.println("------- XML -------");
        XmlMapper xmlMapper = new XmlMapper();

        xmlMapper.writeValue(new File("prova.xml"), c1);

        Classe c2 = xmlMapper.readValue(new File("prova.xml"), Classe.class);
        System.out.println("Numero classe: " + c2.getNumero());
        System.out.println("Sezione classe: " + c2.getSezione());
        System.out.println("Aula classe: " + c2.getAula() + "\n");

        for(int i = 0; i < c2.getAlunni().size(); i ++){
            System.out.println("Nome alunno " + (i + 1) + ": " + c2.getAlunni().get(i).getNome());
        }
    }
}