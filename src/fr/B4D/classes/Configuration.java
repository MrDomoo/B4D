package fr.B4D.classes;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.ArrayList;

import fr.B4D.enu.Server;

public class Configuration implements Serializable{

	private static final long serialVersionUID = -1787414977374798817L;

	public ArrayList<Person> persons;
	public Rectangle gameFrame;
	public Rectangle chatFrame;
	public Point chatBar;
	public Point minimap;

	public boolean hdvWhenFull;
	public boolean bankWhenFull;
	public boolean stopWhenFull;
	
	public Configuration(){
		this.persons = new ArrayList<Person>();
		persons.add(new Person("Nom1", "MDP1", Server.values()[0], "Pseudo1"));
		persons.add(new Person("Nom2", "MDP2", Server.values()[1], "Pseudo2"));
		this.gameFrame = null;
		this.chatFrame = null;
		this.chatBar = null;
		this.minimap = null;
		this.hdvWhenFull = false;
		this.bankWhenFull = false;
		this.stopWhenFull = true;
	}
}
