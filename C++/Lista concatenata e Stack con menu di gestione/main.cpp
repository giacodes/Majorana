#include <iostream>
#include <stdlib.h>
#include <stdio.h>

#define TRUE 1
#define FALSE 0

using namespace std;

typedef struct{
    int INFO;
    int* LINK;
} NODO;
typedef NODO* PNODO;
typedef unsigned char BOOLEAN;

PNODO GENERANODO(int DATO);
void INLISTA(PNODO pNODO,PNODO *pLISTA);
void PUSH(int DATO,PNODO *pSP);
void POP(int &DATO,PNODO* pSP,BOOLEAN &EMPTY);
void VISUALIZZA(PNODO pLISTA);
void VISUALIZZAS(PNODO pSP);
void RICERCA(int DATO,PNODO pLISTA,PNODO *pPREC,PNODO *pNODO);
void DEALLOCAZIONE(PNODO pLISTA,PNODO pSP);
void ELIMINANODO(int DATO,PNODO *pLISTA);

int main()
{
    int DATO,CM;
    BOOLEAN EMPTY;
    PNODO pLISTA=NULL,pSP=NULL,pNODO,pPREC;
    while(CM!=7){
        cout<<"Digita:\n1)Genera nuovo nodo nella lista\n2)Push\n3)Pop\n4)Visualizzazione\n5)Ricerca dato da tastiera nella lista\n6)Elimina nodo\n7)Esci\n";
        cin>>CM;
        switch(CM){
            case 1:{
                cout<<"\nInserire dato: ";
                cin>>DATO;
                pNODO=GENERANODO(DATO);
                INLISTA(pNODO,&pLISTA);
                cout<<"Nodo generato ed inserito nella lista\n\n";
            }
            break;
            case 2:{
                cout<<"\nInserire dato: ";
                cin>>DATO;
                PUSH(DATO,&pSP);
                cout<<"Nodo generato ed inserito\n\n";
            }
            break;
            case 3:{
                EMPTY=FALSE;
                DATO=0;
                POP(DATO,&pSP,EMPTY);
                if(EMPTY==TRUE) cout<<"\nStack vuoto\n\n";
                else cout<<"\nDato estratto: "<<DATO<<"\n\n";
            }
            break;
            case 4:{
                cout<<endl;
                cout<<"Digita:\n1)Visualizza lista\n2)Visualizza stack\n";
                cin>>CM;
                if(CM==1) VISUALIZZA(pLISTA);
                else VISUALIZZAS(pSP);
                cout<<endl;
            }
            break;
            case 5:{
                cout<<"\nInserire il dato da ricercare: ";
                cin>>DATO;
                RICERCA(DATO,pLISTA,&pPREC,&pNODO);
                if(pNODO==NULL) cout<<"Dato non trovato nella lista\n\n";
                else cout<<"Dato trovato all'indirizzo: "<<pNODO<<endl<<endl;
            }
            break;
            case 6:{
                cout<<"\nInserire il nodo da eliminare: ";
                cin>>DATO;
                ELIMINANODO(DATO,&pLISTA);
                cout<<endl;
            }
            break;
            case 7:{
                DEALLOCAZIONE(pLISTA,pSP);
            }
        }
    }
    return 0;
}

PNODO GENERANODO(int DATO){
    PNODO pNODO;
    pNODO=new NODO;
    if(pNODO==NULL) abort();
    else{
        pNODO->INFO=DATO;
        pNODO->LINK=NULL;
    }
    return pNODO;
}

void INLISTA(PNODO pNODO,PNODO *pLISTA){
    PNODO pAPP;
    if(*pLISTA==NULL) *pLISTA=pNODO;
    else{
        pAPP=*pLISTA;
        while(pAPP->LINK!=NULL){
            pAPP=(PNODO)pAPP->LINK;
        }
        pAPP->LINK=(int*)pNODO;
    }
    return;
}

void PUSH(int DATO,PNODO *pSP){
      PNODO pNODO;
      pNODO=GENERANODO(DATO);
      pNODO->LINK=(int*)(*pSP);
      *pSP=pNODO;
      return;
}

void POP(int &DATO,PNODO *pSP,BOOLEAN &EMPTY){
      PNODO pAPP;
      if(*pSP==NULL){
            EMPTY=TRUE;
      }
      else{
            DATO=(int)(*pSP)->INFO;
            pAPP=*pSP;
            *pSP=(PNODO)(*pSP)->LINK;
            delete pAPP;
      }
      return;
}

void VISUALIZZA(PNODO pLISTA){
    PNODO pAPP;
    if(pLISTA==NULL){
        cout<<"\nLista vuota\n";
    }
    else{
        cout<<endl;
        pAPP=pLISTA;
        while(pAPP!=NULL){
            cout<<pAPP->INFO<<"\n";
            pAPP=(PNODO)pAPP->LINK;
        }
    }
    return;
}

void VISUALIZZAS(PNODO pSP){
    PNODO pAPP;
    if(pSP==NULL){
        cout<<"\nStack vuoto\n";
    }
    else{
        cout<<endl;
        pAPP=pSP;
        while(pAPP!=NULL){
            cout<<pAPP->INFO<<"\n";
            pAPP=(PNODO)pAPP->LINK;
        }
    }
    return;
}

void RICERCA(int DATO,PNODO pLISTA,PNODO *pPREC,PNODO *pNODO){
    PNODO pAPP;
    BOOLEAN TROVATO=FALSE;
    *pPREC=NULL;
    *pNODO=NULL;
    pAPP=pLISTA;
    while(pAPP!=NULL&&(*pNODO)==NULL){
        if(DATO==pAPP->INFO){
            *pNODO=pAPP;
            TROVATO=TRUE;
        }
        if(TROVATO==FALSE) *pPREC=pAPP;
        pAPP=(PNODO)pAPP->LINK;
    }
    return;
}

void DEALLOCAZIONE(PNODO pLISTA,PNODO pSP){
    PNODO pAPP;
    PNODO pNODO;
    pAPP=pLISTA;
    pNODO=pLISTA;
    while(pAPP!=NULL){
        pAPP=(PNODO)pAPP->LINK;
        delete pNODO;
        pNODO=pAPP;
    }
    pAPP=pSP;
    pNODO=pSP;
    while(pAPP!=NULL){
        pAPP=(PNODO)pAPP->LINK;
        delete pNODO;
        pNODO=pAPP;
    }
    return;
}

void ELIMINANODO(int DATO,PNODO *pLISTA){
    PNODO pNODO,pPREC;
    RICERCA(DATO,*pLISTA,&pPREC,&pNODO);
    if(pNODO!=NULL){
        if(pNODO==*pLISTA){
            *pLISTA=(PNODO)pNODO->LINK;
            delete pNODO;
        }
        else{
            pPREC->LINK=pNODO->LINK;
            delete pNODO;
        }
    }
    else cout<<"Nodo non trovato\n";
    return;
}
