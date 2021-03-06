# COVID Contact Tracing Questionnaire 

## SYSC 4806 Project  [![omarimran2000](https://circleci.com/gh/omarimran2000/COVID-Contact-Tracing.svg?style=shield)](https://app.circleci.com/pipelines/github/omarimran2000/COVID-Contact-Tracing)

https://covid-contact-tracing-4806.herokuapp.com/

### Group 7 L1

#### Group Members: Ben Baggs, Omar Imran, Braxton Martin, Erica Oliver, Wintana Yosief

## Project Description

Contact tracing personnel have to frequently call Contact Cases, i.e., people who were in contact with
someone known to have COVID, to find out whether they are experiencing symptoms and whether they
need any support while they are in quarantine. We want to relieve their work by providing a
questionnaire that the Contact Cases can fill out themselves. The Public Health Unit is responsible for
creating the case in the system, providing the name and phone number/email of the Contact Case, along
with private information (NOT to be made visible to the Contact Case!) such as the Case ID that the
Contact Case is related to, and the Exposure Date. The Contact Case will then receive a daily reminder
(by phone or email) to fill out a questionnaire, one per day for X days, asking questions such as: "since
yesterday's questionnaire, have you remained inside you residence?", "do you need any support to
adhere to self-isolation?", (if yes) "what type of support do you need? (food/groceries,
medications/prescriptions, pet care), "are you experiencing any symptoms? (cough, fever, runny nose)".

The system should then flag cases where the questionnaire was either not filled out or the Contact Case
declared having experienced symptoms (in which case a human will call the Contact Case) or the Contact
Case asked for support (in which case the appropriate support system is referred to).

## Milestone 1: Early Prototype

The application consists of a COVID form page for the Public Health Unit and a page for the COVID Questionnaire that 
each contact case must fill out. The Public Health Unit can use the COVID form page to create COVID cases, add contact 
cases using the New COVID-19 Contact Case Form, and find contact cases given its COVID Case ID. To add a new contact 
case into the system, the Public Health Unit must provide the name, email, phone number, exposure date, and the COVID 
Case ID that the contact case corresponds to. The Public Health Unit can also retrieve the contact cases that are 
missing any information, have symptoms, or require help based on the results of the Contact Case Questionnaire. The 
COVID Questionnaire requires each contact case to answer a series of questions such as "have you remained in your 
residence?", "do you need any support to adhere to self-isolation?", and "are you experiencing any symptoms?". If the 
contact case requires support, they may specify the type of support needed. 

## Milestone 2: Alpha Release

Public Health users must now sign in with a valid username and password to use the Contact Case Form. Contacts must 
provide their name and Case ID to access the daily questionnaire. Error messages are shown if any field of the Contact 
Case Form, or the questionnaire are empty, prompting the user to fill them in before creating the new contact case or 
submitting the questionnaire. The pages all have a unified header, showing the current page, and allowing navigation to 
the other pages. 


## Milestone 3: Final Product

This milestone finalized the styling of the pages, expanded some features, added more error tracking, and added a 
registration page for new Public Health users. A new feature for tracking Contact Cases that are not following 
quarantine was added, and the feature for covid cases needing assistance has been split by the type of assistance 
required (food, medical, or pet support). Contact Cases are only allowed to fill in the questionnaire once, and an error 
message is shown if they attempt to fill it in again. An error message is shown if a covid case with the specified case 
ID is not found when searching for cases on the contact form. 

## UML Class Diagram

![alt text](Diagrams/UML_Diagram.png?raw=true)

## ER Diagram
![alt text](Diagrams/ER_Diagram.png?raw=true)


