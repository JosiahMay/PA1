package Util;

import java.util.StringTokenizer;

public class Test {

  public static void main(String[] args){

    String line = "Anna Cappellini<====>7976751<====>Anna Cappellini Anna Cappellini (born 19 February 1987) is an Italian ice dancer.  With partner Luca Lanotte, she is the 2014 World champion, the 2014 European champion, the 2015 Cup of China champion and a thirteen-time medalist on the Grand Prix series, and a six-time Italian national champion (2012–17). Personal lifeCappellini was born 19 February 1987 in Como, Italy.   She is a member of the Polizia Penitenziaria's sports group, the Fiamme Azzurre.   She has expressed interest in studying physiotherapy after her skating career is over.  In August 2014, it was announced that she was engaged to pair skater Ondřej Hotárek. ";
    String line2 = "Amrita (novel)<====>7976867<====>Amrita (novel) Amrita （アムリタ) is a novel written by Japanese author Banana Yoshimoto (吉本ばなな）in 1994 and translated into English in 1997 by Russell F. Wasden.Plot synopsisThe main character, Sakumi, loses her beautiful younger sister, an actress, to suicide. Sakumi subsequently falls down a flight of stairs, losing her memory. She struggles to regain her memory with the assistance of her sister's lover and a clairvoyant kid brother.Awards5th Murasaki-shikibu Prize – November, 1995 Banana Yoshimoto - profile Scanno (Italy) – June, 1993 Fendissime (Italy) – March, 1996 Maschera d' argento (Italy)– November, 1999 Book informationAmrita (English edition) by Banana YoshimotoHardcover -   published by Grove Press, 1997Paperback -  , published by Washington Square Press, 1998References  ";


    StringTokenizer token = new StringTokenizer(line2.toString().split("<====>")[2]);
    while (token.hasMoreTokens()) {
      String word = token.nextToken().replaceAll("[^A-Za-z0-9]", "").toLowerCase();
      //String out = line2.replaceAll("[^A-Za-z0-9 ]", "").toLowerCase();//("^[a-zA-Z0-9]*$", "");
      if(!word.isEmpty())
        System.out.println(word);

    }
  }

}
