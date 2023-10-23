# press

## A description of the problem domain your team is tentatively wanting to focus on in the project:

Managing investments, assets and saving can be a daunting task in today’s financially complex world. 
We propose to explore this problem domain through this project and focus on these areas to address the challenges that 
different individuals might face in their quest for financial security and wealth growth.

A big challenge for investors is the need to diversify their investments across different classes of assets like 
stocks, bonds, and real estate. We will investigate tracking one’s stock portfolio and changes along with tracking 
other investment and asset values and allow users to view real-time data on their investment returns, historical 
performance, and compare them to relevant benchmarks. By identifying these trends, users can identify the 
underperforming assets and make the required adjustments. We aim to help users in investment diversification through 
a centralized platform and to ensure they get their up-to-date net-worth calculation.

A finance challenge common to people in all walks of life is budgeting and saving. Effective budgeting is a fundamental 
aspect of financial management. We aim to provide expenses tracking and trend analysis along with savings goal setting 
features. Goal setting and tracking will allow users to define and track their saving goals, whether it's for a down 
payment on a house, retirement, or a dream vacation. To better personal finances, we will also aim to improve the user’s
financial literacy through suggesting education resources instructing on investment strategies, savings tips, and 
financial planning. This project will aim to accomplish the listed tasks while ensuring security and privacy of all 
financial data and will try to ensure the intuition and ease of navigation through features.

In conclusion, this project will discuss the complicated and dynamic problems of personal finance. It strives to empower
people to take control of their financial destinies, make educated decisions, and confidently move towards their 
financial goals by offering a comprehensive, user-friendly platform.


## High-level description of what kind of application your team is thinking of developing:

The application will show a map where the user can click on specific countries which will display the links to the latest news articles from that region. Each news article will contain a title, a designated visual, a short summary, and the date. In addition to that, the user will be presented with the option to filter the news articles based on a given time frame and language. 
Our team hopes to show the news articles that are more relevant to them. The program will also have a feature that will color code the regions based on the top stories in today’s world - essentially an activity heat map. 


## Link to the documentation for an API:
https://site.financialmodelingprep.com/developer/docs

## A screenshot of using a tool to try out the API:
![hoppscotch test api call.png](hoppscotch%20test%20api%20call.png)

## Example output of running your Java code:
![api call result.png](api%20call%20result.png)

## A list of any technical problems blocking progress:
(not exactly technical, but might be an issue): the api we are using has a rate limit of 250 calls / day.
It may be necessary to find a new api depending on where development leads (it is quite hard to find stock apis
with good rates. https://finnhub.io/docs/api is one option (60 calls / minute),
but there does not seem to be easy Java support)
