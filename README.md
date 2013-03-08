QustomDialog
=======

Qustom helps you make quick custom dialogs for Android. All this is, for the time being, is a way to make it easy to achieve the Holo look in a simple dialog that has a different divider color and text color.

Usage
-----
```java
CustomDialogBuilder customDialogBuilder = new CustomDialogBuilder(v.getContext()).
		setTitle("Set IP Address").
		setTitleColor(HALLOWEEN_ORANGE).
		setDividerColor(HALLOWEEN_ORANGE).
		setMessage("You are now entering the 10th dimension.").
		customSetView(R.layout.example_ip_address_layout, v.getContext()).
		setIcon(getResources().getDrawable(R.drawable.ic_launcher));

customDialogBuilder.show();
```

You can now call `tables.acquire()` to obtain a `Table` instance for playing
Snooker. When you are done with your game call `tables.release(table)` which
will return the `table` instance back to the object pool.

For more examples, run `grep -r 'new PoolableManager' .` in the
`frameworks/base/core/java/` folder of AOSP.



Download
--------

Download [the latest JAR][1] or grab via Maven:

```xml
<dependency>
  <groupId>com.jakewharton</groupId>
  <artifactId>snooker</artifactId>
  <version>(insert latest version)</version>
</dependency>
```



License
-------

    Copyright 2009 The Android Open Source Project
    Copyright 2013 Jake Wharton

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.




 [1]: http://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=com.jakewharton&a=snooker&v=LATEST
 [2]: http://www.flickr.com/photos/pikesley/2769018928/
 [3]: https://twitter.com/readyState/status/308649902827786240