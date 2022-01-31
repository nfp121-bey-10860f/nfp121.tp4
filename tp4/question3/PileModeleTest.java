package question3;

import question3.tp3.*;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

public class PileModeleTest extends junit.framework.TestCase {
    PileModele <Integer> p;
    
    public PileModeleTest() {
    }

    protected void setUp()
    {
        p = new PileModele<Integer>(new Pile2<Integer>(3));

    }

    protected void tearDown()
    {
        p = null;
    }

    public void test_Pile_capacite() {
        assertEquals(3, p.capacite());
    }
    
    public void test_Pile_estPleine() throws Exception {
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question3.tp3.PilePleineException);
        }
    }
    
    public void test_Pile_sommet() throws Exception {
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(" sommet ?? ", new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }
    
    public void test_Pile_estVide() throws Exception {
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question3.tp3.PileVideException);
        }
    }

}