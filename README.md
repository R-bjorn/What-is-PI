<div id="top"></div>

# Pi ( π )
<img src="https://user-images.githubusercontent.com/81584201/234070336-63860fbd-6cf5-4da9-abc0-c272a9a69e97.jpg" />
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

# Pi Number Generation and Visualization using Java
## Abstract:
This research paper discusses the implementation of a Java program that generates and visualizes the digits of the mathematical constant pi. The program is composed of two Java classes, `PiNumber.java` and `PiGuiGenerator.java`. The former is responsible for generating the digits of pi while the latter is responsible for displaying the generated digits in a graphical user interface (GUI). The program allows users to specify the width and height of the GUI display and to save the displayed digits as an image file. The paper discusses the algorithms used in `PiNumber.java` and `PiGuiGenerator.java`, as well as the design and implementation of the GUI.

## Introduction:
The mathematical constant pi (π) is an irrational number with an infinite number of decimal places. The value of pi has been known since ancient times and has many applications in mathematics, science, and engineering. The first few digits of pi are 3.14159265358979323846... However, the decimal representation of pi goes on forever and never repeats. In this paper, we discuss the implementation of a Java program that generates and visualizes the digits of pi.

## Methodology:
The program is composed of two Java classes, `PiNumber.java` and `PiGuiGenerator.java`. The former generates the digits of pi using the Bailey-Borwein-Plouffe (BBP) formula. This formula allows for the calculation of individual digits of pi without having to calculate all the preceding digits. The BBP formula is a rapidly converging algorithm that was discovered in 1995 by Simon Plouffe. It uses the inverse tangent function to calculate each hexadecimal digit of pi. The implementation of the BBP formula in `PiNumber.java` uses the `BigInteger` class to perform arithmetic operations on large integers.

The `PiNumber.java` class also contains a method, **`getPiDigits(int startIndex, int limit)`**, that takes two arguments, **`startIndex`** and **`limit`**, and returns a string of pi digits starting from the **`startIndex`** and ending at the **`limit`**. This method uses a variation of the Gauss-Legendre algorithm to generate the digits of pi. The algorithm uses an iterative process to generate the digits of pi one by one. The algorithm was discovered by Carl Friedrich Gauss and Adrien-Marie Legendre in the late 18th century.

The `PiGuiGenerator.java` class is responsible for displaying the digits of pi generated by `PiNumber.java` in a graphical user interface (GUI). The GUI displays the digits in a grid format with user-specified width and height. The GUI also provides buttons for navigating through the generated digits and for saving the displayed digits as an image file. The implementation of the GUI in `PiGuiGenerator.java` uses the Swing library to create and manage GUI components.

## Results:
The implementation of the `PiNumber.java` and `PiGuiGenerator.java` classes allows for the generation and visualization of the digits of pi. The program runs without any errors and generates accurate pi digits. The GUI provides a simple and intuitive interface for users to interact with the program. Users can specify the width and height of the GUI display, navigate through the generated digits using the "Previous" and "Next" buttons, and save the displayed digits as an image file using the "Save as JPG" button.

<details><summary>Pi GUI Generator Frame</summary>
 
 ![OutputResult](https://user-images.githubusercontent.com/81584201/234064659-dc71976b-3b63-446b-b4dc-fe8c8b72617a.jpg)
 
</details>

> Here are some of the results of using different values of width and height. You can see different patterns are being designed as we increase the value of width and height, allowing it to include more digits of pi within one frame. 
> 
> <details><summary>Frame with Width : 2 and Height 2</summary>
>
> This Gif contains 50 images.
>
> ![2x2](https://user-images.githubusercontent.com/81584201/234066064-97939308-8897-416e-9615-57b5f89a6362.gif)
> 
> </details>
> 
> 
> <details><summary>Frame with Width : 4 and Height 4</summary>
>
> This Gif contains 50 images.
>
> ![4x4](https://user-images.githubusercontent.com/81584201/234066083-b666314a-c1f0-44e3-9057-a0fa781b0700.gif)
> 
> </details>
> 
> 
> <details><summary>Frame with Width : 6 and Height 6</summary>
>
> This Gif contains 50 images.
>
> ![6x6](https://user-images.githubusercontent.com/81584201/234066103-b983ae8d-7eaa-4718-a1a5-f3910dc6ac65.gif)
> 
> </details>
> 
> 
> <details><summary>Frame with Width : 10 and Height 10</summary>
>
> This Gif contains 50 images.
>
> ![10x10](https://user-images.githubusercontent.com/81584201/234066148-88fc1edc-5169-48ea-b7e3-246a1b408a9c.gif)
> 
> </details>
> 
> 
> <details><summary>Frame with Width : 20 and Height 20</summary>
>
> This Gif contains 25 images.
>
> ![20x20](https://user-images.githubusercontent.com/81584201/234066246-9ed1c359-8415-419e-9d66-7ea55eb8d6a4.gif)
> 
> </details>
> 
> 
> <details><summary>Frame with Width : 50 and Height 50</summary>
>
> This Gif contains 10 images.
>
> ![50x50](https://user-images.githubusercontent.com/81584201/234066273-a1080471-9d9e-45e5-b05b-a407ad3150c1.gif)
> 
> </details>
> 
## Discussion:
The implementation of the `PiNumber.java` class uses the BBP formula and the Gauss-Legendre algorithm to generate the digits of pi. The BBP formula allows for the calculation of individual digits of pi without having to calculate all the preceding digits. The Gauss-Legendre algorithm uses an iterative process to generate the digits of pi one by one. The implementation of the `PiGuiGenerator.java` class




