package fiuba.algo3.algomon.test;

public enum Elemento {
    POCION(4){
           public Item nuevo(){
               return new Pocion();
           }
    };
    
    int cantidadInicialDeElemento;
    Elemento (int cantidad){
       this.cantidadInicialDeElemento = cantidad ;
    };
    public Item nuevo(){
       return new Pocion();
    };
    
}
