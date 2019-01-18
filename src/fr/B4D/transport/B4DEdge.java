package fr.B4D.transport;

import java.awt.Point;
import java.io.Serializable;

import org.jgrapht.graph.DefaultWeightedEdge;

public class B4DEdge extends DefaultWeightedEdge implements Serializable {

	private static final long serialVersionUID = -1834995736537050606L;
	
	private TransportType transportType;
	
	  /******************/
	 /** CONSTRUCTEUR **/
	/******************/
	
	public B4DEdge() {
		super();
	}

	  /***************/
	 /** GET & SET **/
	/***************/
	
	public Point getSource() {
		return (Point)super.getSource();
	}
	public Point getTarget() {
		return (Point)super.getTarget();
	}
	public double getWeight() {
		return super.getWeight();
	}
	public TransportType getTypeDeTransport() {
		return transportType;
	}
	public void setTypeDeTransport(TransportType transportType) {
		this.transportType = transportType;
	}
	
	  /**************/
	 /** METHODES **/
	/**************/
	
	public String toString() {
		return "(" + this.getSource() + ":" + transportType + ":" + this.getTarget() + ")";
	}
}
