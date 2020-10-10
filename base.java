public class base {

    // low lvl type data  TEMPLATE < T , T1>
    public ate it;            // <> values
    
    public base app;        //lvl up position  
    public base down;       //lvl down position  
    //create base
    public base(ate pos){
      it = pos;
    }
    public base(){
    }

    //create lvl data
    public void set_asoc(base datas, Boolean types){
      if (types){
        this.app = datas;
     }else{
        this.down = datas;
    }
    }

    //get lvl data
    public base get_asoc(Boolean types){
      if (types){
          return app;
       }else{
          return down;
      }
    }

    //set beck or next.
    public void set_asoc(ate datas , Boolean types){
          it.set_asoc( datas ,  types);
          datas.set_asoc( it ,  !types);
    }

// add walue to row
    public void add_row(ate neibor ,Boolean types){
      if(it == null){
        it = neibor;
      }else{

        if(it.get_asoc(types) == null){
        set_asoc(neibor ,types);

        }else{
        base neibor2 = new base(it.get_asoc(types));
        set_asoc(neibor,types); //it.
        neibor2.set_asoc(neibor ,!types);
      }
      step(types);
    }
    }

    public void del_row(Boolean types){
      if(it.next == null && it.beck == null){
        it = null;
        return;
      }
      ate pointer;
      if(it.next == null){
        pointer = it.get_asoc(false);

        pointer.del(true);
        it.del(false);
        it = pointer;
        
        return;
      }

      if(it.beck == null){
        pointer = it.get_asoc(true);
        pointer.del(false);
        it.del(true);
        return;
      }

      pointer = it.get_asoc( true ); //next
      ate nexte = it.get_asoc(false); //beck

      pointer.set_asoc( nexte , false);//next.beck = beck;
      nexte.set_asoc( pointer, true);//beck.next = next

      it.del( true);
      it.del( false);

        if(types){
          this.it = pointer;// it = next;
        }else{
          this.it = nexte;       
        }
      return;
    }
    

    // printing values
    public void print(){
      if ( it != null){
        java.lang.System.out.println("it: " + it.value);

        if ( it.next != null){
          java.lang.System.out.println("next: " + it.next.value);
      }
  
       if ( it.beck != null){
          java.lang.System.out.println("beck: " + it.beck.value);
      }
    }else{
      java.lang.System.out.println("Empety ");
    }
    }


    // Copy value
      public ate copy(){
        ate copythis = new ate (it.value);
        return copythis;

     }

     public void step (boolean type){
       if(it.get_asoc(type) !=null){
       it = it.get_asoc(type);
       }
     }



/*
     public atom steps ( base any , Integer sizer, boolean type){
       if (sizer > 0 ){

       return it.get_asoc(type)
       
       }else {
        return it.get_asoc(type);
       }
      
    }
*/


     // Copy row
     public void copy (base thisLine, base copylinen , Boolean type ){
        thisLine.step(type);
        ate nextval = new ate (thisLine.it.get_asoc(type).value);
        copylinen.add_row(nextval,type);
        copylinen.step(type);

     }


// create copy  line .
      public ate copy( Integer sizer, Boolean type ){  

        ate copythis = new ate (it.value);

        base thisLine = new base(it);
        base copylinen = new base(copythis);

        Integer siz = sizer;

        while (siz != 0) {
          if (thisLine.get_asoc(type)== null ){
          break;
          }else{
          copy (thisLine,copylinen ,type);
          }
          siz--;
      }
        return copythis;

      }
}