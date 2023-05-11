import java.util.Date;

public interface Medicijn {
    String neemMedicijn(int dosering);
    String getNaam();
    int getHoeveelheid();
    int getDosering();
    void setTijd(Date tijd);
}
