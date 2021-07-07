# android-device-id1. 

Functional requirements:

1. Create a random UUID if one has not already been created (checks persistence storage for existing one. See below for those persistence stores)

2. Save the newly created UUID to
    
    a. Android’s shared preferences
    
    b. A file on Android’s public file system. The purpose of this file is to preserve the agent’s 
       UUID when the application is deleted. Because when the application is deleted from the device, 
       the shared preference data gets removed by the system. Depending on how users manage their 
       Android devices will depend on what happens when an application is updated in the field. Some 
       might use an MDM or EMM that forces the application to be deleted before installing the updated 
       version. However, if users update the application through the Google Play Store (or just 
       perform an application update without removing the application), then the data in the shared 
       preferences for this application should be preserved (pretty sure about that).

3. Edge cases
    
    a. Inability to save the agent ID to shared preferences should cause the app to stop or at least not take measurements and indicate to the user why
    
    b. Inability to save the agent ID to a public file will not cause the app to stop but does cause that condition to be logged
