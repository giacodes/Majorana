package frazione;

import java.io.*;

/**
 *
 * @author Martino Giacovazzo
 */
public class Frazione {

private int Numeratore,Denominatore;

public Frazione()
        {
        Numeratore=0;
        Denominatore=1;
        }

public Frazione(int Num,int Denom)
        {
        Numeratore=Num;
        Denominatore=Denom;
        this.MinimiTermini();
        }

public Frazione(int Num)
        {
        Numeratore=Num;
        Denominatore=1;
        }

public Frazione(double Num)
        {
        int i=0;
        while(Num!=(int)(Num))
            {
            Num=Num*10;
            i++;
            }
        Numeratore=(int)Num;
        Denominatore=(int)(Math.pow(10,i));
        this.MinimiTermini();
        }

public Frazione(double Num,int Anti,int Periodo)
        {
        int i,App = 0;
        Numeratore=(int)(SenzaVirgola(Num)-SpostaVirgola(SenzaVirgola(Num),Periodo));
        for(i=Anti;i<Periodo+Anti;i++)
            Denominatore=Denominatore+(int)(9*Math.pow(10,i));
        this.MinimiTermini();
        }

private double SenzaVirgola(double Num)
        {
        while(Num!=(int)(Num))
            Num=Num*10;
        return Num;
        }

private double SpostaVirgola(double Num,int Periodo)
        {
        int Lung;
        String Stringa;
        Stringa=String.valueOf(Num);
        Lung=Stringa.length();
        Stringa=Stringa.substring(0,Lung-Periodo-2);
        return Double.valueOf(Stringa);
        }

public void Acquisisci() throws IOException
        {
        String s;
        boolean esci;
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        do
        {
            s=tastiera.readLine();

            esci=true;
            try
            {
            Numeratore=Integer.parseInt(s);
            }
            catch (Exception NumberFormatException)
            {
            System.out.println("Non numero");
            esci=false;
            }

            }
        while(esci==false);
        do
            {
            s=tastiera.readLine();
            Denominatore=Integer.parseInt(s);
            }
        while(Denominatore == 0);
        this.MinimiTermini();
        }

public void Assegna(Frazione b)
        {
        Numeratore=b.Numeratore;
        Denominatore=b.Denominatore;
        return;
        }

private int MassimoComuneDivisore(int a,int b)
        {
        int r,Dividendo,Divisore;
        if(a<b)
            {
            Divisore=a;
            Dividendo=b;
            }
        else
            {
            Divisore=b;
            Dividendo=a;
            }
        r=Dividendo%Divisore;
        if(r==0)
            return Divisore;
        else
            return MassimoComuneDivisore(Dividendo,r);
        }

private void MinimiTermini()
        {
        int MCD;
        MCD=MassimoComuneDivisore(Numeratore,Denominatore);
        Numeratore=Numeratore/MCD;
        Denominatore=Denominatore/MCD;
        }

public int Confronto(Frazione a,Frazione b)
        {
        double Primo,Secondo;
        Primo=a.Numeratore/a.Denominatore;
        Secondo=b.Numeratore/b.Denominatore;
        if(Primo == Secondo)
            return 0;
        else
            {
            if(Primo < Secondo)
                return -1;
            else
                return 1;
            }
        }

public void Addizione(Frazione a,Frazione b)
        {
        Denominatore=a.Denominatore*b.Denominatore;
        Numeratore=(a.Numeratore*b.Denominatore+b.Numeratore*a.Denominatore);
        this.MinimiTermini();
        return;
        }

public void Sottrazione(Frazione a,Frazione b)
        {
        Denominatore=a.Denominatore*b.Denominatore;
        Numeratore=(a.Numeratore*b.Denominatore-b.Numeratore*a.Denominatore);
        this.MinimiTermini();
        return;
        }

public void Moltiplicazione(Frazione a,Frazione b)
        {
        Denominatore=a.Denominatore*b.Denominatore;
        Numeratore=a.Numeratore*b.Numeratore;
        this.MinimiTermini();
        return;
        }

public void Divisione(Frazione a,Frazione b)
        {
        if(b.Numeratore!=0)
            {
            Denominatore=a.Denominatore*b.Numeratore;
            Numeratore=a.Numeratore*b.Denominatore;
            }
        this.MinimiTermini();
        return;
        }

public void Potenza(int pot)
        {
        Denominatore=(int)Math.pow(Denominatore,pot);
        Numeratore=(int)Math.pow(Numeratore,pot);
        this.MinimiTermini();
        return;
        }

public void Visualizza()
        {
        System.out.println(Numeratore+"/"+Denominatore);
        }

}
