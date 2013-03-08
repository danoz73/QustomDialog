QustomDialog
=======

Qustom helps you make quick custom dialogs for Android. All this is, for the time being, is a way to make it easy to achieve the Holo look in a simple dialog that has a different divider color and text color:

![checkitout](http://i.imgur.com/rVCs1Fc.png)

Usage
-----
```java
QustomDialogBuilder qustomDialogBuilder = new QustomDialogBuilder(context).
		setTitle("Set IP Address").
		setTitleColor("#FF00FF").
		setDividerColor("#FF00FF").
		setMessage("You are now entering the 10th dimension.").

qustomDialogBuilder.show();
```

QustomDialog is really just a single class (`QustomDialogBuild.java`) in addition to one layout file ('qustom_dialog_layout.xml'). You can plug these into your project and use it in its simplest form as shown above. If you have the need for more complex layouts other than just a simple message, you can set custom views as shown below (it references an example layout `example_ip_address_layout.xml`).

```java
QustomDialogBuilder qustomDialogBuilder = new QustomDialogBuilder(context).
		setTitle("Set IP Address").
		setTitleColor("#FF00FF").
		setDividerColor("#FF00FF").
		setMessage("You are now entering the 10th dimension.").
		setCustomView(R.layout.example_ip_address_layout, context).
		setIcon(getResources().getDrawable(R.drawable.ic_launcher));

qustomDialogBuilder.show();
```


License
-------

    Copyright 2010 The Android Open Source Project
    Copyright 2013 Daniel Smith

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.