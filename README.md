# press

** High-level description of what kind of application your team is thinking of developing **
Our team is thinking of creating a Java application with the use of Swing. The application itself will contain multiple tabs that will enable the user to track their finances and spending. Some example tabs include: past expenses, trends, log a purchase, my portfolio (stocks). With the help of an API, our app will also include a feature where the user will be able to look at trends in their stocks, the gains and losses from this will be included in the total budget value of the user.  


A link to the documentation for an API:
https://site.financialmodelingprep.com/developer/docs

A screenshot of using a tool to try out the API:
![hoppscotch test api call.png](hoppscotch%20test%20api%20call.png)

Example output of running your Java code:
![api call result.png](api%20call%20result.png)

A list of any technical problems blocking progress:
(not exactly technical, but might be an issue): the api we are using has a rate limit of 250 calls / day.
It may be necessary to find a new api depending on where development leads (it is quite hard to find stock apis
with good rates. https://finnhub.io/docs/api is one option (60 calls / minute),
but there does not seem to be easy Java support)
