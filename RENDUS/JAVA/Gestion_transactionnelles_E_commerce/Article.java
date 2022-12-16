package Gestion_transactionnelles_E_commerce;
import java.util.*;


public class Article {


    private int id;

    private String nom;

    private int prix;

    private static int numero;

    private Set<Dataset> element;

    public Article(String nom, int prix) {

        this.nom = nom;
        this.prix = prix;
    }
}