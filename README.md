_This is an assignment to the [Software Architecture](https://ohm-softa.github.io) class at the [Technische Hochschule Nürnberg](http://www.th-nuernberg.de)._

# Assignment 9: Adapter and Flyweight

This assignment covers the two design patterns _Adapter_ and _Flyweight_.

At first you have to improve the performance by implementing the flyweight pattern.
Afterwards you will use a common Android view element (`RecyclerView`) which already implements the flyweight pattern.
The usage of this view element requires you to implement custom adapter to get your data to the view.

## Setup

1. Create a fork of this repository (button in the right upper corner)
1. Clone the project (get the link by clicking the green _Clone or download button_)
1. Import the project to your Android Studio; it behaves almost the same as IntelliJ.

# Adapter - Intro

The given app generates a random fleet of Star Wars fighters.
To get an overview about your fleet the app shows all your fighters in a `ListView` as so called `card`s containing the following informations:

* an image of the fighter type
* the name of the fighter type
* the name of the pilot

In the last assignments we used the default `ArrayAdapter<>` to transfer our data to a `ListView`.
This is (more or less) only possible for `String` values (or by overriding the `toString()` method as we did last week) but if you want to display data in more complex elements containing more than just a `TextView` you have to implement a custom _adapter_ which is aware of the structure of your element and is able to assign the data correctly.

To accomplish this, the given app already contains a custom `ArrayAdapter<>` (`FighterListAdapter`).
The class contains a `private static` nested class which serves as a container for the view element (a so called view holder, more on that later).
Furthermore it overrides the method `getView()` where it inflates the custom view element (if necessary) and transfers the data from a `Fighter` instance to the view element (the adaptation process).

## Flyweight - Part 1

The count of fighters generated is hard coded in the class `MainActivity` (`FIGHTER_COUNT`).
If you increase the count to 50 or above you'll notice that the emulator won't start anymore because the app loads too many data to the memory while generating the fighters.
If you already had a look at the `FighterFactory` you might have seen that every time a fighter has to be created the factory loads the corresponding image into the memory and assigns the loaded image to the created fighter instance.

Here comes the Flyweight pattern into play:

1. Think about what are the intrinsic and what are the extrinsic parts of the `Fighter` class.  (In case you don't remember the terms or the concept have a look [here](https://hsro-inf-prg3.github.io/09ln-proxy-adapter-flyweight/#flyweight).)
1. Refactor the class `FighterFactory` to follow the Flyweight pattern by caching the intrinsic parts.
1. Modify the process of creation to benefit of your caching mechanism.

_Hint: think of a data structure that enables you to retrieve the matching element with a single call (e.g. `Map<String, X>` or `Map<Class<?>, X>` (Where **X** is a placeholder for your cached type **not** a generic)._

## Flyweight - Part 2

To further improve the performance of the app you can use the Android built-in `RecyclerView`. [This document](https://developer.android.com/training/material/lists-cards.html) explains how to use the `RecyclerView` in combination with the already mentioned _card_ elements.
As the `fighter_item.xml` is already a _card_ element you can ignore all `.xml` parts!

The concept of the `RecyclerView` is also based on the Flyweight pattern.
A `RecyclerView` keeps track of all created _row_ elements and reuses (rebinds) them when they aren't visible any more i.e. when they left the screen because you scrolled up or down.

The following image demonstrates the concept visually (borrowed from [grokkingandroid.com](https://www.grokkingandroid.com/first-glance-androids-recyclerview/)):

![Recycler View - credits to grokkingandroid.com](http://www.grokkingandroid.com/wordpress/wp-content/uploads/2014/08/recycling_of_views.png)

Refactor the app to use a `RecyclerView` to improve the performance by following these steps:

1. Implement a **new** adapter class `FighterRecyclerViewAdapter`.
1. Modify the file `activity_main.xml` and replace the whole given `ListView` node with this snippet:

```xml
<android.support.v7.widget.RecyclerView
        android:id="@+id/fighterListView"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_marginEnd="16dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

1. Replace the `ListView` reference in the class `MainActivity` by a reference to the newly created `RecyclerView`.
1. Assign a new instance of `LinearLayoutManager` as layout manager to your `RecyclerView`.
1. Create an instance of your `FighterRecyclerViewAdapter` with a list of previously generated `Fighter`s and assign it to the reference of your `RecyclerView`.

To implement a custom `RecyclerView.Adapter<>` you also have to implement a new view holder which extends `RecyclerView.ViewHolder`.

View holders are wrappers for custom view elements.
When created they get a reference to the view element, unwrap the single elements and _"cache"_ them as private fields.
Later on you're using the view holder instance to pass data to the view element either by accessing the _"cached"_ fields directly or by calling convenience methods (like in the given `FighterListAdapter`).

In the given use case you can implement the view holder as a `static` nested class.
The Android docs and the blog entry on _grokkingandroid.com_ are containing samples how the view holder may be implemented.
Beside the view holder you're required to implement these methods:

* `onCreateViewHolder(...)` which inflates your custom view element (see the given `FighterListAdapter`)
* `onBindViewHolder(...)` which is doing the adaptation work to transfer the data from a `Fighter` instance to your view element using your custom view holder
* `getItemCount()`

When you have completed the assignment the overall performance of the app should be much better.

_Side note: Keep in mind that the image handling as it was accomplished in this assignment is **not** best practice but was just done this way to provoke performance problems. In real world applications you would just pass the id (using the `R` class) of an image resource to the `ImageView` to let Android care about loading the image._

### A word about when to use a `RecyclerView`

The `RecyclerView` does not have to create 1000 objects of a row element when you have a list of 1000 items because it reuses (recycles) already existing row elements.

But there's still one problem: the `RecyclerView` does not affect the items in the list you want to display. Because of that even if you would have used the `RecyclerView` before you refactored the `FighterFactory` class the memory consumption of the app would have been (approximately) the same because all the images are loaded into the memory before the `RecyclerView` comes into play.