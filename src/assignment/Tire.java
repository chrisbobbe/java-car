package assignment;

import java.util.Random;

public class Tire extends CarPart {
	private static short instanceCount;
	private short tireNumber;
	private float inflationPSI;
	
	/* CONSTRUCTOR */
	
	public Tire(float inflationPSI) {
		super("tire", "% traction", 100);
		instanceCount += 1;
		this.tireNumber = instanceCount;
		this.inflationPSI = inflationPSI;
		if (instanceCount > 4) {
			this.status("Initializing alien technology for a fifth wheel...\n"
					+ "Initialization failed, please abort! Abort!");
		}
	}
	
	/* GETTERS */
	
	public float getInflationPSI() { return this.inflationPSI; }
	public short getTireNumber() { return this.tireNumber; }
	
	/* SETTERS */
	
	// Override to make sure tires are filled when replaced
	// (inflationPSI isn't a default field of CarPart).
	public void replacePart() {
		super.replacePart();
		this.inflationPSI = 32;
	}
	
	// Override status method to include tire number, not just serial number
		public void status() {
			System.out.println("Tire #" + this.tireNumber + " (serial #00" + this.serialNumber + ") is at "
					+ this.condition + this.conditionMeasure + " and " + this.inflationPSI + "psi.");
		}
		public void status(String extraMessage) {
			System.out.print("Tire #" + this.tireNumber +  " ("
					+ this.condition + this.conditionMeasure + ", " + this.inflationPSI + "psi) says: ");
			System.out.println(extraMessage);
		}
	
	public void function(float milesDriven) throws CarCrashException{
		super.function(milesDriven);
		Random rand = new Random();
		this.changeCondition(-1 * (milesDriven / 1000) * rand.nextFloat());
		float pressureLoss;
		for (int i=0; i<(milesDriven); i++) {
			if (rand.nextInt(2000) == 1999) {
				pressureLoss = (rand.nextFloat() * this.inflationPSI * 0.5f);
				this.inflationPSI -= pressureLoss;
				this.status("Tire #" + this.tireNumber + " just lost " + pressureLoss + "psi!");
				break;
			}
		}
		if (this.condition < 10 || this.inflationPSI < 15) {
			this.crashCar();
		} else if (this.condition < 25) {
			this.status("Low on traction.");
			if (getBoolean("Replace?")) {
				this.replacePart();
				this.status("Just replaced this worn-out tire.");
			}
		} else if (this.inflationPSI < 27) {
			int remainder = 32 - (int) this.inflationPSI;
			this.status("Tire is low!");
			if (getBoolean("Fill it?")) {
				this.inflationPSI = 32;
				this.status("Traction is OK but just added " + remainder + "psi to fill this tire.");
			}
		} else {
			this.status("This tire has enough air and traction.");
		}
	}
}
