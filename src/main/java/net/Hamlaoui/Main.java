package net.Hamlaoui;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import net.Hamlaoui.DAO.EntrepriseDAO;
import net.Hamlaoui.Entities.Entreprises;

public class Main {
    public static void main(String[] args) {
        EntrepriseDAO dao = new EntrepriseDAO();


       /* dao.ajouterEntreprise(new Entreprises("TechCorp", "IT, Software", 150));
        dao.ajouterEntreprise(new Entreprises("HealthPlus", "Healthcare, Medical Equipment", 100));
        dao.ajouterEntreprise(new Entreprises("Leyton", "IA, Data Science", 1000));
        dao.ajouterEntreprise(new Entreprises("Oracle", "Database technologies, Cloud computing", 10000));*/
        //System.out.println(dao.getEntrepriseByNom("Leyton"));
        //dao.getEntreprisesSortedByNbEmployes().forEach(System.out::println);
        //System.out.println("\nnombre d'entreprises: "+dao.getNombreEntreprises());

       //dao.deleteEntreprise(1);

       System.out.println("entreprise avec id = 1: "+dao.getEntrepriseById(1));
    }
}
