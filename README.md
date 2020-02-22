# Log Extract Filterer

This is my solution to the Connect Group ITG test.

## Full Description

You are required to write a program which filters application request log extracts by a number of different properties.

A log extract file contains a header line, followed by zero or more data lines, in comma-separated value format. The
first column is the Unix timestamp of the time the request was made, the second column is the country from which the
request originated, and the third column is the time in milliseconds which the request took to complete. The data lines
are not guaranteed to be in any particular order.

An example file is:
I
    REQUEST_TIMESTAMP,COUNTRY_CODE,RESPONSE_TIME
    1433190845,US,539
    1432917066,GB,37

The features which you must implement have been prototyped in the class com.connectgroup.DefaultLogExtractFilterer. You must implement the
features in this class without changing the signatures of any methods or add any new maven dependencies. You must also provide
evidence that the features you have implemented work correctly.