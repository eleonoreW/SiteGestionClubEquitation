package javabeans;

public class Reservation {
    private int reservation_ID;
    private int date;
    private int nbPersonne;
    private int estActive;
    private Personne personne;
    private Activite activite;

    public Reservation(int reservation_ID, int date, int nbPersonne, int estActive, Personne personne, Activite activite) {
        this.reservation_ID = reservation_ID;
        this.date = date;
        this.nbPersonne = nbPersonne;
        this.estActive = estActive;
        this.personne = personne;
        this.activite = activite;
    }

    public Reservation(int date, int nbPersonne, int estActive, Personne personne, Activite activite) {
        this.date = date;
        this.nbPersonne = nbPersonne;
        this.estActive = estActive;
        this.personne = personne;
        this.activite = activite;
    }

    public int getReservation_ID() {
        return reservation_ID;
    }

    public int getDate() {
        return date;
    }

    public int getNbPersonne() {
        return nbPersonne;
    }

    public int getEstActive() {
        return estActive;
    }

    public Personne getPersonne() {
        return personne;
    }

    public Activite getActivite() {
        return activite;
    }
    
    
}
