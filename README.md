## SoccerView
Simple fully customizable soccer view

### Installation  
[![](https://jitpack.io/v/yusufceylan/SoccerView.svg)](https://jitpack.io/#yusufceylan/SoccerView/1.0.0)  
``` 
allprojects {  
 repositories { ... maven { url 'https://jitpack.io' } }
 }  
  
dependencies {  
 implementation 'com.github.yusufceylan:SoccerView:lastVersion'
 }  
```  
### Screenshot
<img src="https://raw.githubusercontent.com/yusufceylan/SoccerView/master/art/soccerview.png" width="350">

### Customize
| Attribute | Description | Default
|--|--|--|
|sv_grass_row_number|Number of grass rows|8|
|sv_grass_color_light|Color of grass type 1|holo_green_light|
|sv_grass_color_dark|Color of grass type 2|holo_green_dark|
|sv_line_color|Color of borders|white|
|sv_line_size|Size of borders|4dp|
|sv_padding|Overall padding|16dp|
|sv_goal_post_width|Width of goal post|32dp| 
|sv_goal_post_height|Height of goal post|24dp|
|sv_goal_area_width|Width of goal area|104dp|
|sv_goal_area_height|Height of goal area|64dp|
|sv_corner_radius|Corner radius|12dp|
|sv_center_outer_circle_radius|Radius of outer center circle|24dp|
|sv_center_inner_circle_radius|Radius of inner center circle|6dp|

### References - Useful Articles

This simple project was developed to learn the basics of custom views.

 - Highly inspired from Guy Griv's [this medium article](https://proandroiddev.com/building-a-team-lineup-view-on-android-daaf27e3901e)
 - [Ultime guide for custom views](https://vladsonkin.com/ultimate-guide-to-android-custom-view/)
 - [Mindorks - Understanding Canvas](https://blog.mindorks.com/understanding-canvas-api-in-android)
