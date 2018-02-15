package com.mycompany.app;


import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


/**
 * Hello world!
 *
 */
public class App
{
    

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          System.out.println(req.queryParams("input1"));
          System.out.println(req.queryParams("input2"));
        String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);


          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);

          boolean result = App.search(inputList, input2AsInt);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }










    public static boolean search(ArrayList<Integer> array, int e) {
      System.out.println("inside search");
      if (array == null) return false;

      for (int elt : array) {
        if (elt == e) return true;
      }
      return false;
    }


    public static ArrayList<Integer> arrayUnion(int []a, int []b, int []c, int []d){
        int temp;
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for(int i = 0; i < a.length; i++){
            temp = a[i];
            if(!arrList.contains(temp))
                arrList.add(temp);
        }

        for(int i = 0; i < b.length; i++){
            temp = b[i];
            if(!arrList.contains(temp))
                arrList.add(temp);
        }

        for(int i = 0; i < c.length; i++){
            temp = c[i];
            if(!arrList.contains(temp))
                arrList.add(temp);
        }

        for(int i = 0; i < d.length; i++){
            temp = d[i];
            if(!arrList.contains(temp))
                arrList.add(temp);
        }
        return arrList;
    }


    public static boolean equals(int []a, int []b){
        for(int i = 0; i < a.length; i++)
            if(a[i] == b[i])
                return true;
        return false;
    }

    
}
















