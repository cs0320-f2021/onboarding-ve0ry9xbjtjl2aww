package edu.brown.cs.student.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stars {
  private List<List<String>> strList = new ArrayList<>();

  public void csvReader(String filename) throws FileNotFoundException {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      List<List<String>> workingList = new ArrayList<>();
      while ((line = br.readLine()) != null) {
        String[] headers = line.split(",");
        if (headers.length == 5) {
//          if (headers[0].equals("StarID") && headers[1].equals("ProperName")
//                && headers[2].equals("X") && headers[3].equals("Y") && headers[4].equals("Z")) {
          workingList.add(Arrays.asList(headers));
        } else {
          throw new FileNotFoundException("File does not conform with format");
        }
        this.strList = workingList;
        System.out.println(workingList);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}