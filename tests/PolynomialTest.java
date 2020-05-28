import org.junit.Test;

import java.security.Policy;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class PolynomialTest {
    private Polynomial polinomio;

    @Test
    public void setup(){
        polinomio = new Polynomial();
        assertTrue(polinomio.isEmpty());
    }

    @Test
    public void TestPolynomialFunction(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        assertEquals("[1X^1 + 2X^2 + 3X^3]",polinomio.toString());

    }
    @Test
    public void testToStringEmptyList(){
        polinomio = new Polynomial();
        assertEquals("[]",polinomio.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetNegativeNumberFails(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        polinomio.getCoefficient(-1);
    }

    @Test(expected = NoSuchElementException.class)
    public void testInvalidGradFails(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        polinomio.getCoefficient(6);
    }

    @Test
    public void testGetCoefficientCoefInt(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        assertEquals(2,polinomio.getCoefficient(2));
    }

    @Test
    public void testGetCoefficientCoefZero(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        assertEquals(0,polinomio.getCoefficient(5));
    }

    @Test(expected = NoSuchElementException.class)
    public void testSetCoefficientMenZero(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        polinomio.getCoefficient(-1);
    }

    @Test(expected = NoSuchElementException.class)
    public void testSetCoefficientOutOfGrad(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        polinomio.getCoefficient(6);
    }
    @Test
    public void testSetCoeficcientExists(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        polinomio.setCoefficient(1,5);
        assertEquals("[5X^1 + 2X^2 + 3X^3]",polinomio.toString());
    }

    @Test
    public void testSetCoeficcientIntermediate(){
        int[] coef = {1,0,3,0,0};
        polinomio = new Polynomial(coef);
        polinomio.setCoefficient(2,5);
        assertEquals("[1X^1 + 5X^2 + 3X^3]",polinomio.toString());
    }

    @Test
    public void testSetCoeficcientUltimate(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        polinomio.setCoefficient(4,5);
        assertEquals("[1X^1 + 2X^2 + 3X^3 + 5X^4]",polinomio.toString());
    }

    @Test
    public void  testValueof(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        float valor = polinomio.valueOf(3);
        assertTrue(102 == valor);
    }

    @Test
    public void testAdd(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        int[] coef2 = {0,0,0,1,2};
        Polynomial polinomio2 = new Polynomial(coef2);
        Polynomial resultado = polinomio.add(polinomio2);
        assertEquals("[3X^3 + 2X^2 + 1X^1 + 2X^5 + 1X^4]",resultado.toString());

    }

    @Test
    public void testEquals(){
        int[] coef = {1,2,3,0,0};
        polinomio = new Polynomial(coef);
        int[] coef2 = {1,2,3,0,0};
        Polynomial polinomio2 = new Polynomial(coef2);
        assertTrue(polinomio.equals(polinomio2));
    }

/*


    @Test
    public void testToStringNotEmptyList(){

    }
*/

}