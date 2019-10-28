package fr.B4D.programs;

import fr.B4D.bot.B4D;
import fr.B4D.bot.B4DException;
import fr.B4D.bot.Person;
import fr.B4D.program.CancelProgramException;
import fr.B4D.program.Category;
import fr.B4D.program.FullInventoryException;
import fr.B4D.program.Place;
import fr.B4D.program.Program;
import fr.B4D.program.ProgramInterface;
import fr.B4D.program.StopProgramException;

public final class Test {
	public static ProgramInterface test = new ProgramInterface() {
		public void intro(Person person) {}
		public void outro(Person person) {}
		public void cycle(Person person) throws FullInventoryException, StopProgramException, CancelProgramException, B4DException {
			B4D.logger.popUp("Le programme de test marche correctement.");
		}
	};
	public final static Program TEST = new Program(Place.Tous, Category.Test, "Test", "Test", null, null, test);
}
