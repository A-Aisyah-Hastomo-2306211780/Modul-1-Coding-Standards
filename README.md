## Reflection 1
In the execution of module 1, there are mainly three clean code principles that are applied.
All variables, functions, and others was named with words that represents its intent, for example, the class Product has productId, productName, and productQuantity as its fields.
Every function only does the minimum job and are composed of roughly five or less lines.
The object Product has its fields private with getter and setter. ProductService has abstract interface to be implemented.
Meanwhile the code doesn't really do well in context of secure coding, there are no identification, data validation, nor authentication implemented.

## Reflection 2
### 1
Unit test gives a sense of relief when the code passed all. 
A 100% code coverage doesn't necessarily mean there is no bugs nor errors.
There is always a possibility some defects is not covered by the test.
Code coverage is only an estimation.
That is why there is no knowing how many unit tests should be made to verify our programs.
### 2
There should be no problem if the product list only contains a few object for testing.
However, the same method would proof uneffective and not clean if there is a lot of product in the database.
CreateProductFunctionalTest only test whether the user can create and see a product and the test is done manually one by one.
Such method would result in many lines in the function and will create clean code issues.
Rather than checking row by row, it would be better to just count how many row there is to check the number of items in product list.