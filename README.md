#Organization management

Made as possible, as could. Therefore.

Some things you need to know:
*	First. Before run - define your db configuration in application.properties.
*	Second. The hierarchy "Department <-organization-> employee" is not correct. 
An organization has departments which have employees.
*	Third. As the app is too simple, indeed check for collisions in manager - subordinate relationships, I removed this in output. If you want to see it, use another http-address which show only subs for any manager. Also, it makes an output more cleared. 

All interaction with departments starts on: **“dep/”** URL, with employees on: **“employee/”**.
Managers can see their subordinates by **“/employee/sub/Id”** only.
