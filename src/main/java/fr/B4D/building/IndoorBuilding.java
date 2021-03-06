package fr.B4D.building;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import fr.B4D.bot.B4D;
import fr.B4D.bot.B4DException;
import fr.B4D.bot.Person;
import fr.B4D.program.CancelProgramException;
import fr.B4D.program.StopProgramException;
import fr.B4D.utils.PointF;

/** The class {@code IndoorBuilding} represents a building on the map which is inside.<br><br>
 * This class extends {@code Building}.
 * An indoor building has a list of points to get into and a list of points to get out.
 */
public abstract class IndoorBuilding extends Building{

	private Boolean entered;
	private List<PointF> inPoints;
	private List<PointF> outPoints;

	  /*************/
	 /** BUILDER **/
	/*************/
	
	/** Builder of the {@code IndoorBuilding} class.
	 * @param position - Position on the map. Cannot be {@code null}.
	 * @param inPoints - List of points to get into the building.
	 * @param outPoints - List of points to get out of the building.
	 */
	public IndoorBuilding(Point position, List<PointF> inPoints, List<PointF> outPoints) {
		super(position);
		
		if(inPoints == null)
			inPoints = new ArrayList<PointF>();
		if(outPoints == null)
			outPoints = new ArrayList<PointF>();
		
		this.inPoints = inPoints;
		this.outPoints = outPoints;
		this.entered = Boolean.FALSE;
	}

	  /***************/
	 /** GET & SET **/
	/***************/
	
	/** Returns the points to get into the building.
	 * @return List of points to get into the building.
	 */
	public List<PointF> getInPoints() {
		return inPoints;
	}

	/** Returns the points to get out of the building.
	 * @return List of points to get out of the building.
	 */
	public List<PointF> getOutPoints() {
		return outPoints;
	}
	
	  /********************/
	 /** PUBLIC METHODS **/
	/********************/

	/** Enters the building if not entered yet.
	 * @param person Person which enter the building.
	 * @throws StopProgramException If the program has been stopped.
	 * @throws CancelProgramException If the program has been canceled.
	 * @throws B4DException If a B4D exception has been raised.
	 */
	public void enter(Person person) throws StopProgramException, CancelProgramException, B4DException {
		super.goTo(person);
		
		if(inPoints != null && !this.entered) {
			for(PointF point:inPoints)
				B4D.mouse.leftClick(point, true, 10000);
		}
		this.entered = Boolean.TRUE;
	}
	
	/** Exits the building if the player has entered.
	 * @param person Person which enter the building.
	 * @throws StopProgramException If the program has been stopped.
	 * @throws CancelProgramException If the program has been canceled.
	 */
	public void exit(Person person) throws StopProgramException, CancelProgramException {
		if(outPoints != null && this.entered) {
			for(PointF point:outPoints)
				B4D.mouse.leftClick(point, true, 10000);
		}
	}
}
