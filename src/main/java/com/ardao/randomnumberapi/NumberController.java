package com.ardao.randomnumberapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Random;

@RestController
public class NumberController {
    
    @GetMapping("/data2d")
    @ResponseBody
    public int[][] datagenerator2(@RequestParam(name = "count" , required = true) int count,
    @RequestParam(name = "xmax" , required = true) int xmax,
    @RequestParam(name = "xmin" , required = true) int xmin,
    @RequestParam(name = "ymax" , required = true) int ymax,
    @RequestParam(name = "ymin" , required = true) int ymin) {

        Random rd = new Random(); 
        
        int[][] arr2 = new int[count][2];

        for (int i = 0 ; i < arr2.length ; i++) {
            for (int j=0 ; j < 2 ; j++){
                
                if(j == 0 ){
                    arr2[i][j] = rd.nextInt(xmax - xmin) + xmin;
                    
                }

                if(j == 1 ){
                    arr2[i][j] = rd.nextInt(ymax - ymin) + ymin;
                    
                }


            }
        }

        /* System.out.println(Arrays.deepToString(arr2)); */

        return arr2;
     }


    @GetMapping("/data1d")
    @ResponseBody
    public int[] datagenerator1(@RequestParam(name = "count" , required = true) int count,
    @RequestParam(name = "max" , required = true) int max,
    @RequestParam(name = "min" , required = true) int min) {

        Random rd = new Random(); 
        
        int[] arr = new int[count];

        for (int i = 0 ; i < arr.length ; i++) {
            
            arr[i] = rd.nextInt(max - min) + min;
        }

        /* System.out.println(Arrays.toString(arr)); */

        return arr;
     }

    @GetMapping("/data_single")
    @ResponseBody
    public int datagenerator_single(@RequestParam(name = "max" , required = true) int max,
                                    @RequestParam(name = "min" , required = true) int min) {

        Random rd = new Random(); 
        
        int number;
            
        number = rd.nextInt(max - min) + min;
        
        /* System.out.println(number); */

        return number;
     }
}
