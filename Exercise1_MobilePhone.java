
/**
 * Write a description of class Exercise1_MobilePhone here.
 * group 6
 * @author (mohd sheha khamis)
 * @version (5 feb 2026)
 */
public class Exercise1_MobilePhone
{
    private String brand;
    private String model;
    private double price;
    private int batteryLevel;
    private boolean isOn;
    

    public Exercise1_MobilePhone() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.price = 0.0;
        this.batteryLevel = 100;
        this.isOn = false;
    }
    
    public Exercise1_MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        setPrice(price);
        this.batteryLevel = 100;
        this.isOn = false;
    }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getPrice() { return price; }
    public int getBatteryLevel() { return batteryLevel; }
    public boolean getIsOn() { return isOn; }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Error: Price cannot be negative.");
        }
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Error: Battery must be between 0 and 100.");
        }
    }
    
    public void turnOn() {
        if (batteryLevel > 0) {
            isOn = true;
            System.out.println(brand + " " + model + " is turning on...");
        } else {
            System.out.println("Battery is too low to turn on.");
        }
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println("the phone shuttingdown.");
    }

    public void makeCall(String contactName) {
        if (isOn && batteryLevel >= 5) {
            System.out.println("Calling " + contactName + ".....");
            batteryLevel -= 5;
        } else if (!isOn) {
            System.out.println("Turn the phone on first!");
        } else {
            System.out.println("Insufficient battery to call.");
        }
    }

    public void chargeBattery(int minutes) {
        int addedPower = minutes * 2;
        batteryLevel = Math.min(100, batteryLevel + addedPower);
        System.out.println("Charged for " + minutes + " mins. Battery now at " + batteryLevel + "%.");
    }

    public void displayInfo() {
        System.out.println("--- PhoneDetails ---");
        System.out.println("the brand: " + brand + " | Model: " + model);
        System.out.println("the price: TSh " + price + " | Battery: " + batteryLevel + "%");
        System.out.println("Status: " + (isOn ? "ON" : "OFF"));
        System.out.println("---------------\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Mobile Phone Exercise ===\n");
        Exercise1_MobilePhone phone1 = new Exercise1_MobilePhone();
        Exercise1_MobilePhone phone2 = new Exercise1_MobilePhone("Samsung", "Galaxy S24", 2500000);
        phone2.turnOn();
        phone2.makeCall("mohd");
        phone2.makeCall("jima");
        phone2.makeCall("mahir");
        phone2.displayInfo();
        phone2.chargeBattery(10);
        phone2.displayInfo();
        System.out.println(" === the exercise Complete ===");
    }
}
