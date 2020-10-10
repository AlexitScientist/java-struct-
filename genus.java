
public class genus {
   
    public base app;        //lvl up position  
    public base down;       //lvl down position

    public base it;      //type asoc;
   
    Integer large; //type : 1-(next/beck) 2 - app/down 3 - s1/s0

    Boolean vects; // type row
    Boolean vect; //  type column
    Boolean again; // column or row//
   
    public genus(){

    }

    public genus(base data){
     it = data;
    }

// create column
  public void set_asoc(base datas , Boolean types){
        it.set_asoc( datas ,  types);
        datas.set_asoc( it ,  !types);
  }

  public base get_asoc(Boolean types){
    if (types){
        return app;
     }else{
        return down ;
    }
}

  public void add_column(ate neibor ,Boolean types){
    base intor = new base(neibor);
    if(it.get_asoc(types) == null){
        set_asoc(intor ,types);
    }else{
      genus neibor2 = new genus (it.get_asoc(types));
      it.set_asoc(intor,types);
      neibor2.set_asoc(intor ,!types);
    }
  }

  //1 data    // row/column    //upper/downer
  // add  
    public void add( ate datas , Boolean types , Boolean subtype){
        // this not have base
    if (it == null ){
        it = new base(datas);
        //this have base
    }else{
        if ( types ){ // add app or down
            add_column(datas , subtype);
         
        }else{
            // add value to (beck next)
            it.add_row(datas , subtype);

        }
      }
    }
    
    public void options( Boolean typ ,Boolean types, Boolean subtype){
        vects = types; // type row
        vect = subtype;//  type column
        again = typ;
    }


    public void add( ate datas ){
        if (again){
            add( datas , again , vects);
        }else{
            add( datas , again , vect);
        }
    }


    public ate get_asoc(){
      return it.it;
    }


    public void Print(){
        ate valopt = it.it.go_to(false);
        while(true){
        if (valopt.next == null){
            return;
        }else{

            java.lang.System.out.println(valopt.value);
        }
    }

    }
    

}
