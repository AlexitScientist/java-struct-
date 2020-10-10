
public class ate  {
    public char value ;          // data          (data)
    public ate next;            // <>
    public ate beck; 

    public ate(){

    }
    
    public ate(char val){
        this.value = val;
    }

    public void del( Boolean types){
        if (types){
            this.next = null;
         }else{
            this.beck = null;
        }
    }


    public void set_asoc(ate datas , Boolean types){
        if (types){
            this.next = datas;
         }else{
            this.beck = datas;
        }
    }

    public ate get_asoc(Boolean types){
        if (types){
            return next;
         }else{
            return beck ;
        }
    }
    public char val(){
        return value; 
    } 

    public ate go_to(Boolean types){
        if(get_asoc(types).get_asoc(types) == null){
        if (types){
            return next;
         }else{
            return beck ;
        }
        }else{

          return  get_asoc(types).go_to(types);
        }
    }
  


    }
