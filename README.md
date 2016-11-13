# StateButton

###中文版这里： https://github.com/niniloveyou/StateButton/blob/master/README_CHINESE.md

Do you hate to write a background for each button?

Do you hate to write a bunch of selector?

That's why I'm writing this view.


Here to download demo
----------
https://github.com/niniloveyou/StateButton/blob/master/demo.apk

Screenshot
----------
![](https://github.com/niniloveyou/StateButton/blob/master/stateButton.gif)

###Manually
Copy/merge the following files to corresponding folder/file:
   + deadline/stabutton/StateButton.java
   + res/values/attrs.xml

Customizable attributes
-----------------------

|        Attribute       |      default value     |           xml            |                 java                |
|------------------------|------------------------|--------------------------|-------------------------------------|
| normalTextColor        |   original text color  | normalTextColor          | setNormalTextColor(int color)       |
| pressedTextColor       |   original text color  | pressedTextColor          | setPressedTextColor(int color)       |
| unableTextColor        |   original text color  | unableTextColor          | setUnableTextColor(int color)       |
| strokeDashWidth        |   0  | strokeDashWidth          | setStrokeDash(int dashWidth, int dashGap)       |
| strokeDashGap        |   0  | strokeDashGap          | setStrokeDash(int dashWidth, int dashGap)      |
| normalStrokeWidth        |   0  | normalStrokeWidth          | setNormalStrokeWidth(int widht)       |
| pressedStrokeWidth        |   0  | pressedStrokeWidth          | setPressedStrokeWidth(int widht)        |
| unableStrokeWidth        |   0  | unableStrokeWidth          | setUnableStrokeWidth(int widht)        |
| normalStrokeColor        |   0  | normalStrokeColor          | setNormalStrokeColor(int color)       |
| pressedStrokeColor        |   0  | pressedStrokeColor          | setPressedStrokeColor(int color)       |
| unableStrokeColor        |   0  | unableStrokeColor          | setUnableStrokeColor(int color)       |
| normalBackgroundColor        |   0  | normalBackgroundColor          | setNormalBackgroundColor(int color)       |
| pressedBackgroundColor        |   0  | pressedBackgroundColor   | setPressedBackgroundColor(int color)       |
| unableBackgroundColor        |   0  | unableBackgroundColor          | setUnableBackgroundColor(int color)       |
| radius        |   0  | radius          | setRadius(int radius) / setRadius(float[] radii)      |
| round        |  false  | round          | setRound(boolean round)       |
| animationDuration        |   0ms  | animationDuration          | setAnimationDuration(int duration)       |

Usage
-----
If the default values of custom attribues did not meet your requirement, you can easily re-config that attributes. This is sample code that you can refer. you can also browse demo app for more details.

### via xml (sample)
-  Define `xmlns:fbutton="http://schemas.android.com/apk/res-auto"` on root of your xml file

```xml
<deadline.statebutton.StateButton
            android:id="@+id/stateButton"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:text="StateButton"
            
            app:radius="5dp"
            app:round="true"
            app:animationDuration="200"
            
            app:strokeDashGap="2dp"
            app:strokeDashWidth="5dp"
            app:normalStrokeWidth="2dp"
            app:pressedStrokeWidth="2dp"
            app:unableStrokeWidth="2dp"
            
            app:normalStrokeColor="@android:color/white"
            app:pressedStrokeColor="@android:color/white"
            app:unableStrokeColor="@android:color/white"
            
            app:normalTextColor="@android:color/white"
            app:pressedTextColor="@android:color/white"
            app:unableTextColor="@android:color/white"
            
            app:normalBackgroundColor="@color/colorPrimaryDark"
            app:pressedBackgroundColor="@color/colorPrimaryDark"
            app:unableBackgroundColor="@color/colorPrimaryDark"/>
```



Developed By
-------
deadline

Blog :   http://www.jianshu.com/users/25e80ace21b8/latest_articles

MIT License
-------

      Copyright (c) 2016 deadline

      Permission is hereby granted, free of charge, to any person obtaining a copy
      of this software and associated documentation files (the "Software"), to deal
      in the Software without restriction, including without limitation the rights
      to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
      copies of the Software, and to permit persons to whom the Software is
      furnished to do so, subject to the following conditions:

      The above copyright notice and this permission notice shall be included in all
      copies or substantial portions of the Software.

      THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
      IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
      FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
      AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
      LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
      OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
      SOFTWARE.
       
