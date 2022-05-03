package progetto_data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Boolean.FALSE;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alunno
 */
public class Data {
    private int giorno,mese,anno;
    public Data () {
        GregorianCalendar gc = new GregorianCalendar();
        giorno = gc.get(Calendar.DAY_OF_MONTH);
        mese = gc.get(Calendar.MONTH)+1;
        anno = gc.get(Calendar.YEAR);
    
    }
    public Data (int gg, int mm, int aaaa) {
         giorno=gg;
         mese=mm; 
         anno=aaaa;
    }
    
    public Data(String s) {
            this.ConvertiStringa(s);
    }
    
    public void VisualizzaData() {
        System.out.println(Integer.toString(giorno)+"/"+Integer.toString(mese)+"/"+Integer.toString(anno));
        return;
    }    
    
    private boolean ConvertiStringa(String s){
        int posto;
        boolean corretta=true;
        String app;
        if(s.contains("/")==FALSE)
            System.out.println("Formato data non valido");
            else {
                posto=s.indexOf("/");
                giorno=Integer.parseInt(s.substring(0,posto));
                app=s.substring(posto+1);
                posto=app.indexOf("/");
                if (posto==-1){
                    System.out.println("Formato data non valido");
                    corretta=false;
                }
                else
                    mese=Integer.parseInt(app.substring(0,posto));
                    anno=Integer.parseInt(app.substring(posto+1));
                }
        return corretta;
    }
    
    private boolean Bisestile(int anno)
    {
       boolean ris;
       if(anno%4==0)
           if(anno%100==0)
               if(anno%400==0)
                   ris=true;
               else ris=false;
           else ris=true;
       else ris=false;
      return ris;
     }
    
    private int MaxGiorni(int mese,int anno)
    { 
        int ngiorni;
       if(mese==2) 
            if(Bisestile(anno)==true)
                 ngiorni=29;
            else ngiorni=28;
       else
           if(mese==4 || mese==6 || mese==9 || mese==11)
               ngiorni=30;
           else 
               ngiorni=31;
       return ngiorni;
    }
    
    public Data(int periodo)
    {
        int ngiorni;
        int nmesi;
         GregorianCalendar gc = new GregorianCalendar();
         giorno = gc.get(Calendar.DAY_OF_MONTH);
         mese = gc.get(Calendar.MONTH)+1;
         anno = gc.get(Calendar.YEAR);
         ngiorni=giorno+periodo;
         if(ngiorni <= MaxGiorni(mese,anno))
             giorno=ngiorni;
         else{
             nmesi=mese;
             do{
              if(nmesi>12){
               anno++;
               nmesi=1;}
               ngiorni=ngiorni-MaxGiorni(nmesi,anno);
               nmesi++;
               
              }while(ngiorni > MaxGiorni(nmesi,anno));
            
        
         }
    }
    
    private boolean Controllo()
    {
        int maxgiorni;
        maxgiorni=MaxGiorni(mese,anno);
        if(giorno>=1&&giorno<=maxgiorni&&mese>=1&&mese<=12&&anno>0)
            return true;
        else return false;
    }
    
    public void Acquisisci() throws IOException
    {
        String s;
        boolean corretta;
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        do{
            System.out.println("Inserire la data nel formato GG/MM/AAAA");
            s = tastiera.readLine();
            corretta=ConvertiStringa(s);
            if(!Controllo() || !corretta)
                System.out.println("Data non valida");
        }
        while(Controllo() != true);
        return;   
    }
    
    private int GiorniTrascorsiAnno()
    {
        int Tot=0;
        int i;
        i=1;
        while(i<mese){
            Tot=Tot+MaxGiorni(i,anno);
            i++;
        }
        Tot=Tot+giorno;
        return Tot;
    }
    
    public String GiornoSettimana()
    {
        String[] Giorno={"Sabato","Domenica","Lunedì","Martedì","Mercoledì","Giovedì","Venerdì"};
        int x;
        if(giorno>4 && mese>10 && anno>1582)
            x=anno+((anno-1)/4)-((anno-1)/100)+((anno-1)/400)+this.GiorniTrascorsiAnno();
        else
            x=anno+((anno-1)/4)+this.GiorniTrascorsiAnno()-2;
        return Giorno[x%7];
    }
    
    public int Comparazione(Data a,Data b)
    {
        int ris=0;
        if(a.anno < b.anno)
            ris=-1;
        else
        {
            if(a.anno > b.anno)
                ris=1;
            else
            {
                if(a.mese < b.mese)
                    ris=-1;
                else
                {
                    if(a.mese > b.mese)
                        ris=1;
                    else
                    {
                        if(a.giorno < b.giorno)
                            ris=-1;
                        else
                        {
                            if(a.giorno > b.giorno)
                                ris=1;
                        }
                    }
                }
            }
        }
        return ris;    
    }
   
    private int GiorniFineAnno(){
        int Tot=0,i;  
        i=mese;
        while(i<=12)
        {
            Tot=Tot+this.MaxGiorni(i,anno);
            i++;
        }
        Tot=Tot-giorno;
        return Tot;
    }
    
    public int GiorniIntercorrentiDate(Data a,Data b){
        int Tot=0;
        int i;
        if(a.mese==b.mese && a.anno==b.anno)
            Tot=b.giorno-a.giorno;
        else
        {
            if(a.anno==b.anno)
            {
                Tot=this.MaxGiorni(a.mese,a.anno)-a.giorno;
                i=a.mese+1;
                while(i<b.mese)
                {
                    Tot=Tot+this.MaxGiorni(i,a.anno);
                    i++;
                }
                Tot=Tot+b.giorno;
            }
            else
            {
                Tot=Tot+a.GiorniFineAnno();
                i=a.anno+1;
                while(i<b.anno)
                {
                    if (Bisestile(i)==true)
                        Tot=Tot+366;
                    else
                        Tot=Tot+365;
                    i++;
                }
                Tot=Tot+b.GiorniTrascorsiAnno();
            }
        }
    return Tot;
    }
    
    public void DataLettere(){
        String[] Giorno={"Primo","Due","Tre","Quattro","Cinque","Sei","Sette","Otto","Nove","Dieci","Undici","Dodici","Tredici","Quattordici","Quindici","Sedici","Diciasette","Diciotto","Diaciannove","Venti","Ventuno","Ventidue","Ventitre","Ventiquattro","Venticinque","Ventisei","Ventisette","Ventotto","Ventinove","Trenta","Trentuno"};
        String[] Mese={"Gennaio","Febbraio","Marzo","Aprile","Maggio","Giugno","Luglio","Agosto","Settembre","Ottobre","Novembre","Dicembre"};
        System.out.println(Giorno[giorno-1]+" "+Mese[mese-1]+" "+anno);
        return;
    }
}
