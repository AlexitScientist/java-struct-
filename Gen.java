public class Gen {
    // LOV DATE SERVICE

    public atom beck;       //beck position     ( -> )
    public atom next;       //next position     ( <- )

    public atom it;         //this position     (values contain)

    public atom app;        //lvl up position    ( A )
    public atom down;       //lvl down position  ( V )

    public atom s1;            
    public atom s0; 

    Integer type; //1-(next/beck) 2 - app/down 3 - s1/s0
    Boolean vect;

// ----- constract data (ziro data)
   public Gen(){
    // 1-elem;
    System.out.println( "born spider");
    it = null;
    this.next = null;
    this.beck = null;
    this.app  = null;
    this.down = null;
    this.next = null;
    this.beck = null;
}
// values data
public Gen(char i){
    this();
    it = new atom(i);

}
// pointer type (inheretensy type)
public Gen(atom point){
    it = point;
    this.next = point.next;
    this.beck = point.beck ;
    this.app  = point.app;
    this.down = point.down;
    this.s1 = point.s1;
    this.s0 = point.s0;
}

public void cler( Integer type , Boolean subtype){
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
// set data
    public void set_asoc(atom data , int type , Boolean subtype){
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
    //get data
    public atom get_asoc( int type , Boolean subtype){
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

    //sapper end walk
    public void chenge (atom sapper ){
        it = sapper;
        int types = 3;
        while(types != 0){
        set_asoc(it.get_asoc(types, true), types, true);
        set_asoc(it.get_asoc(types, false), types, false);
        --types;
        }
    }

    // go to end list
    public void beck(int types , Boolean pos) {
        while(it.get_asoc(types, pos) != null){
            printe();
        chenge(it.get_asoc(types, pos));
        }
    }

    // walk to list 
    public void chenge(int types , Boolean pos){
        if(it.get_asoc(types, pos) != null){

        atom again = it.get_asoc(types, pos);

        it = again;
        if (it.get_asoc(types, true) != null){
            set_asoc(it.get_asoc(types, true), types, true);
            }else{
                cler(types, true);
            }

        if (it.get_asoc(types, false) != null){
            set_asoc(it.get_asoc(types, false), types, false);
            }else{
                cler(types, false);
            }
        }
    }

    // add point (awerything)=)
    public void add( char value , int pos , Boolean type){
    atom any = new atom(value);
        add( any ,  pos ,  type);
    }
  
    // meybe aper atom to =)
    public void add( atom point , int pos , Boolean type){
        if (it == null){ // if nothing
            it = point; 
         }else{     
            if(it.get_asoc(pos, type) == null){ // if aper box is empyty
             
                it.set_asoc(point , pos , type);
                point.set_asoc(it, pos , !type);
          
            }else{
                atom apender = it.get_asoc(pos, type); 
                    point.set_asoc(apender , pos , type); 
                    point.set_asoc(it , pos , !type);      
                    it.set_asoc(point , pos , type);
                    apender.set_asoc(point , pos , !type);       
            }  
            // applet chenges
                chenge(pos,type);
                printe();
           
         }
        }


   public Boolean eq( atom point ){ 
   if(it.value == point.value){
        return true;
   }else{
        return false;
        }
        }   
        
    // create parametr route.

    // direction / route 
    public void vector(int types){
        this.type = types;
    }
    // type route ( up OR down)
    public void type(Boolean pos){
        this.vect = pos;
    }
    // get parametr walk
    public void way(int types , Boolean pos){
    vector(types);
    type (pos);
    }


    public void printe(){
        if (   it != null){
            java.lang.System.out.println("it: " + it.value);
        }

        if ( this.next != null){
            java.lang.System.out.println("next: " + next.value);
        }

         if ( this.beck != null){
            java.lang.System.out.println("beck: " + beck.value);
        }

         if ( this.app  != null){
            java.lang.System.out.println("app: " + app.value);
        }

         if ( this.down != null){
            java.lang.System.out.println("down: " + down.value);
         }
    }

    public atom start(int pos , Boolean type){
        end:
        while(true){
        if (it.get_asoc(pos, type) == null ){
            printe();
            break end;
            
        }else{
            printe();
            it = get_asoc(pos, type);
            
        }
        }
        return it;
       
    }

//----------------construct datas pointer ------------

  //----------------Destruct datas pointer ------------
  // delete asociate vector
  public void del( int pos , Boolean type){

    if((it.get_asoc(pos,true) == null) && (it.get_asoc(pos,false) == null) ){
        return;
    }
    atom pointer ;

    if(it.get_asoc(pos,true) == null){

        pointer = it.get_asoc(pos,false);

        pointer.del( pos , true);
        it.del( pos , false);

        it = pointer;
        chenge(pos,!type);
        return;
    }

    if(it.get_asoc(pos,false) == null){

        pointer = it.get_asoc(pos,true);

        pointer.del( pos , false);
        it.del( pos , true);

        it = pointer;
        chenge(pos,!type);
        return;

    }
    pointer = it.get_asoc( pos,true ); //next
    atom nexte = it.get_asoc(pos,false); //beck
    
    pointer.set_asoc( nexte , pos , false);//next.beck = beck;
    nexte.set_asoc( pointer, pos , true);//beck.next = next

    it.del( pos , true);
    it.del( pos , false);

    if(type){
    this.it = pointer;// it = next;
        }else{
    this.it = nexte;       
        }

    chenge(pos,!type);

    return;

  }

}
