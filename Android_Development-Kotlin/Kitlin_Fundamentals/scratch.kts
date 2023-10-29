import kotlin.math.pow

/*
1. Find perimeter and surface of trapeze
a = 15, b = 8.25, c = 4.5, d = 5.5, h = 3.825
 */

val a = 15
val b = 8.25
val c = 4.5
val d = 5.5
val h = 3.825

var trapezePerimeter = a + b + c + d
trapezePerimeter

var trapezeSurface = h * (a + b) / 2
trapezeSurface

/*
2. Find circumference and surface of a circle
(r = 12.755, 𝝅=3.14)
 */

val r = 12.755
val pi = Math.PI

var circleCircumference = 2 * pi * r
circleCircumference

var circleSurface = pi * r.pow(2.0)
circleSurface

