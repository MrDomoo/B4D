package fr.B4D.program;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import fr.B4D.bot.B4D;
import fr.B4D.bot.Person;
import fr.B4D.dofus.B4DCannotFind;
import fr.B4D.dofus.Dofus;
import fr.B4D.farming.Ressource;
import fr.B4D.farming.RessourceType;
import fr.B4D.modules.B4DChat;
import fr.B4D.modules.B4DMouse;
import fr.B4D.modules.B4DOther;
import fr.B4D.modules.B4DScreen;
import fr.B4D.programs.Deplacement;
import fr.B4D.programs.Test;
import fr.B4D.transport.B4DWrongPosition;
import fr.B4D.utils.PointF;
import net.sourceforge.tess4j.TesseractException;

public class Program extends Thread implements Serializable{

	private static final long serialVersionUID = -4725926340583319625L;

	  /****************/
	 /** COLLECTION **/
	/****************/
	
	public final static Program deplacement = new Program(Place.Aucune, Category.Aucune, RessourceType.Aucun, Ressource.Aucune, Deplacement.deplacement);
	public final static Program test = new Program(Place.Aucune, Category.Test, RessourceType.Aucun, Ressource.Aucune, Test.test2);
	
	  /***************/
	 /** ATTRIBUTS **/
	/***************/
	
	private Person person;
	
	private Place place;
	private Category category;
	private RessourceType ressourceType;
	private Ressource ressource;

	private ProgramInterface program;
	
	private int maxCycles;
	private int maxDeposits;

	private boolean hdvWhenFull;
	private boolean bankWhenFull;
	private boolean stopWhenFull;
	
	  /******************/
	 /** CONSTRUCTEUR **/
	/******************/
	
	public Program(Place place, Category category, RessourceType type, Ressource ressource, ProgramInterface program) {
		this.place = place;
		this.category = category;
		this.ressourceType = type;
		this.ressource = ressource;
		this.program = program;
		this.maxCycles = -1;
		this.maxDeposits = -1;
	}
	
	  /************************/
	 /** METHODES STATIQUES **/
	/************************/
	
  public final static ArrayList<Program> getAll(){
  	ArrayList<Program> programs = new ArrayList<Program>();
  	programs.add(deplacement);
  	programs.add(test);
    return programs;
  }
	
	  /***********************/
	 /** GETTERS & SETTERS **/
	/***********************/
	
	public Place getPlace() {
		return place;
	}
	public Category getCategory() {
		return category;
	}
	public RessourceType getRessourceType() {
		return ressourceType;
	}
	public Ressource getRessource() {
		return ressource;
	}
	public int getMaxCycles() {
		return maxCycles;
	}
	public void setMaxCycles(int maxCycles) {
		this.maxCycles = maxCycles;
	}
	public int getMaxDeposits() {
		return maxDeposits;
	}
	public void setMaxDeposits(int maxDeposits) {
		this.maxDeposits = maxDeposits;
	}
	public boolean isHdvWhenFull() {
		return hdvWhenFull;
	}
	public void setHdvWhenFull(boolean hdvWhenFull) {
		this.hdvWhenFull = hdvWhenFull;
	}
	public boolean isBankWhenFull() {
		return bankWhenFull;
	}
	public void setBankWhenFull(boolean bankWhenFull) {
		this.bankWhenFull = bankWhenFull;
	}
	public boolean isStopWhenFull() {
		return stopWhenFull;
	}
	public void setStopWhenFull(boolean stopWhenFull) {
		this.stopWhenFull = stopWhenFull;
	}

	  /**************/
	 /** METHODES **/
	/**************/
	
	public void startWith(Person person) {
		this.person = person;
		start();
	}
	
	public void run() {
		try {
			if(this.category != Category.Test)
				Intro();
			Tours();
			if(this.category != Category.Test)
				Outro();
			
			B4D.logger.popUp("Le bot s'est correctement termin�.");
		}catch(B4DWrongPosition | AWTException | UnsupportedFlavorException | IOException | B4DCannotFind | TesseractException e){
			B4D.logger.error(e);
		}
	}

	private void Intro() throws B4DWrongPosition, AWTException, UnsupportedFlavorException, IOException{
		
		B4DOther.focusDofus();
		B4DChat.sendChat("/clear");
		
		if(B4DScreen.getPixelColor(new PointF(0.28, 0.99)).getGreen() > 200){	//Le mode solo n'est pas activ�
            B4DMouse.leftClick(new PointF(0.28, 0.99), false);                	//Clic sur status
            B4DMouse.leftClick(new PointF(0.3, 0.976), false);                	//Clic sur solo
		}

		B4D.getTeam().get(0).setPosition(Dofus.getWorld().getPosition());	//R�cup�re la position actuelle
	}
	private void Tours() throws AWTException, B4DCannotFind, B4DWrongPosition, UnsupportedFlavorException, IOException, TesseractException{
		int nbCycles = 0, nbDeposits = 0;

		while(nbCycles != maxCycles || nbDeposits != maxDeposits) {
			try {
				program.run(person);
			} catch (B4DFullInventory e) {			
				if(hdvWhenFull) {
					//Mettre en HDV
				}
				if(bankWhenFull) {
					//Mettre en banque
				}
				if(stopWhenFull)
					break;
				
				maxDeposits++;
				
			}finally {
				maxCycles++;
			}
		}
	}
	private void Outro() {
		//Nothing special for the moment
	}
}