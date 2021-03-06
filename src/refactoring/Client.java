package refactoring;

import java.util.ArrayList;

public class Client {
	
    private String nif;
    private String nom;
    private String telefon;
    private ArrayList<Lloguer> lloguers;

    public Client(String nif, String nom, String telefon) {
        this.nif = nif;
        this.nom = nom;
        this.telefon = telefon;
        this.lloguers = new ArrayList<Lloguer>();
    }

    public String getNif()     { return nif;     }
    public String getNom()     { return nom;     }
    public String getTelefon() { return telefon; }

    public void setNif(String nif) { this.nif = nif; }
    public void setNom(String nom) { this.nom = nom; }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    public void afegeix(Lloguer llog) {
        if (! lloguers.contains(llog) ) {
            lloguers.add(llog);
        }
    }
    public void elimina(Lloguer llog) {
        if (lloguers.contains(llog) ) {
            lloguers.remove(llog);
        }
    }
    public boolean conte(Lloguer llog) {
        return lloguers.contains(llog);
    }
    
    public String informe() {
        double total = 0;
        int bonificacions = 0;
        String resultat = "Informe de lloguers del client " +
            getNom() +
            " (" + getNif() + ")\n";
        for (Lloguer lloguer: lloguers) {
            double quantitat = lloguer.quantitat();

            // afegeix lloguers freqüents
            bonificacions ++;

            // afegeix bonificació per dos dies de lloguer de Luxe
            if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE &&
                    lloguer.getDies()>1 ) {
                bonificacions ++;
            }

            // composa els resultats d'aquest lloguer
            resultat += "\t" +
                lloguer.getVehicle().getMarca() +
                " " +
                lloguer.getVehicle().getModel() + ": " +
                (quantitat * 30) + "€" + "\n";
            total += quantitat * 30;
        }

        // afegeix informació final
        resultat += "Import a pagar: " + total + "€\n" +
            "Punts guanyats: " + bonificacions + "\n";
        return resultat;
    }
    
    public String informe2() {
        //double total = 0;
        //int bonificacions = 0;
        /*
    	String resultat = "Informe de lloguers del client " +
            getNom() +
            " (" + getNif() + ")\n";
         */
        //for (Lloguer lloguer: lloguers) {
        	
        	//quantitatPerLloguer(lloguer) -> no es orientació a objectes
        	        	
        	/*double quantitat = 0;
            switch (lloguer.getVehicle().getCategoria()) {
                case Vehicle.BASIC:
                    quantitat += 3;
                    if (lloguer.getDies() > 3) {
                        quantitat += (lloguer.getDies() - 3) * 1.5;
                    }
                    break;
                case Vehicle.GENERAL:
                    quantitat += 4;
                    if (lloguer.getDies() > 2) {
                        quantitat += (lloguer.getDies() - 2) * 2.5;
                    }
                    break;
                case Vehicle.LUXE:
                    quantitat += lloguer.getDies() * 6;
                    break;
            }
            */
            
            // EXTRACCIÓ DE MÉTODES
            
            //bonificacions += bonificacionsDeLloguer(lloguer);
        	// bonificacions += lloguer.bonificacions();
            /* 
            // afegeix lloguers freqüents
            // bonificacions ++;
             * afegeix bonificació per dos dies de lloguer de Luxe
            if (lloguer.getVehicle().getCategoria() == Vehicle.LUXE &&
                    lloguer.getDies()>1 ) {
                bonificacions ++;
            }*/
            
            // double quantitat = lloguer.quantitat(); //<-- es crea quantitat
            
        	
        	
        	// EXTRACCIÓ DE MÉTODES
            //bonificacions += bonificacionsDeLloguer(lloguer);
        	
        	
        	//bonificacions += lloguer.bonificacions();
        	// composa els resultats d'aquest lloguer
            /*resultat += "\t" +
                lloguer.getVehicle().getMarca() +
                " " +
                lloguer.getVehicle().getModel() + ": " +
                (lloguer.quantitat() * 30) + "€" + "\n"; //<-- aqui es consumeix quantitat
            */
            //total += lloguer.quantitat() * 30;
        //}

        // afegeix informació final
        /*resultat += "Import a pagar: " + importeTotal() + "€\n" +
            "Punts guanyats: " + bonificacionsTotal() + "\n";
        return resultat;
        */
        
        return composaCapsalera() +
        		composaDetall() +
        		composaPeu();
    }
    public String informeHTML() {
    	return composaCapsaleraHTML() +
        		composaDetallHTML() +
        		composaPeuHTML();
    }
    
    public double importeTotal() {
    	double total = 0;
    	for (Lloguer lloguer: lloguers) {
    		total += lloguer.quantitat() * 30;
    	}
    	return total;
    }
    
    public int bonificacionsTotal() {
    	int bonificacions = 0;
    	for (Lloguer lloguer: lloguers) {
    		bonificacions += lloguer.bonificacions();
    	}
    	return bonificacions;
	}
    
    public String composaCapsalera() {
    	String resultat = "Informe de lloguers del client " +
                getNom() +
                " (" + getNif() + ")\n";
    	return resultat;
    }
    public String composaDetall() {
    	String resultat = "";
    	for (Lloguer lloguer: lloguers) {
    		resultat += "\t" +
                lloguer.getVehicle().getMarca() +
                " " +
                lloguer.getVehicle().getModel() + ": " +
                (lloguer.quantitat() * 30) + "€" + "\n"; //<-- aqui es consumeix quantitat
    	}
    	return resultat;
    }
    public String composaPeu() {
        String resultat = "";
        resultat = "Import a pagar: " + importeTotal() + "€\n" +
                "Punts guanyats: " + bonificacionsTotal() + "\n";
        return resultat;
    }
    
    public String composaCapsaleraHTML() {
    	return "<h1>Informe de lloguers</h1>\t<p>Informe de lloguers de client <em>" + getNom() +
    			"</em> (<strong>" + getNif() +"</strong>)</p>\t";
    }
    public String composaDetallHTML() {
    	String resultat = "<table>\t"
    			+ "<tr><td><strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong></td></tr>\t";
    	for (Lloguer lloguer: lloguers) {
    		resultat += "<p><tr><td>" +
                lloguer.getVehicle().getMarca() +
                "</td><td>" +
                lloguer.getVehicle().getModel() + "</td><td>" +
                (lloguer.quantitat() * 30) + "€" + "</td><td></p>\t"; //<-- aqui es consumeix quantitat
    	}
    	resultat += "</table>\t";
    	return resultat;
    }
    public String composaPeuHTML() {
        
        return "<p>Import a pagar: <em>" + importeTotal() + "€</em></p>\t" +
                "<p>Punts guanyats: <em>" + bonificacionsTotal() + "</em></p>\t";
    }
    
    
    
}
