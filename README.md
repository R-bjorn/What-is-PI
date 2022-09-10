<div id="top"></div>

# Pi ( π )
> Succinctly, pi— which is written as the Greek letter for p, or `π` is a _mathematical constant_ that is the ratio of a circle's circumference to its diameter, approximately equal to **_3.14159_**. Regardless of the circle's size, this ratio will always equal pi.

## Brief Explanation

**pi**, in mathematics, the ratio of the circumference of a circle to its diameter. The symbol π was devised by British mathematician **William Jones** in 1706 to represent the ratio and was later popularized by Swiss mathematician <a href="https://en.wikipedia.org/wiki/Leonhard_Euler">Leonhard Euler</a>. Because pi is irrational (not equal to the ratio of any two whole numbers), its digits do not repeat, and an approximation such as **3.14** or **22/7** is often used for everyday calculations. To **39** decimal places, pi is **__3.141592653589793238462643383279502884197__**

**The Babylonians** (c. 2000 BCE) used 3.125 to approximate pi, a value they obtained by calculating the perimeter of a hexagon inscribed within a circle and assuming that the ratio of the hexagon’s perimeter to the circle’s circumference was 24/25. The Rhind papyrus (c. 1650 BCE) indicates that ancient Egyptians used a value of 256/81 or about 3.16045. Archimedes (c. 250 BCE) took a major step forward by devising a method to obtain pi to any desired accuracy, given enough patience. By inscribing and circumscribing regular polygons about a circle to obtain upper and lower bounds, he obtained 223/71 < π < 22/7, or an average value of about 3.1418. Archimedes also proved that the ratio of the area of a circle to the square of its radius is the same constant.

## My Intentions 

* One of the thing that i think is interesting about **π** is that it is an `irrational number`, meaning that its decimal form neither ends __(i.e. 1/4 = 0.25)__ nor becomes repetitive __(i.e 1/3 = 0.9999999... )__
* According to `Petr Beckmann's : A History of Pi`, the Greek letter π was first used for this purpose by **William Jones** in 1706, probably as __an abbreviation of periphery__, and became standard mathematical notation roughly 30 years later, what if we use the infinite irrational numbers to make a design and see if the design repeats itself or not. 

### Steps to take

1. Make a program that generates infite digits of pi. 
2. Design a Java GUI application to generate 10x10/100x100/500x500/1000x1000/5000x5000/100000x100000/50000/500000/ 1000000x1000000 pixel images of pi digits
3. Compare those images to see if any of them matches!

<a href="#top">(To the top)</a>
## Pi Generator
> Pi is a number that relates a circle's circumference to its diameter. Pi is an irrational number, which means that it is a real number that cannot be expressed by a simple fraction. That's because pi is what mathematicians call an "infinite decimal" — after the decimal point, the digits go on forever and ever.

There are couple of ways to generate pi to nth digit.  

1. Use **Euler's formula** to generate pi but even here, and maybe increase the pricision 

<img src="https://user-images.githubusercontent.com/81584201/189499965-0962fa5b-2361-4d6e-a379-b4182a719ae6.png"/>

2. There is **Srinivasa Ramanujan**'s formula for generating PI which is known for it's rapid convergence. This formula seems difficult to implement and need to increase the pricision. 
   - The most difficult part of implementing Ramanujan's formula will ironically be the sqrt(2) in the constant factor, because there is not built-in sqrt() for `BigDecimal`, so i'll have to write my own.
<img src="https://user-images.githubusercontent.com/81584201/189500048-37056b78-a721-4d4c-9ba9-1a93ec16369e.png"/>
   

3. `Java BigDecimal` has arbitrary precision. `setScale()` allows you to create `BigDecimal` objects with as much precision as you want and most of the arithmetic methods will automatically increase precision as required, but of course the more precision, the slower all calculations will be.

4. There are online tools to generate pi digits upto 1000000 digit. 
   - <a href="https://onlinemathtools.com/generate-pi-digits?&count=100&include-3=true&separator=">OnlineMathTools</a>





