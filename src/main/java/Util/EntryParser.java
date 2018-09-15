package Util;

import java.util.HashMap;
import java.util.Map;


public class EntryParser {

  public static Map<String, String> transformEntryToMap(String entry) {
    Map<String, String> map = new HashMap<String, String>();
    try {
      String[] tokens = entry.split("<====>");

      map.put("Id", tokens[1]);


      tokens[2] = tokens[2].replaceAll("[^A-Za-z0-9 ]", "").toLowerCase();

      map.put("Words", tokens[2]);
      }
      catch (StringIndexOutOfBoundsException e) {
      System.err.println(entry);
    }

    return map;
  }

}
