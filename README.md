# random-mosaic-extinction

My solution for Chapter 4 Exercise 7 of “Introduction to Programming Using Java”.
Implementation note: For this problem, I replaced the "changeToRandomColor" method with the "setToSampledColor" method, and added the "sampleColor" method.


NOTES This is a javafx program. It requires the javafx library as a dependency. (See bottom of this README for javafx instructions).

Problem Description:
For this exercise, you will do something even more interesting with the Mosaic class that
was discussed in Section 4.7. (Again, don’t forget that you will need Mosaic.java and
MosaicCanvas.java to compile and run your program.)
The program that you write for this exercise should start by filling a mosaic with
random colors. Then repeat the following until the user closes the mosaic window: Se-
lect one of the rectangles in the mosaic at random. Then select one of the neighboring
rectangles—above it, below it, to the left of it, or to the right of it. Copy the color of the
originally selected rectangle to the selected neighbor, so that the two rectangles now have
the same color.
As this process is repeated over and over, it becomes more and more likely that neigh-
boring squares will have the same color. The result is to build up larger color patches. On
the other hand, once the last square of a given color disappears, there is no way for that
color to ever reappear. (Extinction is forever!) If you let the program run long enough,
eventually the entire mosaic will be one uniform color.


Javafx setup instructions:
Download javafx from: https://gluonhq.com/products/javafx/ (I used javafx 12). Save it to a location of your choice.
Unpack the zip folder.
Open my project with your IDE of choice (I use intellij IDEA).
Add the javafx/lib folder as an external library for the project. For intellij, this means going to "project structure" -> "libraries" -> "add library" ->{javafx location}/lib
Add the following as a VM argument for the project: --module-path "{full path to your javafx/lib folder}" --add-modules javafx.controls,javafx.fxml,javafx.base,javafx.graphics,javafx.media,javafx.swing,javafx.web
Build and run the project as normal.

NOTE: The Mosaic.java and MosaicCanvas.java classes were written by the textbook's author.
Much of the implementation of RandomMosaicExtinction.java was also written by the author -- my edits are notated with comments.
