# Spring Sandbox

## 2022 05 30  | Intro
Hello Everyone!  If you're viewing this, you might be wondering what is a Spring Sandbox.  Honestly, this is where I grapple with some ideas I have on Spring-Boot.  Currently, my focus is on our class's capstone project.  At the moment, that project looks to be a recipe app.  Yes, that might not sound too exciting since there are a bagillion recipe blogs and apps.  I do think this might turn out to be very special (the project, not the content) since we might be approaching the concept in a version control management system.  More on that later...

## Currently, Testing out these Concepts for our Capstone
- [X] Simple Access API
  - [X] Pull simple recipe data from API using JS
  - [X] Show data in html with JS
- [X] Simple db table populate
  - [X] Push data into local db using JS and Spring MVC
- [ ] Convert data between Java and JS
  - [X] Use Java to pull data from db, converting it into JSON 
  - [X] Hide JSON data within page 
  - [X] Access JSON data with JS
  - [ ] Convert it into an array of JS obj
- [ ] Complex DB
  - [X] Pull recipe details from API using recipe list (compiled from original API pull)
  - [X] Create modal to show recipe details.  Include hidden form with details data
  - [X] Submit data from modal to the (more complex tables) db
  - [ ] Ensure one-to-many relationship between recipe and ingredients is populated
  - [ ] Scrape API for hundreds of recipes (with different dishType attributes)
- [ ] Set up User
  - [ ] User ability to mark recipe as "would like to try"
  - [ ] Within user profile, allow user to make changes to the recipe
    - [ ] Ensure the og recipe is not edited 
    - [ ] This should cause a new recipe to be created (based on the og-recipe), with UID attribute
    - [ ] Ensure new recipe is viewable by all users
    - [ ] Ensure other users can mark recipe as "would like to try" 
  - [ ] User ability to mark recipe as "favorite" (only within) their profile
- [ ] Revise data management for app
  - [ ] Reset main page search to show only data pulled from local db
  - [ ] Provide users button to find more recipes (pulling data from API)
  - [ ] If user selects recipe as "would like to try", API data is pushed into local db
  - [ ] New recipe data should be present from home search next time user searches for it
