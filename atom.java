
public class atom {

    // low lvl type data  TEMPLATE < T , T1>

    public char value;          // data          (data)

    public atom s1;            // lvl down 1 area data        (T1)
    public atom s0;            // lvl down 2 area data        (T1)
                                //type
    public atom beck;          // ( -> )                (T)
    public atom next;          // ( <- )                (T)

    public atom app;           // (up)                    (T)
    public atom down;           // (down)                  (T)

    
    Boolean []type_d = {false,false}; //type dats

    public atom(){
    value = 0;
    beck  = null;
    next  = null;
    app   = null;
    s1    = null;
    down   = null;
    s0    = null;
    }

    public atom(char i){
      this();
    value = i;

    }
    //atom to atom;
    public void set_asoc(atom data , Integer type , Boolean subtype){
        if (subtype){
        switch (type) {
            case 1:
                this.app = data;
                break;
            case 2:
                this.next = data;               
                break;
            case 3:
                this.s1 = data;
                break;
            default:
                break;
        }

        }else{
            switch (type) {
                case 1:
                this.down = data; 
                    break;
                case 2:
                this.beck = data;   
                    break;
                case 3:
                this.s0  = data;    
                    break;
                default:
                    break;
            }

        }

    }

    public atom get_asoc(int type , Boolean subtype){
        if (subtype){

        if (type == 1){
                return this.app; 
        }
        if (type == 2){
                return this.next; 
                }                      
        if (type == 3){
                return this.s1 ;
                }
                return null;
        }else{

            if (type == 1){
                return this.down; 
            }
            if (type == 2){
                return this.beck; 
            }  
            if (type == 3){
                return this.s0 ;    
            }
                return null;
            }
    }

    // Create copy this atom.
    public atom copy(){
    
    atom adeds = new atom (this.value);
    adeds.next = this.next;
    adeds.beck = this.beck;
    adeds.app = this.app;
    adeds.down = this.down;
    adeds.s1 = this.s1;
    adeds.s0 = this.s0;

    return adeds;  
    }
    


    //apper qwester

    // find pos area----------------------- find /2/ line pos atom==atom
    public atom f_area_pos( atom arg ) {
        if ((next.value == arg.next.value) && (beck.value == arg.beck.value)){
            return  arg;
        }
    
        if ( f_area_app( arg ) != null ){
            return f_area_app( arg);
        }

        if ( f_area_dow( arg ) != null ){
            return f_area_dow( arg);
         }
            return null;
            
    }

    //app find (chenge pos type)
    public atom f_area_app(atom arg) {
        
        if ((next.value == arg.next.value) && (beck.value == arg.beck.value)){
            return arg;
        }
        if (app != null){
            return f_area_app(arg.app);
        } 
        return null;
    }

    //dow find
    public atom f_area_dow(atom arg) {   
            if ((next.value == arg.next.value) && (beck.value == arg.beck.value)){
                return arg;
            }
            if ( down != null){
                return f_area_dow(arg.down);
            }
            return null; 
    }


// if i'm use interface i can find type arg from his name;
//eqwals aded ???


    //-----find poiter  value in beck line;
    public atom find_beck( int values ){
        if ( beck.value ==  values){
            return beck;
        }

        if (beck.beck == null){
            return null;  
        }

            return beck.find_beck( values );
        
      
    }

    //-----find poiter  value in beck line; 
    public atom find_next(int values){
        if ( next.value !=  values){
            return next;
        }

        if (next.next == null){
            return null;
        }
            return next.find_next( values );
            
     

    }

 //-----find poiter  value in  line;
    public atom find(char  values){
        if ( value == values){
            return this;
        }

        if (find_beck( values) != null){
            return find_beck(values);
        }

        if (find_next( values) != null){
            return find_next(values);
        }
        
        return null;
        
    }
    
    public void del( Integer type , Boolean subtype){
        if (subtype){
        switch (type) {
            case 1:
                this.app = null;
                break;
            case 2:
                this.next = null;               
                break;
            case 3:
                this.s1 = null;
                break;
            default:
                break;
        }

        }else{
            switch (type) {
                case 1:
                this.down = null; 
                    break;
                case 2:
                this.beck = null;   
                    break;
                case 3:
                this.s0  = null;    
                    break;
                default:
                    break;
            }

        }

    }


}

