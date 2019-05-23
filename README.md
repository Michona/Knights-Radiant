# Knights Radiant

## Overview

Text-based adventure game. Explore and enjoy the story. Simple commands and interaction with items.

## How to Run

Make sure to have [Maven](https://maven.apache.org/what-is-maven.html) setup when running the project.
To run, navigate to the root directory of the project, then run the following commands:
```
mvn clean
mvn package
mvn exec:java
```
## Gameplay Controls/Commands

To move north/east/west/south respectively:<br>
`gn` / `ge` / `gw` / `gs`

To pick up item with `itemName`:<br> `p itemName`

To use item with `itemName`:<br>
`u itemName`

To look at inventory:<br>
`i`

To look around: <br>
`ls`

To quit:<br>
`exit`

