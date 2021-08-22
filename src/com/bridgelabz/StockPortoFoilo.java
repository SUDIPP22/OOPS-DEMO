package com.bridgelabz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.IOException;

/**
 * Purpose - To read from StockDetails.json and find total share price
 * @author SUDIP PANJA
 * @version 11.0.11
 * @since 2021-08-22
 */

public class StockPortoFoilo {

    /**
     * Purpose: Method to read StockDetails.json file and find the total share price
     * Providing read-only access to JSON data.
     * Reading the external JSON file
     * Creating main object to store JSONParser, JSONObject and JSONArray
     * Parsing object to JSONObject from StockDetails.json file
     * @throws IOException throws error
     * @throws ParseException throws error
     */
    public void stock() throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader("stockResource/StockDetails.json"));

        JSONObject stockObj = (JSONObject) obj;
        JSONArray stockArray = (JSONArray) stockObj.get("Stock");
        System.out.println("Details of Stock are : ");
        for (Object stockValue : stockArray) {
            JSONObject stockDetails = (JSONObject) stockValue;

            String name = (String) stockDetails.get("stockName");
            Long numberOfShare = (Long) stockDetails.get("numberOfShare");
            Double sharePrice = (Double) stockDetails.get("sharePrice");

            System.out.print("\nShare Holder Name is : " + name);
            System.out.print("\nNumber of share is : " + numberOfShare);
            System.out.print("\nShare price is : " + sharePrice);

            double stockPrice = numberOfShare * sharePrice;
            System.out.println("\nTotal price of " + stockDetails.get("stockName") + " is : " + stockPrice + " Rs.");
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        StockPortoFoilo stockPortoFoilo = new StockPortoFoilo();
        stockPortoFoilo.stock();
    }
}
