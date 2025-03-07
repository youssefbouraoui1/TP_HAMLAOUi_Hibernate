package net.Hamlaoui;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import net.Hamlaoui.DAO.EntrepriseDAO;
import net.Hamlaoui.Entities.Entreprises;

public class Main {
    public static void main(String[] args) {
        EntrepriseDAO dao = new EntrepriseDAO();

        // Insert new enterprises
        dao.ajouterEntreprise(new Entreprises("TechCorp", "IT, Software", 150));
        dao.ajouterEntreprise(new Entreprises("HealthPlus", "Healthcare, Medical Equipment", 100));

        // Retrieve all enterprises
        dao.getAllEntreprises().forEach(System.out::println);
    }
}
