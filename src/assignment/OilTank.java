package assignment;

public class OilTank extends CarPart {
	private float engineAgeModifier;
	
	/* CONSTRUCTOR */
	
	public OilTank(float engineAgeModifier) {
		super("oil tank", " miles until change", 5000);
		this.engineAgeModifier = engineAgeModifier;
	}
	
	/* GETTERS */
	
	public float getEngineAgeModifier() { return this.engineAgeModifier; }
	
	/* SETTERS */
	
	public void setEngineAgeModifier(float newModifier) {
		this.engineAgeModifier = newModifier;
	}
	
	public void function(float milesDriven) throws CarCrashException{
		super.function(milesDriven);
		this.changeCondition(-1 * milesDriven);
		this.setCondition(this.condition / this.engineAgeModifier);
		if (this.condition <= 0) {
			this.status("Time to change the oil.");
			if (getBoolean("Go ahead?")) {
				this.setCondition(5000);
				this.status("Oil changed!");
			} else {
				this.crashCar();
			}
		} else {
			this.status("You should change your oil after " + this.condition + " more miles.");
		}
	}
}
