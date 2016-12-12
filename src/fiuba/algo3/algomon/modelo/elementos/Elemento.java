package fiuba.algo3.algomon.modelo.elementos;

public enum Elemento {
    POCION("Pocion",4){
       public Item nuevo(){
           return new Pocion(this);
       }
    },
    SUPER_POCION("Super pocion", 2){
        public Item nuevo(){
            return new SuperPocion(this);
        }
    }, 
    RESTAURADOR("Restaurador", 3){
        public Item nuevo(){
            return new Restaurador(this);
        }        
    }, 
    VITAMINA("Vitamina", 5){
        public Item nuevo(){
            return new Vitamina(this);
        }
    };
 
	String nombre;
    int cantidadInicialDeElemento;
 
    
    Elemento (String nombre, int cantidad){
    	this.nombre = nombre;
    	this.cantidadInicialDeElemento = cantidad ;
    };
    
    public Item nuevo(){
       return new Pocion(this); //tirar excepcion
    };
    
    public String getNombre(){
    	return this.nombre;
    }
    
}
