# SolveSense

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)

## Overview
### Description
Improve your coding and interview skills by collaborating with friends using a virtual whiteboard on-the-go. Can also be used to develop your technical and problem-solving abilities. 

### App Evaluation
- **Category:** Education / Self improvement 
- **Mobile:** This app would be primarily developed for mobile but would perhaps be just as viable on tablets. Functionality wouldn't be limited to mobile devices, however mobile versions could potentially have more features.
- **Story:** Provides a list of questions for the user to choose between. The user can set a timer for each of the questions and utilize the provided whiteboard feature to solve the problem. Additionally the user can virtually collaborate on a question through the whiteboard.
- **Market:** Any individuals, primarily students, who want to improve their coding and technical interview skills.
- **Habit:** This app could be used as often or unoften as the user wanted depending on how much time they have and how much they want to improve these abilities.
- **Scope:** First we would start with pairing people to collaborate on a technical question through the whiteboard, then perhaps this could evolve to include audio/video sharing as well as connecting individuals from around the world.

## Product Spec
### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User logs in with Google to access account and questions
	* Use a guest account if they don’t want to commit
* There are three fragments:
	* White Board
		* Each question has its own whiteboard
		* Whiteboard has “draw,” “undo,” and “clear” buttons
	* Questions
		* A recyclerview list of questions that can be selected to open a more detailed window
		* Start timer to begin working on question and then can use whiteboard
	* Dashboard
		* Profile with account name
		* Recyclerview list of completed questions
		* User can logout

**Optional Nice-to-have Stories**

* Advanced UI/UX design
* Whiteboard has different color options for drawing
* Dashboard
* Keeps track of questions answered
* Can open into fragment to see full question and what you submitted
* Score card
* Categories for questions
* Add your own questions
* Pramp type collaboration

### 2. Screen Archetypes

* Login
	* Use Google account
* Whiteboard 
	* Allows user to draw/write out their solution and thinking
* Questions 
	* Have the description of the question and instruction for what to solve for
* Dashboard
	* Allows the user to look back on what questions they’ve completed
* Settings Screen
* App notification settings

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Login tab
* Whiteboard
* Dashboard 
* Questions

Optional:
* Interview video chats

**Flow Navigation** (Screen to Screen)
* Forced Log-in -> Account creation if no login is available
* Select a question -> Jumps to whiteboard
* Profile -> Access previously solved questions
* Settings -> Toggle settings

### [BONUS] Digital Wireframes & Mockups
<img src="https://github.com/YisakeBeyene/SolveSense/blob/master/SolveSense%20Wireframe.png" height=500>

### [BONUS] Interactive Prototype

## Schema 
### Models
#### Score

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the user score (default field) |
   | user          | Pointer to User| image user |
   | questionsSolved | Number   | number of questions completed by user |
   | solvedAt      | DateTime   | number of likes for the post |
   | createdAt     | DateTime | date when score is created (default field) |
   | updatedAt     | DateTime | date when score is updated (default field) |

#### Question

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the question (default field) |
   | question      | String   | question from list |
   | questionsCount | Number   | number of questions in the list |
   | createdAt     | DateTime | date when question is created (default field) |
   | updatedAt     | DateTime | date when question is updated (default field) |

### Networking
#### List of network requests by screen

- Dashboard Screen
	- (Read/GET) Query all questions the user saved/solved
         ```swift
         let query = PFQuery(className:"Score")
         query.whereKey("user", equalTo: currentUser)
         query.order(byDescending: "createdAt")
         query.findObjectsInBackground { (posts: [PFObject]?, error: Error?) in
            if let error = error { 
               print(error.localizedDescription)
            } else if let scores = scores {
               print("Successfully retrieved \(scores.count) scores.")
           // TODO: Do something with scores...
            }
         }
         ```
	- (Read/GET) List of friends
	- (Delete) Remove saved question
- Questions List Screen
	- (Read/GET) Query all questions the user saved/solved
         ```swift
         let query = PFQuery(className:"Score")
         query.whereKey("user", equalTo: currentUser)
         query.order(byDescending: "createdAt")
         query.findObjectsInBackground { (posts: [PFObject]?, error: Error?) in
            if let error = error { 
               print(error.localizedDescription)
            } else if let scores = scores {
               print("Successfully retrieved \(scores.count) scores.")
           // TODO: Do something with scores...
            }
         }
         ```
- Select Question Screen
   	- (Create/POST) Create a new score object
- Whiteboard Screen
	- (Read/GET) Query saved work on whiteboard
	- (Read/GET) Users on whiteboard
	
#### [OPTIONAL:] Existing API Endpoints
##### Facebook API
- Base URL - [https://developers.facebook.com/docs/facebook-login/android](https://developers.facebook.com/docs/facebook-login/android)

   HTTP Verb | Endpoint | Description
   ----------|----------|------------
    `GET`    | /characters | get all characters
    `GET`    | /characters/?name=name | return specific character by name
    `GET`    | /houses   | get all houses
    `GET`    | /houses/?name=name | return specific house by name
