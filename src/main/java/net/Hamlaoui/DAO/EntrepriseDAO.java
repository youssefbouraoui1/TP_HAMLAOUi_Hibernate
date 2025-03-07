package net.Hamlaoui.DAO;

import net.Hamlaoui.Entities.Entreprises;
import net.Hamlaoui.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EntrepriseDAO {


    public void ajouterEntreprise(Entreprises entreprise) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entreprise);
        transaction.commit();
        session.close();
        System.out.println("Entreprise ajoutée avec ID : " + entreprise.getIdEntreprise());
    }

    public Entreprises getEntrepriseById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Entreprises entreprise = session.get(Entreprises.class, id);
        session.close();
        return entreprise;
    }


    public List<Entreprises> getAllEntreprises() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Entreprises> entreprises = session.createQuery("FROM Entreprises", Entreprises.class).list();
        session.close();
        return entreprises;
    }


    public Entreprises getEntrepriseByNom(String nom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Entreprises entreprise = session.createQuery("FROM Entreprises WHERE nomEnt = :nom", Entreprises.class)
                .setParameter("nom", nom)
                .uniqueResult();
        session.close();
        return entreprise;
    }


    public List<Entreprises> getEntreprisesSortedByNbEmployes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Entreprises> entreprises = session.createQuery("FROM Entreprises ORDER BY nbEmployes", Entreprises.class).list();
        session.close();
        return entreprises;
    }


    public long getNombreEntreprises() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        long count = (long) session.createQuery("SELECT COUNT(*) FROM Entreprises").uniqueResult();
        session.close();
        return count;
    }


    public void updateNomEntreprise(int id, String nouveauNom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Entreprises entreprise = session.get(Entreprises.class, id);
        if (entreprise != null) {
            entreprise.setNomEnt(nouveauNom);
            session.update(entreprise);
            transaction.commit();
            System.out.println("Nom mis à jour !");
        } else {
            System.out.println("Entreprise non trouvée.");
        }
        session.close();
    }


    public void deleteEntreprise(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Entreprises entreprise = session.get(Entreprises.class, id);
        if (entreprise != null) {
            session.delete(entreprise);
            transaction.commit();
            System.out.println("Entreprise supprimée !");
        } else {
            System.out.println("Entreprise non trouvée.");
        }
        session.close();
    }
}

