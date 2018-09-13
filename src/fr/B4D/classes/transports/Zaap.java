package fr.B4D.classes.transports;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import fr.B4D.classes.B4DException;
import fr.B4D.classes.Bot;
import fr.B4D.classes.PointF;
import fr.B4D.classes.B4DException.Reason;
import fr.B4D.enu.ZaapType;
import fr.B4D.modules.B4DWait;
import fr.B4D.modules.B4DKeyboard;
import fr.B4D.modules.B4DSouris;

public class Zaap extends Transport{
	
	private ZaapType zaapType;
	
	public final static Zaap Amakna_Foret_Malefique = new Zaap("Amakna (Bord de la foret malefique)", new Point(-1, 13), new PointF(0.4052, 0.4068), ZaapType.Aucun);
    public final static Zaap Amakna_Chateau = new Zaap("Amakna (Chateau d'Amakna)", new Point(3, -5), new PointF(0.5024, 0.3426), ZaapType.Aucun);
    public final static Zaap Amakna_Coin_Bouftous = new Zaap("Amakna (Coin des Bouftous)", new Point(5, 7), new PointF(0.6806, 0.3437), ZaapType.Aucun);
    public final static Zaap Amakna_Montagne_Craqueleurs = new Zaap("Amakna (Montagne des Craqueleurs)", new Point(-5, -8), new PointF(0.7167, 0.1663), ZaapType.Aucun);
    public final static Zaap Amakna_Plaines_Scarafeuilles = new Zaap("Amakna (Plaine des Scarafeuilles)", new Point(-1, 24), new PointF(0.2576, 0.509), ZaapType.Aucun);
    public final static Zaap Amakna_Port_Madrestam = new Zaap("Amakna (Port de Madrestam)", new Point(7, -4), new PointF(0.6027, 0.2234), ZaapType.Aucun);
    public final static Zaap Amakna_Village = new Zaap("Amakna (Village d'Amakna)", new Point(-2, 0), new PointF(0.6798, 0.2325), ZaapType.Aucun);
    public final static Zaap Astrub = new Zaap("Astrub (Cite d'astrub)", new Point(4, -19), new PointF(0.5407, 0.4037), ZaapType.Aucun);
    public final static Zaap Sufokia_Rivage = new Zaap("Baie de Sufokia (Rivage sufokien)", new Point(10, 22), new PointF(0.5401, 0.3377), ZaapType.Aucun);
    public final static Zaap Sufokia_Village = new Zaap("Baie de Sufokia (Sufokia)", new Point(13, 26), new PointF(0.7376, 0.2896), ZaapType.Aucun);
    public final static Zaap Sufokia_Temple_Alliances = new Zaap("Baie de Sufokia (Temple des alliances)", new Point(13, 35), new PointF(0.8122, 0.1162), ZaapType.Aucun);
    public final static Zaap Bonta = new Zaap("Bonta (Centre-ville)", new Point(-32, -56), new PointF(0.4406, 0.3257), ZaapType.Aucun);
    public final static Zaap Brakmar = new Zaap("Brakmar (Centre-ville)", new Point(-26, 35), new PointF(0.5323741, 0.260479), ZaapType.Aucun);
    public final static Zaap Otomai_Village_Cotier = new Zaap("Ile d'Otomai (Village cotier)", new Point(-46, 18), new PointF(0.4647, 0.3437), ZaapType.Aucun);
    public final static Zaap Otomai_Village_Canopee = new Zaap("Ile d'Otomai (Village de la Canopee)", new Point(-54, 16), new PointF(0.496, 0.4228), ZaapType.Aucun);
    public final static Zaap Frigost_Bourgade = new Zaap("Ile de Frigost (La Bourgade)", new Point(-78, -41), new PointF(0.4848, 0.3367), ZaapType.Aucun);
    public final static Zaap Frigost_Village_Enseveli = new Zaap("Ile de Frigost (Village enseveli)", new Point(-77, -73), new PointF(0.3636, 0.5771), ZaapType.Aucun);
    public final static Zaap Moon_Plage_Tortue = new Zaap("Ile de Moon (Plage de la Tortue)", new Point(35, 12), new PointF(0.1549, 0.1222), ZaapType.Aucun);
    public final static Zaap Wabbits_Cawotte = new Zaap("Ile des Wabbits (Ile de la Cawotte)", new Point(25, -4), new PointF(0.626, 0.4509), ZaapType.Aucun);
    public final static Zaap Landres_Sidimote = new Zaap("Landres de Sidimote (Route des Roulottes)", new Point(-25, 12), new PointF(0.175, 0.497), ZaapType.Aucun);
    public final static Zaap Montagne_Koalaks = new Zaap("Montagne des Koalaks (Village des Eleveurs)", new Point(-16, 1), new PointF(0.4888, 0.3667), ZaapType.Aucun);
    public final static Zaap Pandala = new Zaap("Pandala Neutre (Faubourgs de Pandala)", new Point(26, -37), new PointF(0.2006, 0.2455), ZaapType.Aucun);
    public final static Zaap Cania_Champs_Cania = new Zaap("Plaine de Cania (Champs de Cania)", new Point(-27, -36), new PointF(0.3949, 0.4089), ZaapType.Aucun);
    public final static Zaap Cania_Lac_Cania = new Zaap("Plaine de Cania (Lac de Cania)", new Point(-3, -42), new PointF(0.7504, 0.2234), ZaapType.Aucun);
    public final static Zaap Cania_Massif_Cania = new Zaap("Plaine de Cania (Massif de Cania)", new Point(-13, -28), new PointF(0.6404, 0.3988), ZaapType.Aucun);
    public final static Zaap Cania_Plaine_Porkass = new Zaap("Plaine de Cania (Plaine des Porkass)", new Point(-5, -23), new PointF(0.3258, 0.3266), ZaapType.Aucun);
    public final static Zaap Cania_Plaines_Rocheuses = new Zaap("Plaine de Cania (Plaines Rocheuses)", new Point(17, -47), new PointF(0.3234, 0.3337), ZaapType.Aucun);
    public final static Zaap Cania_Routes_Rocailleuses = new Zaap("Plaine de Cania (Routes Rocailleuses)", new Point(-20, -20), new PointF(0.4302, 0.3537), ZaapType.Aucun);
    public final static Zaap Saharach = new Zaap("Saharach (Dunes des ossements)", new Point(15, -58), new PointF(0.3595, 0.3076), ZaapType.Aucun);
    public final static Zaap Tainela = new Zaap("Tain�la (Berceau)", new Point(1, -32), new PointF(0.4992, 0.3978), ZaapType.Aucun);
	
	  /******************/
	 /** CONSTRUCTEUR **/
	/******************/
	
	public Zaap(String nom, Point position, PointF positionF, ZaapType categoriesZaap) {
		super(nom, position, positionF);
		this.zaapType = categoriesZaap;
	}
	
	  /************************/
	 /** METHODES STATIQUES **/
	/************************/
	
    public final static ArrayList<Zaap> getAll(){
    	ArrayList<Zaap> zaaps = new ArrayList<Zaap>();
        zaaps.add(Amakna_Foret_Malefique);
        zaaps.add(Amakna_Chateau);
        zaaps.add(Amakna_Coin_Bouftous);
        zaaps.add(Amakna_Montagne_Craqueleurs);
        zaaps.add(Amakna_Plaines_Scarafeuilles);
        zaaps.add(Amakna_Port_Madrestam);
        zaaps.add(Amakna_Village);
        zaaps.add(Astrub);
        zaaps.add(Sufokia_Rivage);
        zaaps.add(Sufokia_Village);
        zaaps.add(Sufokia_Temple_Alliances);
        zaaps.add(Bonta);
        zaaps.add(Brakmar);
        zaaps.add(Otomai_Village_Cotier);
        zaaps.add(Otomai_Village_Canopee);
        zaaps.add(Frigost_Bourgade);
        zaaps.add(Frigost_Village_Enseveli);
        zaaps.add(Moon_Plage_Tortue);
        zaaps.add(Wabbits_Cawotte);
        zaaps.add(Landres_Sidimote);
        zaaps.add(Montagne_Koalaks);
        zaaps.add(Pandala);
        zaaps.add(Cania_Champs_Cania);
        zaaps.add(Cania_Lac_Cania);
        zaaps.add(Cania_Massif_Cania);
        zaaps.add(Cania_Plaine_Porkass);
        zaaps.add(Cania_Plaines_Rocheuses);
        zaaps.add(Cania_Routes_Rocailleuses);
        zaaps.add(Saharach);
        zaaps.add(Tainela);
        return zaaps;
    }
        
    public final static Zaap getZaap(Point position) throws B4DException{
    	for(Zaap zaap:getAll()) {
        	if(zaap.getPosition().equals(position))
        		return zaap;
        }
        throw new B4DException(Reason.CannotFind);
    }
	
	public static Zaap getZaap(String nom) throws B4DException {
    	for(Zaap zaap:getAll()) {
        	if(zaap.getNom().equals(nom))
        		return zaap;
        }
        throw new B4DException(Reason.CannotFind);
	}
    
	  /**************/
	 /** METHODES **/
	/**************/
	
	public void goTo(Point destination) throws B4DException {
		if (Bot.MyConfiguration.persons.get(0).position.equals(this.getPosition())){
			B4DSouris.Clic_Gauche(super.getPositionF(), false);

            if (B4DWait.waitForColor(new PointF(0.4472843, 0.7367896), new Color(186, 125, 0), new Color(255, 255, 50), 10)) {

                if (zaapType == ZaapType.Atelier)
                	B4DSouris.Clic_Gauche(new PointF(0.3253, 0.1626), false, 0.1);
                else if (zaapType == ZaapType.HDV)
                	B4DSouris.Clic_Gauche(new PointF(0.3253397, 0.1626), false, 0.1);
                else if (zaapType == ZaapType.Divers)
                	B4DSouris.Clic_Gauche(new PointF(0.6027178, 0.1626), false, 0.1);
                
                B4DSouris.Clic_Gauche(new PointF(0.60623, 0.2013958), false, 0.2);
                B4DKeyboard.writeKeyboard(getZaap(destination).getNom());
                B4DSouris.Double_Clic_Gauche(new PointF(0.4736422, 0.2891326), false);

                B4DWait.waitForMap();
                Bot.MyConfiguration.persons.get(0).position = destination;
            }
		}
	}
}