# Instructions
To check tests use "./gradlew test" on command line with gradle installed, or/and can navigate to src/main/java and type "java PriceBasket item1 item2 item3 ..."


# Objects 
Item,
Receipt,
PriceBasket (Offers included)

# The way I created the code for the task.
I constructed unit tests using junit in gradle. 

0. Created Item class unit test for name and price.
1. Created Item class with name and price.
2. Encapsulated item class, as well as putting it in an ArrayList in Receipt class.
3. Created subtotal of Receipt.
4. Created Test for PriceBasket.
5. Created another class for the PriceBasket (discounted Receipt).
6. Add Offers using the get methods of Receipt Class.This includes both offers together.
7. Change prices to fit pounds and pennies.
8. Added some extra unit tests that I had not thought about before.
9. Refactored the last bits. 


