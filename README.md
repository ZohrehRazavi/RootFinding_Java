# RootFinding_Java
In this project you can find the root of a function with Bisection Method and Secant Method.
Finding the Root by Bisection Method
In this part, I used the bisection method to figure out the root of the function:
f(x) = 0.1x3+x2-6
First, we need to pick a rough interval [a, b], then put those values into the function. Based on whether the result is closer to 'a' or 'b', we replace one of them, following the bisection method's steps.


The full method is as follows:
Choose an initial interval [a, b] where f(a) and f(b) have opposite signs.
Calculate the midpoint c of the interval: c = a+b2
Replace either 'a' or 'b' with 'c' based on the sign of f(c).
Repeat steps 2 and 3 until the interval becomes small enough or we reach a set number of iterations.


 
Finding the Root by Secant Method
If the bisection method doesn't work, I applied the secant method.
The formula C = b - f(b).(b-a)f(b)-f(a) is utilized iteratively, where 'a' and 'b' are updated as a=b and b=c. This process continues until f(c) is sufficiently close to epsilon (ϵ).

To avoid division by zero, I added a check:

if (Math.abs(f(b) - f(a)) < epsilon) {
    System.out.println("Error: Division by zero encountered.");
    return Double.NaN;
}

Here, ϵ is set to 1.0e-6.

Code Flow
The code first checks if the bisection method is doable. If not, it automatically switches to the secant method. 
 The function f(x) = 0.1x3+x2-6 is consistently utilized as requested.
