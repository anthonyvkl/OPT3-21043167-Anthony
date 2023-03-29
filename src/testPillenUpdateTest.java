import org.junit.Before;
import static org.junit.jupiter.api.Assertions.*;



class testPillenUpdateTest {

    @Before
    public void testPillenUpdate(){
        Pillen pillen1 = new Pillen("Vitamine C", 3, 75);
        pillen1.update();

        assertEquals(72, pillen1.getAantalPillen());

    }

}