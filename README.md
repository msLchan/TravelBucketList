# My Personal Project

## Travel Bucket List Application

**What will the application do?**

This application is intended to assist users with creating and updating a list of destinations where they wish to travel. It will allow users to keep track of where they have travelled and where they want to go.

**Who will use it?**

Users may be from any walks of life, whether they are currently in school, working, or retired.

**Why is this project of interest to you?**

This project is of interest to me because I love travelling and would like to document and keep track of my journeys. 


## *User Stories* ##
- As a user, I want to be able to add a new location to my travel bucket list so that I can keep track of places I want to visit in the future
- As a user, I want to be able to view my travel bucket list so that I can see all the destinations I want to explore
- As a user, I want to be able to delete locations so that I can keep my list up to date with my current interests
- As a user, I want to be able to mark destinations as visited so that I can keep track of my travels
- As a user, I want to have to option to save my travel bucket list to file
- As a user, I want to be able to load my travel bucket list from file amd resume where I left off previously

## Instructions for End User ##
**You can generate the first required action related to the user story "adding multiple Xs to a Y" by...**
1. Open the application and wait for the splash screen to disappear
2. Click the **"Add Destination"** button in the main GUI
3. A dialog box will appear prompting you to **enter the name of a destination you want to visit**
4. Type in the name of the destination you want to add and **click OK**
5. The destination will appear in the list of destinations on the screen, marked as **"(Not Visited)"**

**You can generate the second required action related to the user story "adding multiple Xs to a Y" by...**
1. Select a destination from the list by clicking on it
2. Click the **"Mark as Visited"** button
3. The selected destination's status will update to **"(Visited)"** in the list
4. Repeat for multiple destinations as needed

**You can remove a destination by...**
1. Select a destination from the list by clicking on it
2. Click the **"Remove Destination"** button
3. A confirmation message will appear, and the selected destination will be removed from the list
4. If no destination is selected, an error message will prompt you to select one before trying again

**You can show all destinations after filtering by...**
1. Click the **Show All Destinations" button
2. The full list of destinations, including both visited and not visited, will reappear in the list

**You can locate my visual component by...**
1. When starting the application, wait for the **splash screen** to appear
2. The splash screen will display an airplane flying over a twilight sky located in the **center** of the streen
3. After 3 seconds, the splash screen will disappear and the main application will load

**You can save the state of my application by...**
1. Click the **"Save"** button in the main GUI
2. A confirmation message will appear, stating that the current state of your travel bucket list has been saved to a file
3. The saved file is stored in the **./data/** directory with the name travelbucketlist.json

**You can reload the state of my application by...**
1. Click the **"Load"** button in the main GUI
2. If the file travelbucketlist.json exists in the **./data/** directory, the application will load its contents
3. The list of destinations will update to reflect the saved state, showing the destinations and their statuses

## *Phase 4: Task 2* ##
Below is a representative sample of the events that occur when my program runs.

Event Log:  
Wed Nov 27 10:09:33 PST 2024  
Added destination Paris to My Travel Bucket List  
Wed Nov 27 10:09:36 PST 2024  
Marked Paris as visited in My Travel Bucket List  
Wed Nov 27 10:09:43 PST 2024  
Added destination Shanghai to My Travel Bucket List  
Wed Nov 27 10:09:48 PST 2024  
Added destination Hawaii to My Travel Bucket List  
Wed Nov 27 10:09:54 PST 2024  
Added destination London to My Travel Bucket List  
Wed Nov 27 10:09:56 PST 2024  
Marked London as visited in My Travel Bucket List  
Wed Nov 27 10:10:01 PST 2024  
Filtered visited destinations from My Travel Bucket List  
Wed Nov 27 10:10:02 PST 2024  
Filtered not visited destinations from My Travel Bucket List  
Wed Nov 27 10:10:04 PST 2024  
Displayed all destinations from My Travel Bucket List  
Wed Nov 27 10:10:06 PST 2024  
Removed destination Shanghai from My Travel Bucket List

## *Phase 4: Task 3* ##
**If you had more time to work on the project, what refactoring might you use to improve your design?**

One of the refactoring changes I would make is to rename methods and variables to improve clarity and consistency in the project. In TravelBucketList, I would rename methods such as markAsVisited and addDestination to markDestinationAsVisited and addNewDestination. For variables like visitStatus in my Destination class, I would rename them to isVisited to better indicate its purpose as a boolean flag.

Another change I would make when refactoring is to extract repeated code into helper methods. In my UI classes, the code for clearing the listModel and iterating over destinations appears in multiple methods for filtering and displaying lists. Instead, I would extract the repetitive code into a single method that would make the code more concise and avoid repetition. This would also make it easier to update, display, and improve maintainability as it could all be done in one place. 