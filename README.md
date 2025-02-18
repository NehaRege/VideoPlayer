# VideoPlayer

Video Player that shows a list of Videos using the ExoPlayer sdk



### Architecture - Model View Presenter
I decided to use MVP for the following reasons -
* It has a cleaner architecture and helps in creating a clear separation of concerns between all the layers as opposed to MVC in which the Model View and the Controller are closely coupled. 
* In MVC, the Activity is closely coupled to both the UI and the data access mechanisms. MVP overcomes this problem with the help of a Presenter which is nothing but an Interface and the Model and the View communicate only through this interface. So any change in the backend would not require as much refactoring as would be required in MVC thus increasing the scalability. 
* Also it is easy to read and maintain the code and write unit tests thus making the app more robust.




### OpenSource Libraries Used

**Retrofit** for making network calls

**RxJava2** for enabling reactive programming

**ButterKnife** to create the boilerplate necessary to wire up views and events in the activity.

**GSON** to convert Java objects into JSON and vice versa

**ExoPlayer** Media player library for displaying Videos

**Glide** Image loading





### Notes

**Error View**

I have added an error view card to display an error message incase of any network failure. I feel it is very important to show useful error messages to the user in case of any failure. Right now the app only shows a static error message for all the different scenarios. But if given more time I would handle each case separately with a useful error message. 

**Error View Click**

Clicking the error view will re-try the network access so the user doesn’t remain stuck on the same screen. If given more time, I would cache the Video List using a DB or create a SharedPreferences Manager to persist the data. This way if the network is down, I will directly display the cached list to the user.

**Utils Package - Constants.java**

Added Constants.java file to keep all the final static constant strings in one file that could be used at multiple places. 

**Loading Icon**

Added progress bar to display the loading circle for better UX so the user knows the data is still loading 

**String resources file**

Moved all the strings to the string resources file which is useful for localization and also if you have to use the same string at multiple places. It makes the app look cleaner and easier to maintain.


