import java.io.*;
import java.util.*;
import java.lang.System.*;


class cube{
    public static String reakt ="";
    public static java.util.ArrayList<String> Command ;
    public static Scanner in ;
    public static Gen maps;
    atom values;

public static void main( String[] args){
  System.out.println("enter comand");
    in = new Scanner(System.in);
    reakt = in.nextLine();

    maps = new Gen();
    Gen capsi = new Gen();
    Integer sizeee = reakt.length();
    char[] chareAt = new char[sizeee];
    for (int i = 0 ; i < sizeee ; i++) {
        chareAt[i]= reakt.charAt(i);
        maps.add(reakt.charAt(i),2,true);
        capsi.add(reakt.charAt(i),1,true);
      }
    
    for(char data: chareAt){
      System.out.println(""+data);
    }
  
    maps.add('a', 2 , true);
    //maps.printe();
    //maps.verificate(2);
    maps.add('b', 2 , true);
    //maps.printe();
    maps.add('c', 2 , true);
    maps.beck(2 , false) ;
    System.out.println("finaly");
    maps.printe();
    maps.chenge(2 , true);
    maps.chenge(2 , true);
    maps.chenge(2 , true);
    System.out.println("start");
    maps.printe();
    maps.add('E', 2 , true);
    maps.chenge(2 , false);
    maps.printe();
    maps.chenge(2 , false);
    maps.add('A', 2 , false);

    maps.printe();
    maps.del( 2, false);

    atom td = new atom('B'); //eror

    maps.add( td, 2 ,  true);
    maps.printe();

    maps.chenge(2 ,false);
    maps.printe();

    maps.printe();
    maps.beck(2 , false) ;
    maps.beck(2 , true) ;
// Part 2 
    ate four = new ate( 'C');
    base roof = new base(four);

 System.out.println( roof.it.value);
 System.out.println("enter comand");
    in = new Scanner(System.in);
    reakt = in.nextLine();
 Integer sizee = reakt.length();    
 for (int i = 0 ; i < sizee ; i++) {
  four = null;
  four = new ate( reakt.charAt(i));
  roof.add_row( four , true);
  roof.print();
 }

 for (int i = 0; i < sizee; i++) {
   
 roof.print();
 roof.step(false);

 }

roof.step(true);

} 



