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

        post("/computeUnion", (req, res) -> {
            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList1.add(value);
            }


            String input2 = req.queryParams("input2");
            sc1 = new java.util.Scanner(input2);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList2.add(value);
            }


            String input3 = req.queryParams("input3");
            sc1 = new java.util.Scanner(input3);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList3 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList3.add(value);
            }


            String input4 = req.queryParams("input4");
            sc1 = new java.util.Scanner(input4);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList4 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList4.add(value);
            }
            ArrayList<Integer> result = App.arrayUnion(inputList1, inputList2, inputList3, inputList4);
            Map map1 = new HashMap();
            map1.put("result", result);
            return new ModelAndView(map1, "computeUnion.mustache");
        },new MustacheTemplateEngine());

        get("/computeUnion",
            (rq, rs) -> {
              Map map1 = new HashMap();
              map1.put("result", "not computed yet!");
              return new ModelAndView(map1, "computeUnion.mustache");
            },
            new MustacheTemplateEngine());












        post("/compute", (req, res) -> {
          System.out.println(req.queryParams("input1"));
          System.out.println(req.queryParams("input2"));
          String input1 = req.queryParams("input1");                   //String input1 =...
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);


          String input2 = req.queryParams("input2").replaceAll("\\s",""); // \s means whitespace
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


    public static ArrayList<Integer> arrayUnion(ArrayList<Integer>a, ArrayList<Integer>b, ArrayList<Integer>c, ArrayList<Integer>d){
        ArrayList<Integer> arrList = new ArrayList<Integer>();
   /*     for(int i = 0; i < a.length; i++){
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
    */
        for(int e : a)
            if(!arrList.contains(e))
                arrList.add(e);

        for(int e : b)
            if(!arrList.contains(e))
                arrList.add(e);
       
       for(int e : c)
            if(!arrList.contains(e))
                arrList.add(e);
       
       for(int e : d)
            if(!arrList.contains(e))
                arrList.add(e);
       
       





        return arrList;
    }


    public static boolean equals(int []a, int []b){
        for(int i = 0; i < a.length; i++)
            if(a[i] == b[i])
                return true;
        return false;
    }


}
















