package com.bridgelabz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Purpose - To read from InventoryDetails.json and find total price
 * @author SUDIP PANJA
 * @version 11.0.11
 * @since 2021-08-22
 */
public class InventoryDataManagement {

    public static void main(String[] args) throws IOException, ParseException {
        InventoryDataManagement dataManagement = new InventoryDataManagement();
        dataManagement.InventoryManager();
    }

    /**
     * Purpose: Method to read Inventory.json file and find the total price
     * Providing read-only access to JSON data.
     * Reading the external JSON file
     * Creating main object to store JSONParser, JSONObject and JSONArray
     * Parsing object to JSONObject from InventoryDetails.json file
     * @throws IOException error
     * @throws ParseException error
     */
    public void InventoryManager() throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader("resource/InventoryDetails.json"));

        JSONObject inventoryObj = (JSONObject) obj;


        JSONArray riceArray = (JSONArray) inventoryObj.get("Rice");
        JSONArray wheatArray = (JSONArray) inventoryObj.get("Wheat");
        JSONArray pulseArray = (JSONArray) inventoryObj.get("Pulses");

        /* Getting Rice details */
        System.out.println("Details of Rice are : ");
        for (Object item1 : riceArray) {
            JSONObject riceDetails = (JSONObject) item1;
            //System.out.println(riceDetails);
            String name = (String) riceDetails.get("name");
            Double weight1 = (Double) riceDetails.get("weight");
            Double price1 = (Double) riceDetails.get("price");

            System.out.print("\nName : " + name);
            System.out.print("\nWeight : " + weight1 + " kg");
            System.out.print("\nPrice per kg. : " + price1 + " Rs.");

            double ricePrice = weight1 * price1;
            System.out.println("\nTotal Price of " + riceDetails.get("name") + " is : " + ricePrice + " Rs.");
        }

        /* Getting Wheat details */
        System.out.println("\nDetails of Wheat are : ");
        for (Object item2 : wheatArray) {
            JSONObject wheatDetails = (JSONObject) item2;
            // System.out.println(wheatDetails);
            String name = (String) wheatDetails.get("name");
            Double weight2 = (Double) wheatDetails.get("weight");
            Double price2 = (Double) wheatDetails.get("price");

            System.out.print("\nName : " + name);
            System.out.print("\nWeight : " + weight2 + " kg");
            System.out.print("\nPrice per kg. : " + price2 + " Rs.");

            double wheatPrice = weight2 * price2;
            System.out.println("\nTotal Price of " + wheatDetails.get("name") + " is : " + wheatPrice + " Rs.");
        }

        /* Getting pulse details */
        System.out.println("\nDetails of Pulses are : ");
        for (Object item3 : pulseArray) {
            JSONObject pulseDetails = (JSONObject) item3;
            //System.out.println(pulseDetails);
            String name = (String) pulseDetails.get("name");
            Double weight3 = (Double) pulseDetails.get("weight");
            Double price3 = (Double) pulseDetails.get("price");

            System.out.print("\nName : " + name);
            System.out.print("\nWeight : " + weight3 + " kg");
            System.out.print("\nPrice per kg. : " + price3 + " Rs.");

            double pulsesPrice = weight3 * price3;
            System.out.println("\nTotal Price of " + pulseDetails.get("name") + " is : " + pulsesPrice + " Rs.");
        }
    }
}

