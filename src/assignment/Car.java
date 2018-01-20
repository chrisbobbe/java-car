package assignment;

import java.util.ArrayList;
import java.util.Iterator;

public class Car implements Interactive {
	private ArrayList<CarPart> parts = new ArrayList<>();
	
	/* CONSTRUCTOR */
	
	public Car() {
		this.parts.add(new GasTank(17.2f, 35));
		this.parts.add(new OilTank(1));
		this.parts.add(new Engine(0));
		for (int t = 0; t<4; t++) {
			this.parts.add(new Tire(32));
		}
	}
	
	/* GETTERS */
	
	public String getParts() { return toString(this.parts); }
	
	public String toString(ArrayList<CarPart> partsList) {
		String result = "";
		for (Iterator<CarPart> iter = partsList.iterator(); iter.hasNext();) {
			result += ((CarPart) iter.next()).partName + "\n";
		}
		return result;
	}
	
	public void status() {
		for (Iterator<CarPart> iter = this.parts.iterator(); iter.hasNext();) {
			iter.next().status();
		}
	}
	
	public void run() {
		try {
			do {
				float miles = getFloat("How many miles are you driving?");
				OilTank oTank = null;
				Engine engine = null;
				for (int p = 0; p<parts.size(); p++) {
					parts.get(p).function(miles);
					if (parts.get(p).partName == "oil tank") { oTank = (OilTank) parts.get(p); }
					if (parts.get(p).partName == "engine") { engine = (Engine) parts.get(p); }
				}
				// The oil tank's behavior is affected by the engine's age in years,
				// which are actually real-life minutes.
				oTank.setEngineAgeModifier(1 + (engine.getLifeInMinutes() / engine.getBestCondition()));
			} while (getBoolean("Keep driving?"));
			this.status();
		} catch (CarCrashException e) {
			System.out.println(e.getMessage());
			System.out.println("Your car crashed! You'll have to buy a new one and start over.");
		} finally {
			System.out.println("Thank you for driving responsibly.");
		}
	}
}
