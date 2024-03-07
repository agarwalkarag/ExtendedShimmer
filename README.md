
# Extended Shimmer

[![Kotlin Version](https://img.shields.io/badge/Kotlin-v1.5.21-blue.svg)](https://kotlinlang.org)  [![Platform](https://img.shields.io/badge/Platform-Android-green.svg?style=flat)](https://www.android.com/) [![API](https://img.shields.io/badge/API-23%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=19) [![](https://jitpack.io/v/agarwalkarag/ExtendedShimmer.svg)](https://jitpack.io/#agarwalkarag/ExtendedShimmer)


Getting Started
------------------------
**Extended Shimmer** is a Shimmer library based on Facebook's [Shimmer](https://github.com/facebook/shimmer-android) effect for Android  which has some extra feature which will reduce the developers efforts

The actual features are:

 * It has inbuild recyclerView and its adapter, so need to duplicate XML layout multiple title
 * It has  default shimmer layout, of you don't wish to create New
 * It can handle all type of layout manager with method and XML attributes

### Gradle Dependency
* Add it in your root build.gradle at the end of repositories:

    - For Gradle version 5.x.x or less
    ```
    allprojects {
        repositories {
        ...
        maven { url 'https://jitpack.io' }
        }
    }
    ```
    - For Gradle version 6.x.x and above, in settings.gradle file inside `pluginManagement` block
    ```
      pluginManagement {
        repositories {
        ...
        maven { url 'https://jitpack.io' }
        }
    }
    ```

* Add the dependency in your app's build.gradle file

	```
	dependencies {
		implementation 'com.github.agarwalkarag:ExtendedShimmer:1.3'
	}
	```

### All Attributes

| Attribute | Description | Default |
| --- | --- | --- |
| `app:shimmer_layout` | Set Layout to Display in Effect | `DefaultLayout` |
| `app:shimmer_child_count` | Set Child Count for to display in Shimmer | `10` |
| `app:shimmer_line_alpha` | Set Transparency for Shimmer line | `0.6` |
| `app:shimmer_layout_manager_type` | Set Recycler Layout Manager for Shimmer Effect | `linear_vertical` |
| `app:shimmer_grid_span` | Set Span(Column) count for Grid Layout MAnager | `1` |
| `app:shimmer_visibility` | Set Shimmer visiblity Flag  | `gone` |


### Basic Usage

```
<com.kartik.shimmer.ExtendedShimmer
        android:id="@+id/shimmer"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginVertical="10dp" />

```


### Customization Usage

```
 <com.kartik.shimmer.ExtendedShimmer
        android:id="@+id/shimmer"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginVertical="10dp"
        app:shimmer_child_count="7"
        app:shimmer_grid_span="3"
        app:shimmer_layout="@layout/shimmer_row_grid"
        app:shimmer_layout_manager_type="grid"
        app:shimmer_line_alpha="0.8"
        app:shimmer_visibility="visible" />

```

### Supported Attributes Values

* shimmer_layout_manager_type

  1. linear_vertical  -> To Show View Vertically in Linear Format
  2. linear_horizontal ->  TO Show View Horizontally in Linear Format
  3. grid -> To Show view in Matrix Format with column count


  
### Code

 When you need to switch Shimmer view visiblity programmatically, just use following method

```binding.shimmer.showShimmer()```

```binding.shimmer.hideShimmer()```

 If you want to update shimmer layout reference file programmatically, you can use 

```binding.shimmer.setShimmerLayout()```

 pass layout reference in the parameter of the method
