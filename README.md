EWS Android API
===============

A java client library to access Exchange web services. The API works against Office 365 Exchange Online as well as on premises Exchange.
For API details, guidelines and examples go to [ews-java-api][ews-java-url].

Building
--------

Check-out the ews-java-api submodule:

```
git submodule init
git submodule update
```

The following command creates a fat jar under ews-android-api/build/libs called **ews-android-api.jar**.

```
./gradlew copySources ews-android-api:build
```

License
-------
[ews-java-api][ews-java-url] is licensed under MIT:

    The MIT License
    Copyright (c) 2012 Microsoft Corporation
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.

Check also the licenses of dependency libraries that are bundled into a fat jar.

 [ews-java-url]: https://github.com/OfficeDev/ews-java-api
