package fiuba.algo3.algomon.modelo;

public enum Elemento {
    POCION(4){
           public Item nuevo(){
               return new Pocion();
           }
    },
    SUPER_POCION(2){
        public Item nuevo(){
            return new SuperPocion();
        }
    }, RESTAURADOR(3){
        public Item nuevo(){
            return new Restaurador();
        }        
    };
 
    
    int cantidadInicialDeElemento;
    Elemento (int cantidad){
       this.cantidadInicialDeElemento = cantidad ;
    };
    public Item nuevo(){
       return new Pocion(); //tirar excepcion
    };
    
}