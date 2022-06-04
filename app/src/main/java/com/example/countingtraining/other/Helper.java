package com.example.countingtraining.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Helper {

    public static Map<String, String> getExampleAdd(){
        HashMap<String, String> examples = new HashMap<>();
        examples.put("1+1","2");
        examples.put("2+2","4");
        examples.put("3+3","6");
        examples.put("4+4","8");
        examples.put("5+5","10");
        examples.put("6+6","12");
        examples.put("7+7","14");
        examples.put("8+8","16");
        examples.put("9+9","18");
        examples.put("10+10","20");
        examples.put("11+11","22");
        examples.put("12+12","24");
        examples.put("13+13","26");
        examples.put("14+14","28");
        examples.put ("15+15","30");
        return examples;
    }

    public static Map<String, String> getRandomExampleAdd(int size){
        HashMap<String, String> examplesMap = new HashMap<>();
        Map<String, String> originalExample = getExampleAdd();
        int originalSize = originalExample.size();
        ArrayList<String> keylist = new ArrayList<String>(originalExample.keySet());

        while (examplesMap.size() <= size){
            Random random = new Random();
            int randomNumber = random.nextInt();
            String example = keylist.get(randomNumber);
            if(!examplesMap.containsKey(example)){
                examplesMap.put(example, originalExample.get(example));
            }
        }

        return examplesMap;
    }

    public static Map<String, String> getExampleSub(){
        HashMap<String, String> examples = new HashMap<>();
        examples.put("1-1","0");
        examples.put("2-1","1");
        examples.put("5-3","2");
        examples.put("7-4","3");
        examples.put("9-5","4");
        examples.put("11-6","5");
        examples.put("13-7","6");
        examples.put("15-8","7");
        examples.put("17-9","8");
        examples.put("19-10","9");
        examples.put("21-11","10");
        examples.put("23-12","11");
        examples.put("25-13","12");
        examples.put("27-14","13");
        examples.put("29-15","14");
        return examples;
    }

    public static Map<String, String> getRandomExampleSub(int size){
        HashMap<String, String> examplesMap = new HashMap<>();
        Map<String, String> originalExample = getExampleSub();
        int originalSize = originalExample.size();
        ArrayList<String> keylist = new ArrayList<String>(originalExample.keySet());

        while (examplesMap.size() <= size){
            Random random = new Random();
            int randomNumber = random.nextInt();
            String example = keylist.get(randomNumber);
            if(!examplesMap.containsKey(example)){
                examplesMap.put(example, originalExample.get(example));
            }
        }
        return examplesMap;
    }

    public static Map<String, String> getExampleInc(){
        HashMap<String, String> examples = new HashMap<>();
        examples.put("1*1","1");
        examples.put("2*2","4");
        examples.put("5*3","15");
        examples.put("7*4","28");
        examples.put("9*5","45");
        examples.put("1*6","6");
        examples.put("7*6","42");
        examples.put("8*8","64");
        examples.put("8*9","72");
        examples.put("4*6","24");
        examples.put("10*10","100");
        examples.put("2*9","18");
        examples.put("7*8","56");
        examples.put("4*3","12");
        examples.put("128*1","128");
        return examples;
    }

    public static Map<String, String> getRandomExampleInc(int size){
        HashMap<String, String> examplesMap = new HashMap<>();
        Map<String, String> originalExample = getExampleInc();
        int originalSize = originalExample.size();
        ArrayList<String> keylist = new ArrayList<String>(originalExample.keySet());

        while (examplesMap.size() <= size){
            Random random = new Random();
            int randomNumber = random.nextInt();
            String example = keylist.get(randomNumber);
            if(!examplesMap.containsKey(example)){
                examplesMap.put(example, originalExample.get(example));
            }
        }
        return examplesMap;
    }

    public static Map<String, String> getExampleDiv(){
        HashMap<String, String> examples = new HashMap<>();
        examples.put("1/1","1");
        examples.put("2/2","1");
        examples.put("10/2","5");
        examples.put("20*4","5");
        examples.put("10/5","2");
        examples.put("6/1","6");
        examples.put("64/2","32");
        examples.put("7/7","1");
        examples.put("32/4","8");
        examples.put("12/4","3");
        examples.put("12/3","4");
        examples.put("15/3","5");
        examples.put("18/3","6");
        examples.put("81/9","9");
        examples.put("128/1","128");
        return examples;
    }

    public static Map<String, String> getRandomExampleDiv(int size){
        HashMap<String, String> examplesMap = new HashMap<>();
        Map<String, String> originalExample = getExampleDiv();
        int originalSize = originalExample.size();
        ArrayList<String> keylist = new ArrayList<String>(originalExample.keySet());

        while (examplesMap.size() <= size){
            Random random = new Random();
            int randomNumber = random.nextInt();
            String example = keylist.get(randomNumber);
            if(!examplesMap.containsKey(example)){
                examplesMap.put(example, originalExample.get(example));
            }
        }
        return examplesMap;
    }
}
