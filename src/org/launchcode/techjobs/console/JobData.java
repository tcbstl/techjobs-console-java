package org.launchcode.techjobs.console;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LaunchCode
 */
public class JobData {

    private static final String DATA_FILE = "resources/job_data.csv";
    private static Boolean isDataLoaded = false;

    private static ArrayList<HashMap<String, String>> allJobs;

    /**
     * Fetch list of all values from loaded data,
     * without duplicates, for a given column.
     *
     * @param field The column to retrieve values from
     * @return List of all of the values of the given field
     */
    public static ArrayList<String> findAll(String field) {

        // load data, if not already loaded
        loadData();

        ArrayList<String> values = new ArrayList<>();

        for (HashMap<String, String> row : allJobs) {
            String aValue = row.get(field);

            if (!values.contains(aValue)) {
                values.add(aValue);
            }
        }

        return values;
    }

    public static ArrayList<HashMap<String, String>> findAll() {

        // load data, if not already loaded
        loadData();

        return allJobs;
    }

    /**
     * Returns results of search the jobs data by key/value, using
     * inclusion of the search term.
     * <p>
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column Column that should be searched.
     * @param value  Value of the field to search for
     * @return List of all jobs matching the criteria
     */
    public static ArrayList<HashMap<String, String>> findByColumnAndValue(String column, String value) {

        // load data, if not already loaded
        loadData();

        ArrayList<HashMap<String, String>> jobs = new ArrayList<>();

        for (HashMap<String, String> row : allJobs) {

            String aValue = row.get(column);

            if (aValue.toLowerCase().contains(value.toLowerCase())) {
                jobs.add(row);
            }
        }

        return jobs;
    }

    /**
     * Read in data from a CSV file and store it in a list
     */
    private static void loadData() {

        // Only load data once
        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            Reader in = new FileReader(DATA_FILE);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            allJobs = new ArrayList<>();

            // Put the records into a more friendly format
            for (CSVRecord record : records) {
                HashMap<String, String> newJob = new HashMap<>();

                for (String headerLabel : headers) {
                    newJob.put(headerLabel, record.get(headerLabel));
                }

                allJobs.add(newJob);
            }

            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load job data");
            e.printStackTrace();
        }
    }
    //CREATE NEW PUBLIC STATIC METHOD THAT SEARCHES FOR A STRING IN EACH COLUMN
    //NAME IT FIND BY VALUE - USE LOOPS AGAIN - LOOP THROUGH COLUMNS, LOOP THROUGH ROWS
//    public static void findByValue


    public static ArrayList<HashMap<String, String>> findByValue(String value) {
        // load data, if not already loaded
        loadData();
        ArrayList<HashMap<String, String>> jobs = new ArrayList<>();

        for (HashMap<String, String> row : allJobs) {

            for (String job : row.keySet()) {         //or use allJobs instead of jobs
                String aValue = row.get(job);

                if (aValue.toLowerCase().contains(value.toLowerCase())) {
                    jobs.add(row);
                    break;
                }
            }
        }
        return jobs;
    }
}





























//    public static ArrayList<HashMap<String, String>> findByValue(String value) {
//// load data, if not already loaded
//        loadData();
//        ArrayList<HashMap<String, String>> jobs = new ArrayList<>();
//
//        for (HashMap<String, String> row : allJobs) {
//            if (row.containsValue(value)) {
//                jobs.add(row);
//            }
//
//
////            if (row.entrySet()) {
////                jobs.add(row);
////            }
////            if (allJobs.contains(value)) {
////                jobs.add(row);
////            }
//        }
////            String aValue = row.get(allJobs(int i));
////            if (aValue.contains(value)){
////                System.out.println("Tommy is Awesome");
////            }
////            System.out.println(value);
////            if (allJobs.(0)(0){
////                System.out.println("seriously!?");
////            }
////            if (row.containsKey("name")){
////            String aValue = row.get(column);
////            if (aValue.contains(value)) {
////                System.out.println("OHhhhhhhhhhhh");
////                System.out.println()
////                System.out.println(row.containsValue("Saint Louis"));
////                if (row.containsValue("Saint Louis")){
//
////                    if (row.containsValue(value)|| row.containsKey(value)) {
////                        jobs.add(row);
////                    }
//
//
////            for (int i = 0; i < 5; i++) {
////                String x = (String) Array.get(jobs, i);
////                System.out.println(x);
////            }
////                    System.
////                };
////                System.out.println(row);
////                System.out.println(1.)
////                jobs.add(row);
////            }
////                    if (row.containsKey(value)){
////                        jobs.add(row);
////                    }
////        }
//
////        for (every column in the array)
////            search it, add to a list
////                return it
////
////        for (every row in the array)
////            search it, add it to a list
////                return it
//
//        return jobs;
//    }
//
//        load data, if not already loaded
//        loadData();
//        ArrayList<HashMap<String, String>> jobs = new ArrayList<>();
//        for (HashMap<String, String> row : allJobs) {
//            String aValue = row.get(column);
//            if (aValue.contains(value)) {
//                jobs.add(row);
//            }
//        }
//        return jobs;
//    }
//}
