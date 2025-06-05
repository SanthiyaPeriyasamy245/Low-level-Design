package Builder;

public class Phone {
	
	@Override
	public String toString() {
		return "Phone [ram=" + ram + ", rom=" + rom + ", screenSize=" + screenSize + ", batteryCapacity="
				+ batteryCapacity + "]";
	}
	private final int ram;
	private final int rom;
	private String screenSize;
	private int batteryCapacity; 
	
	
   private Phone(int ram, int rom, String screenSize, int batteryCapacity) {
		
		this.ram = ram;
		this.rom = rom;
		this.screenSize = screenSize;
		this.batteryCapacity = batteryCapacity;
	}
	 static class CreatePhone{
		
		// standard values.
		
		private final int ram;
		private final int rom;
		
		// this can be varied.
		private  String screenSize;
		private   int batteryCapacity;
		public CreatePhone(int ram,int rom)
		{
			this.ram=ram;
			this.rom=rom;
		}
		public CreatePhone addScreenSize(String size)
		{
			this.screenSize=size;
			return this;
		}
		public CreatePhone addBattery(int capacity)
		{
			this.batteryCapacity=capacity;
			return this ;
		}
		public Phone build()
		{
			return new Phone(ram,rom,screenSize,batteryCapacity);
		}
		@Override
		public String toString() {
			return "Phone [ram=" + ram + ", rom=" + rom + ", screenSize=" + screenSize + ", batteryCapacity="
					+ batteryCapacity + "]";
		}
	}

}
