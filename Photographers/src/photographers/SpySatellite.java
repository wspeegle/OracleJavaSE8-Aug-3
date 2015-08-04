package photographers;

public class SpySatellite implements Flyer, Photographer {

    @Override
    public void takeOff() {
        System.out.println("Massive roar, smell of burning hydrazine");
    }

    @Override
    public void takePhoto() {
        System.out.println("beep beep click... I can read your license plate");
    }

}
