package fiuba.algo3.algomon.modelo;

public enum Elemento {
    POCION(4){
       public Item nuevo(){
           return new Pocion(this);
       }
    },
    SUPER_POCION(2){
        public Item nuevo(){
            return new SuperPocion(this);
        }
    }, 
    RESTAURADOR(3){
        public Item nuevo(){
            return new Restaurador(this);
        }        
    }, 
    VITAMINA(5){
        public Item nuevo(){
            return new Vitamina(this);
        }
    };
 
    
    int cantidadInicialDeElemento;
    Elemento (int cantidad){
       this.cantidadInicialDeElemento = cantidad ;
    };
    public Item nuevo(){
       return new Pocion(this); //tirar excepcion
    };
    
}
