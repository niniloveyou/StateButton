# StateButton

中文版这里： 

Do you hate to write a background for each button?
Do you hate to write a bunch of selector?
That's why I'm writing this view.

Here to download demo:
https://play.google.com/store/apps/details?id=info.hoang8f.fbutton.demo

Screenshot
----------
![](https://raw.githubusercontent.com/hoang8f/android-flat-button/master/screenshot/screenshot.gif)

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
| strokeDashWidth        |   0  | strokeDashWidth          | setNormalTextColor(int color)       |
| strokeDashGap        |   0  | strokeDashGap          | setNormalTextColor(int color)       |
| normalStrokeWidth        |   0  | normalStrokeWidth          | setNormalTextColor(int color)       |
| pressedStrokeWidth        |   0  | pressedStrokeWidth          | setNormalTextColor(int color)       |
| unableStrokeWidth        |   0  | unableStrokeWidth          | setNormalTextColor(int color)       |
| normalStrokeColor        |   0  | normalStrokeColor          | setNormalTextColor(int color)       |
| pressedStrokeColor        |   0  | pressedStrokeColor          | setNormalTextColor(int color)       |
| unableStrokeColor        |   0  | unableStrokeColor          | setNormalTextColor(int color)       |
| normalBackgroundColor        |   0  | normalBackgroundColor          | setNormalTextColor(int color)       |
| pressedBackgroundColor        |   0  | pressedBackgroundColor   | setNormalTextColor(int color)       |
| unableBackgroundColor        |   0  | unableBackgroundColor          | setNormalTextColor(int color)       |
| radius        |   0  | radius          | setNormalTextColor(int color)       |
| round        |  false  | round          | setNormalTextColor(int color)       |
| animationDuration        |   0ms  | animationDuration          | setAnimationDuration(int duration)       |

Usage
-----
If the default values of custom attribues did not meet your requirement, you can easily re-config that attributes. This is sample code that you can refer. you can also browse demo app for more details.

### via xml (sample)
-  Define `xmlns:fbutton="http://schemas.android.com/apk/res-auto"` on root of your xml file

```xml
<info.hoang8f.widget.FButton
    ...
   fbutton:buttonColor="@color/color_concrete"
   fbutton:shadowColor="@color/color_asbestos"
   fbutton:shadowEnabled="true"
   fbutton:shadowHeight="5dp"
   fbutton:cornerRadius="5dp"
    ...
     />
```

### via code (sample)
```java
disabledBtn.setButtonColor(getResources().getColor(R.color.color_concrete));
disabledBtn.setShadowColor(getResources().getColor(R.color.color_asbestos));
disabledBtn.setShadowEnabled(true);
disabledBtn.setShadowHeight(5);
disabledBtn.setCornerRadius(5);
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
       
