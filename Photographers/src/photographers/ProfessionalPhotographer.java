package photographers;

public class ProfessionalPhotographer implements Photographer {

    @Override
    public void takePhoto() {
        System.out.println("Smile, click, oh, beautiful ($500 please)");
    }
}
