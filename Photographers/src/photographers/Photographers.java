package photographers;

public class Photographers {

    public static void main(String[] args) {
        Photographer [] photogs = {
            new Mother(),
            new ProfessionalPhotographer(),
            new SpySatellite(),
        };
        
        for (Photographer p : photogs) {
            if (p instanceof SpySatellite) {
                ((SpySatellite)p).takeOff();
            }
            p.takePhoto();
        }
    }
}
