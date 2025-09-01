package trafficlight;
class trafficlight{

public static void setTrafficLightState( String direction, String color, int duration){
    try{
Thread.sleep(duration);
System.out.println("Traffic light " + direction + " " + color + " for " + duration + " seconds.");
    } catch (InterruptedException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public static void main(String[] args) {
       System.out.println("Hello World");
       int NS_Green = 40;
       int NS_Yellow = 5;
       int NS_Red = 1;
       int EW_Green = 40;
       int EW_Yellow = 5;
       int EW_Red = 1;
       setTrafficLightState("NS", "Green", NS_Green);
       setTrafficLightState("NS", "Yellow", NS_Yellow);
       setTrafficLightState("NS", "Red", NS_Red);
       setTrafficLightState("EW", "Green", EW_Green);
       setTrafficLightState("EW", "Yellow", EW_Yellow);
       setTrafficLightState("EW", "Red", EW_Red);

    }
}