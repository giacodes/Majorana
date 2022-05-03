package frazione;

import java.io.IOException;

/**
 *
 * @author Martino Giacovazzo
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Frazione a=new Frazione(34.1892,2,2);
        Frazione b=new Frazione(3.5);
        Frazione c=new Frazione(3,4);
        Frazione d=new Frazione(3);
        Frazione e=new Frazione();
        e.Acquisisci();
                e.Visualizza();
    }

}
