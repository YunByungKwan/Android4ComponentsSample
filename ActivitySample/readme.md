# ActivitySample

## Introduce.
This app has four activities(MainActivity, SecondActivity, ThirdActivity, FourthActivity).<br>
Let's start with the main activity.

## Preview.
<img src="https://user-images.githubusercontent.com/51109517/116893661-33c62080-ac6c-11eb-9647-0b570d2bb806.gif" width=200 height=400/>

## Test.
I wanted to check the activity backstack through a test.<br>
So I used the "dumpsys" command.

### Case 1. No option

Scenario: Main -> Second -> Third -> Fourth -> Main<br>
Result: It can be seen that all activities are stacked.<br>
![image](https://user-images.githubusercontent.com/51109517/116888260-332a8b80-ac66-11eb-83ab-99c27f476253.png)

### Case 2. MainActivity: launchMode="standard"

Scenario: Main -> Second -> Third -> Fourth -> Main<br>
Result: It can be seen that all activities are stacked.<br>
![image](https://user-images.githubusercontent.com/51109517/116890561-ba78fe80-ac68-11eb-8975-b4c7b943131c.png)

### Case 3. FourthActivity: launchMode="singleTop"

Scenario: Main -> Second -> Third -> Fourth -> Fourth<br>
Result: There is only one FourthActivity at the top of the stack.<br>
![image](https://user-images.githubusercontent.com/51109517/119510629-a37f8500-bdac-11eb-9817-603064c1f6af.png)


### Case 4. MainActivity: launchMode="singleTask"

Scenario: Main -> Second -> Third -> Fourth -> Main<br>
Result: Only the MainActivity is left...<br>
![image](https://user-images.githubusercontent.com/51109517/116890346-7ab21700-ac68-11eb-83f9-a44ccf74c384.png)


### Case 5. MainActivity: launchMode="singleInstance"

Scenario: Main -> Second -> Third -> Second -> Main<br>
Result: The MainActivity at the bottom became the root of the new task.<br>
![image](https://user-images.githubusercontent.com/51109517/116889740-e1830080-ac67-11eb-86d2-b103506ea6c7.png)
