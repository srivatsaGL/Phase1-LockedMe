package com.simplilearn.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import com.simplilearn.user.UserCredential;
import com.simplilearn.user.UserRegistration;

public class LockedMe {

            private static Scanner keyboard, keyboard1, keyboard2;
            private static UserCredential userCredential;
            private static UserRegistration userRegistration;
            private static PrintWriter output, output1;
            private static String userlogin;

            public static void main(String[] args) {

                                    initialize();
                                    welcomePage();
            }

            /**
            * To display the banner for LockedMe application user
            */
            static void welcomePage()  {
                        System.out.println("=========================================");
                        System.out.println("");
                        System.out.println("      ** Welcome to LockedMe Registration Page**         ");
                        System.out.println();
                        System.out.println("=========================================");
                        signInOption();
            }

            /**
            * To allow the user to make the selection for Login or Registration
            */

            public static void signInOption()  {
                        System.out.println("1. Registration");
                        System.out.println("2. Login");
            //        keyboard = new Scanner(System.in);
                        String selection = keyboard.next();
                        switch (selection) {
                        case "1":
                                    registration();
                                    break;
                        case "2":
                                    login();
                                    break;
                        default:
                                    System.out.println("Please select either option 1 or 2");
                                    signInOption();
                                    break;
                        }
            }

            /**
            * Take the user input and validate the user and store the result in the
            * text file
            */
            public static void registration()  {
                        System.out.print("Enter the username");
                        String username = keyboard.next();
                        boolean found = false;
                        try {
                                    keyboard1 = new Scanner(new File("userLogin.txt"));
                        } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                        }
                        while (keyboard1.hasNext() && !found) {
                                    String storedString = keyboard1.next();
                                    String storedUsername[] = storedString.split(":");
                                    if (storedUsername[0].equals(username)) {
                                                System.out.println("User already exists. Please select another user for registration");
                                                found = true;
                                                signInOption();
                                                break;
                                    }
                        }
                        if (!found) {
                                    userRegistration.setUsername(username);
                                    System.out.println("Enter the password");
                                    String password = keyboard.next();
                                    userRegistration.setPassword(password);
                                    output.println(userRegistration.getUsername() + ":" + userRegistration.getPassword());
                                    output.close();
                                    System.out.println("Regsitration is successfull");
                        }
            }

            /**
            * Take the user input and validate the credential stored in the text file
            * and login on successful validation
            */
            public static void login()  {
                        System.out.println("Enter the username");
                        String username = keyboard.next();
                        boolean found = false;
                        try {
                                    keyboard1 = new Scanner(new File("userLogin.txt"));
                        } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                        }
                        while (keyboard1.hasNext() && !found) {
                                    String storedString = keyboard1.next();
                                    String storedUsername[] = storedString.split(":");
                                    if (storedUsername[0].equals(username)) {
                                                System.out.println("Enter the password");
                                                String password = keyboard.next();
                                                if (storedUsername[1].equals(password)) {
                                                            System.out.println("User Login is successful");
                                                            userlogin = storedUsername[0];
                                                            userDetails();
                                                            found = true;
                                                            break;
                                                }

                                    }
                        }
                        if (!found) {
                                    System.out.println("Invalid credential. Either username or password is incorrect");
                                    signInOption();
                        }
            }

            /**
            * User input to allow the selection for social media details
            */
            public static void userDetails()  {
                        System.out.println("1. Enter social media details");
                        System.out.println("2. Retrive social media details");
            //        keyboard = new Scanner(System.in);
                        String selection = keyboard.next();
                        switch (selection) {
                        case "1":
                                    enterUserCredential();
                                    break;
                        case "2":
                                    retriveUserDetails();
                                    break;
                        default:
                                    System.out.println("Please select either option 1 or 2");
                                    userDetails();
                                    break;
                        }
            }

            /**
            * Enter the social media details and save it in the text file
            */
            public static void enterUserCredential() {
                        System.out.println("Enter the social media name");
                        String sitename = keyboard.next();
                        userCredential.setSiteName(sitename);
                        if (validateDuplicateUserCredential(sitename)) {
                                    System.out.println("Enter the " + sitename + " username");
                                    String username = keyboard.next();
                                    userCredential.setUsername(username);
                                    System.out.println("Enter the " + sitename + " password");
                                    String password = keyboard.next();
                                    userCredential.setPassword(password);
                                    output1.println(userlogin + ":" + userCredential.getSiteName() + ":"
                                                            + userCredential.getUsername() + ":" + userCredential.getPassword());
                                    output1.close();
                                    System.out.println("Details saved successfully press F11 to continue");
                        }
            }

            /**
            * Validate the duplicate social media credential in the text file
            * 
             * @param sitename
            *            - social media name for which the details has to be validated
            * @return true if the social media name does not exists in the text file
            */
            public static boolean validateDuplicateUserCredential(String sitename) {
                        try {
                                    keyboard2 = new Scanner(new File("userCredential.txt"));
                        } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                        }
                        while (keyboard2.hasNext()) {
                                    String storedUserCredential = keyboard2.next();
                                    String username[] = storedUserCredential.split(":");
                                    if (username[0].equals(userlogin) && username[1].equals(sitename)) {
                                                System.out.println("The site name already exists. Please try another site");
                                                return false;
                                    }
                        }
                        return true;
            }

            /**
            * To retrieve the user details based on the social media name provided
            */
            public static void retriveUserDetails() {
                        System.out.println("Enter the site name to be retrived");
                        String sitename = keyboard.next();
                        boolean found = false;
                        try {
                                    keyboard2 = new Scanner(new File("userCredential.txt"));
                        } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                        }
                        while (keyboard2.hasNext() && !found) {
                                    String storedUserCredential = keyboard2.next();
                                    String username[] = storedUserCredential.split(":");
                                    if (username[0].equals(userlogin) && username[1].equals(sitename)) {
                                                String siteusername = username[2];
                                                String sitepassword = username[3];
                                                System.out.println("The " + sitename + " username is: " + siteusername);
                                                System.out.println("The " + sitename + " password is: " + sitepassword);
                                                found = true;
                                                break;
                                    }
                        }
                        if (!found) {
                                    System.out.println("The information is not stored for " + sitename + ". Please enter the details");
                        }
            }

            /**
            * To create the text file to store the LockedMe credential and SocialMedia
            * credential and initialize the PrintWriter
            */
            static void initialize() {
                        File userReg = new File("userLogin.txt");
                        File userCred = new File("userCredential.txt");

                        try {
                                    output = new PrintWriter(new FileWriter(userReg, true));
                                    output1 = new PrintWriter(new FileWriter(userCred, true));
                                    keyboard = new Scanner(System.in);
                        } catch (IOException e) {
                                    e.printStackTrace();
                        }
                        userRegistration = new UserRegistration();
                        userCredential = new UserCredential();
            }
}
